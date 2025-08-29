package com.star.play.domain.service;

import com.star.play.domain.dto.MovieDto;
import com.star.play.domain.dto.UpdateMovieDto;
import com.star.play.domain.repository.MovieRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService{
    private final MovieRepository movieRepository;

    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public List<MovieDto> getAll(){
        return this.movieRepository.getAll();
    }

    public MovieDto getById(long id){
        return this.movieRepository.getById(id);
    }

    public MovieDto add(MovieDto movieDto){
        return this.movieRepository.add(movieDto);
    }

    public MovieDto update(long id, UpdateMovieDto updateMovieDto){
        return this.movieRepository.update(id, updateMovieDto);
    }

    public void delete(long id){
        this.movieRepository.delete(id);
    }
}
