package com.spring_tutor.articles.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.spring_tutor.articles.model.Author;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {

	public Author findByAuthorId(Long authorId);
}
