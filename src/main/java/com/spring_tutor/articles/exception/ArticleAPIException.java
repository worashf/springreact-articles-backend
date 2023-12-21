package com.spring_tutor.articles.exception;

import org.springframework.http.HttpStatus;

public class ArticleAPIException  extends RuntimeException{

	  private HttpStatus status;
	  private String message;
	public ArticleAPIException(HttpStatus status, String message) {
		super(message);
		this.status = status;
		this.message = message;
	}
	  public HttpStatus getStatus() {
	        return status;
	    }

	    @Override
	    public String getMessage() {
	        return message;
	    }
	  
}
