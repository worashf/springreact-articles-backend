package com.spring_tutor.articles.exception;

import org.springframework.http.HttpStatus;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;


import java.util.Date;


@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorDetails handleResourceNotFoundException(ResourceNotFoundException exception,
                                                        WebRequest webRequest) {
        return createErrorDetails(exception.getMessage(), webRequest.getDescription(false));
    }

    @ExceptionHandler(ArticleAPIException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorDetails handleBlogAPIException(ArticleAPIException exception,
                                               WebRequest webRequest) {
        return createErrorDetails(exception.getMessage(), webRequest.getDescription(false));
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ErrorDetails handleGlobalException(Exception exception,
                                              WebRequest webRequest) {
        return createErrorDetails(exception.getMessage(), webRequest.getDescription(false));
    }


    private ErrorDetails createErrorDetails(String message, String description) {
        return new ErrorDetails(new Date(), message, description);
    }
}
