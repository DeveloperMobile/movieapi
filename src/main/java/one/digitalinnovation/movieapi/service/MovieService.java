package one.digitalinnovation.movieapi.service;

import one.digitalinnovation.movieapi.dto.request.MovieDTO;
import one.digitalinnovation.movieapi.dto.response.MessageResponseDTO;
import one.digitalinnovation.movieapi.entity.Movie;
import one.digitalinnovation.movieapi.mapper.MovieMapper;
import one.digitalinnovation.movieapi.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MovieService {
    @Autowired
    public MovieRepository repository;

    public MessageResponseDTO createMovie(MovieDTO movieDTO) {
        Movie movieToSave = MovieMapper.INSTANCE.toModel(movieDTO);
        Movie savedMovie = repository.save(movieToSave);
        return createMessageResponse(savedMovie.getId(), "Created person with ID ");
    }

    private MessageResponseDTO createMessageResponse(Long id , String message) {
        return MessageResponseDTO
                .builder()
                .message(message + id)
                .build();
    }
}
