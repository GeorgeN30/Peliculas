package com.star.play.web.exception;

import com.star.play.domain.exception.MovieAlreadyExistsException;
import com.star.play.domain.exception.MovieDoesNotExistsException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler(MovieAlreadyExistsException.class)
    public ResponseEntity<Error> handleException(MovieAlreadyExistsException exception){
        Error error = new Error("movie-already-exists", exception.getMessage());
        return ResponseEntity.badRequest().body(error);
    }

    @ExceptionHandler(MovieDoesNotExistsException.class)
    public ResponseEntity<Error> movieHandleException(MovieDoesNotExistsException exception){
        Error error = new Error("movie-does-not-exist", exception.getMessage());
        return ResponseEntity.badRequest().body(error);
    }
}
