package com.spring_tutor.articles.service.serviceImpl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring_tutor.articles.DTO.AuthorDTO;
import com.spring_tutor.articles.exception.ResourceNotFoundException;
import com.spring_tutor.articles.model.Author;
import com.spring_tutor.articles.repository.AuthorRepository;
import com.spring_tutor.articles.service.AuthorService;

@Service
public class AuthorServiceImpl implements AuthorService {

	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	private AuthorRepository authorRepository;

	@Override

	// create author service
	public AuthorDTO createAuthor(AuthorDTO autherDTO) {

		// convert userDTO to Author JPA entity
		Author author = modelMapper.map(autherDTO, Author.class);
		Author savedAuthor = authorRepository.save(author);
		// convert saved author JPA entity to author DTO, and return'
		return modelMapper.map(savedAuthor, AuthorDTO.class);
	}

	@Override
	public boolean updateAuthor(Long id, AuthorDTO authorDTO) {
		Optional<Author> optionalAuthor = authorRepository.findById(id);

		if (optionalAuthor.isPresent()) {
			Author existingAuthor = optionalAuthor.get();
			existingAuthor.setName(authorDTO.getName());
			existingAuthor.setGender(authorDTO.getGender());
			existingAuthor.setEmail(authorDTO.getEmail());
			existingAuthor.setAge(authorDTO.getAge());
			authorRepository.save(existingAuthor);
			return true;
		} else {

			return false;
		}
	}

	@Override
	public AuthorDTO getAuthorById(Long authorId) {
		Author author = authorRepository.findByAuthorId(authorId);
		if (author == null) {
			throw new ResourceNotFoundException("Author", "id", authorId);
		}

		return modelMapper.map(author, AuthorDTO.class);
	}

	@Override
	public List<AuthorDTO> getAllAuthors() {
		List<Author> authors = authorRepository.findAll();
		return authors.stream().map(author -> modelMapper.map(author, AuthorDTO.class)).collect(Collectors.toList());
	}

	@Override
	public boolean deleteAuthor(Long authorId) {
		// TODO Auto-generated method stub
		boolean deleted = false;
		Author author = authorRepository.findByAuthorId(authorId);
		if (author != null) {
			authorRepository.delete(author);
			deleted = true;
		}

		return deleted;
	}

}
