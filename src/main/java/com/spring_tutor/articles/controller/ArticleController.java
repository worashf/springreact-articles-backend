package com.spring_tutor.articles.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring_tutor.articles.DTO.ArticleDTO;
import com.spring_tutor.articles.DTO.ArticleResponse;
import com.spring_tutor.articles.DTO.AuthorDTO;
import com.spring_tutor.articles.model.Article;
import com.spring_tutor.articles.service.ArticleService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/v1/articles")
public class ArticleController {

	@Autowired
	private ArticleService articleService;

	@PostMapping("/create")
	public ResponseEntity<ArticleDTO> createArticle(@RequestBody @Valid ArticleDTO articleDTO) {

		ArticleDTO createdArticle = articleService.createArticle(articleDTO);
		return ResponseEntity.status(HttpStatus.CREATED).body(createdArticle);
	}

	@GetMapping
	public ResponseEntity<List<ArticleResponse>> retrieveAuthors() {

		List<ArticleResponse> articles = articleService.getAllArticles();

		return ResponseEntity.ok().body(articles);
	}

	@GetMapping("/{id}")
	public ResponseEntity<ArticleResponse> retrieveArticleById(@PathVariable Long id) {

		ArticleResponse article = articleService.getArticleWIthAuthorById(id);
		return ResponseEntity.ok().body(article);
	}

}
