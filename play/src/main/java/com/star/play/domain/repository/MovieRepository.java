package com.star.play.domain.repository;

import com.star.play.domain.dto.MovieDto;

import java.util.List;

public interface MovieRepository {
    List<MovieDto> getAll();
}
