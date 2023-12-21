package com.spring_tutor.articles.service;

import java.util.List;

import com.spring_tutor.articles.DTO.ArticleDTO;
import com.spring_tutor.articles.DTO.ArticleResponse;
import com.spring_tutor.articles.DTO.AuthorDTO;
import com.spring_tutor.articles.model.Article;

public interface ArticleService {
	public ArticleDTO createArticle(ArticleDTO articleDTO);

	public ArticleDTO getArticleById(Long articleId);

	public ArticleResponse getArticleWIthAuthorById(Long articleId);

	public List<ArticleResponse> getAllArticles();
}
