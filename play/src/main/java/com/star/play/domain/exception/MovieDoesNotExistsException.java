package com.star.play.domain.exception;

public class MovieDoesNotExistsException extends RuntimeException{
    public MovieDoesNotExistsException(long id){
        super("La pelicula con el id "+id+" No existe.");
    }
}
