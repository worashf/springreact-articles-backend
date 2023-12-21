package com.spring_tutor.articles.service;

import java.util.List;

import com.spring_tutor.articles.DTO.AuthorDTO;

public interface AuthorService {
	public AuthorDTO createAuthor(AuthorDTO autherDTO);

	public boolean updateAuthor(Long id, AuthorDTO authorDTO);

	public AuthorDTO getAuthorById(Long authorId);

	public List<AuthorDTO> getAllAuthors();

	public boolean deleteAuthor(Long authorId);

}
