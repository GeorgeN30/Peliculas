package com.star.play.persistence;

import com.star.play.domain.dto.MovieDto;
import com.star.play.domain.dto.UpdateMovieDto;
import com.star.play.domain.exception.MovieAlreadyExistsException;
import com.star.play.domain.exception.MovieDoesNotExistsException;
import com.star.play.domain.repository.MovieRepository;
import com.star.play.persistence.crud.CrudMovieEntity;
import com.star.play.persistence.entity.MovieEntity;
import com.star.play.persistence.mapper.MovieMapper;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
public class MovieEntityRepository implements MovieRepository {

    private final CrudMovieEntity crudMovieEntity;
    private final MovieMapper movieMapper;


    public MovieEntityRepository(CrudMovieEntity crudMovieEntity, MovieMapper movieMapper) {
        this.crudMovieEntity = crudMovieEntity;
        this.movieMapper = movieMapper;
    }

    @Override
    public List<MovieDto> getAll(){
       return this.movieMapper.toDto(this.crudMovieEntity.findAll());
    }

    @Override
    public MovieDto getById(long id) {
        MovieEntity movieEntity = this.crudMovieEntity.findById(id).orElse(null);
        return movieMapper.toDto(movieEntity);
    }

    @Override
    public MovieDto add(MovieDto movieDto) {
        if(this.crudMovieEntity.findFirstByTitulo(movieDto.title()) != null){
            throw new MovieAlreadyExistsException(movieDto.title());
        }

       MovieEntity movieEntity = this.movieMapper.toEntity(movieDto);
       movieEntity.setEstado("D");

       return this.movieMapper.toDto(crudMovieEntity.save(movieEntity));

    }

    @Override
    public MovieDto update(long id, UpdateMovieDto updateMovieDto) {
        if(this.crudMovieEntity.findById(id).isEmpty()){
            throw new MovieDoesNotExistsException(id);
        }
        MovieEntity movieEntity = this.crudMovieEntity.findById(id).orElse(null);

        if (movieEntity == null) return null;
        this.movieMapper.updateEntityFromDto(updateMovieDto, movieEntity);
        return this.movieMapper.toDto(crudMovieEntity.save(movieEntity));
    }

    @Override
    public void delete(long id) {
        if(this.crudMovieEntity.findById(id).isEmpty()){
            throw new MovieDoesNotExistsException(id);
        }
       this.crudMovieEntity.deleteById(id);
    }
}
