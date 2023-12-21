package com.spring_tutor.articles.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.spring_tutor.articles.model.Article;

@Repository
public interface ArticleRepository extends JpaRepository<Article, Long> {
	public Article findByArticleId(Long articleId);

	@Query("SELECT ar FROM Article  ar JOIN FETCH ar.author ath WHERE ar.articleId =:articleId")
	public Article findArticleWIthAuthorById(Long articleId);

	@Query("SELECT ar FROM Article  ar JOIN FETCH ar.author ath WHERE ath.authorId =:authorId")
	public List<Article> findAllArticleWIthAuthorByAuthorId(Long authorId);

	@Query("SELECT ar FROM Article  ar JOIN FETCH ar.author ath")
	public List<Article> findAllArticleWIthAuthor();

}
