package com.star.play.persistence.crud;

import com.star.play.persistence.entity.MovieEntity;
import org.springframework.data.repository.CrudRepository;

public interface CrudMovieEntity extends CrudRepository<MovieEntity, Long> {

}
