package com.spring_tutor.articles.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring_tutor.articles.DTO.AuthorDTO;
import com.spring_tutor.articles.DTO.AuthorResponse;
import com.spring_tutor.articles.service.AuthorService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/v1/authors")
public class AuthorController {

	@Autowired
	private AuthorService authorService;

	@PostMapping("/create")
	public ResponseEntity<AuthorResponse> saveAuthor(@RequestBody @Valid AuthorDTO authorDTO) {
		AuthorResponse authorResponse = null;
		AuthorDTO createdAuthor = authorService.createAuthor(authorDTO);
		if (createdAuthor != null) {
			authorResponse = new AuthorResponse(true, createdAuthor);
		}

		return ResponseEntity.status(HttpStatus.CREATED).body(authorResponse);
	}

	@GetMapping("/{id}")
	public ResponseEntity<AuthorDTO> retrieveAuthorById(@PathVariable Long id) {
		AuthorDTO author = authorService.getAuthorById(id);
		return ResponseEntity.ok().body(author);
	}

	@GetMapping
	public ResponseEntity<List<AuthorDTO>> retrieveAuthors() {

		List<AuthorDTO> authors = authorService.getAllAuthors();

		return ResponseEntity.ok().body(authors);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Boolean> updateAuthor(@PathVariable Long id, @RequestBody AuthorDTO authorDTO) {

		boolean isUpdated = authorService.updateAuthor(id, authorDTO);

		return ResponseEntity.ok().body(isUpdated);

	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Boolean> removeAuthor(@PathVariable Long id) {

		System.out.println("id:" + id);
		boolean isDeleted = authorService.deleteAuthor(id);

		return ResponseEntity.ok().body(isDeleted);

	}

}
