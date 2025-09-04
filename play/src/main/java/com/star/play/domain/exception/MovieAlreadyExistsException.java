package com.star.play.domain.exception;

public class MovieAlreadyExistsException extends RuntimeException{
    public MovieAlreadyExistsException(String movieTitle){
        super("La pelicula " + movieTitle + " ya existe.");
    }
}
