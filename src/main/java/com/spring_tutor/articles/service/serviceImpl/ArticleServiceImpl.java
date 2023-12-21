package com.spring_tutor.articles.service.serviceImpl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring_tutor.articles.DTO.ArticleDTO;
import com.spring_tutor.articles.DTO.ArticleResponse;
import com.spring_tutor.articles.DTO.AuthorDTO;
import com.spring_tutor.articles.model.Article;
import com.spring_tutor.articles.model.Author;
import com.spring_tutor.articles.repository.ArticleRepository;
import com.spring_tutor.articles.service.ArticleService;
import com.spring_tutor.articles.service.AuthorService;

@Service
public class ArticleServiceImpl implements ArticleService {
	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	private AuthorService authorService;

	@Autowired
	private ArticleRepository articleRepo;

	@Override
	public ArticleDTO createArticle(ArticleDTO articleDTO) {

		AuthorDTO authDTO = authorService.getAuthorById(articleDTO.getAuthorId());

		if (authDTO != null) {

			Author author = modelMapper.map(authDTO, Author.class);
			Article article = modelMapper.map(articleDTO, Article.class);
			article.setAuthor(author);
			Article savedArticle = articleRepo.save(article);
			return modelMapper.map(savedArticle, ArticleDTO.class);
		}
		return null;
	}

	@Override
	public ArticleDTO getArticleById(Long articleId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArticleResponse getArticleWIthAuthorById(Long articleId) {
		Article article = articleRepo.findArticleWIthAuthorById(articleId);

		return convertToArticleDetailResponse(article);
	}

	@Override
	public List<ArticleResponse> getAllArticles() {
		List<Article> articles = articleRepo.findAllArticleWIthAuthor();
		return articles.stream().map(this::convertToArticleResponse).collect(Collectors.toList());
	}

	private ArticleResponse convertToArticleResponse(Article article) {
		ArticleResponse articleRes = new ArticleResponse();
		articleRes.setId(article.getArticleId());
		articleRes.setTitle(article.getTitle());

		if (article.getAuthor() != null) {
			articleRes.setAuthorName(article.getAuthor().getName());
			articleRes.setAuthorId(article.getAuthor().getAuthorId());
			articleRes.setAuthorEmail(article.getAuthor().getEmail());
		}

		return articleRes;
	}
	
	private ArticleResponse convertToArticleDetailResponse(Article article) {
		ArticleResponse articleRes = new ArticleResponse();
		articleRes.setId(article.getArticleId());
		articleRes.setTitle(article.getTitle());
		articleRes.setBody(article.getBody());
		articleRes.setCreatedAt(article.getCreatedAt());

		if (article.getAuthor() != null) {
			articleRes.setAuthorName(article.getAuthor().getName());
			articleRes.setAuthorId(article.getAuthor().getAuthorId());
			articleRes.setAuthorEmail(article.getAuthor().getEmail());
		}

		return articleRes;
	}

}
