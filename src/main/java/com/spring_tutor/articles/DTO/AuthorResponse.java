package com.spring_tutor.articles.DTO;

public class AuthorResponse {
	private boolean success;
	private AuthorDTO author;

	public AuthorResponse(boolean success, AuthorDTO author) {
		this.success = success;
		this.author = author;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public AuthorDTO getAuthor() {
		return author;
	}

	public void setAuthor(AuthorDTO author) {
		this.author = author;
	}

}
