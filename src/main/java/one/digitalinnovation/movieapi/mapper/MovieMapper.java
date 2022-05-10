package one.digitalinnovation.movieapi.mapper;

import one.digitalinnovation.movieapi.dto.request.MovieDTO;
import one.digitalinnovation.movieapi.entity.Movie;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface MovieMapper {
    MovieMapper INSTANCE = Mappers.getMapper(MovieMapper.class);

    Movie toModel(MovieDTO movieDTO);
    MovieDTO toDTO(Movie movie);
}
