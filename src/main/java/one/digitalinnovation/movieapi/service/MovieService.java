package one.digitalinnovation.movieapi.service;

import one.digitalinnovation.movieapi.dto.request.MovieDTO;
import one.digitalinnovation.movieapi.dto.response.MessageResponseDTO;
import one.digitalinnovation.movieapi.entity.Movie;
import one.digitalinnovation.movieapi.exception.MovieNotFoundException;
import one.digitalinnovation.movieapi.mapper.MovieMapper;
import one.digitalinnovation.movieapi.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MovieService {
    @Autowired
    public MovieRepository repository;

    public MessageResponseDTO createMovie(MovieDTO movieDTO) {
        Movie movieToSave = MovieMapper.INSTANCE.toModel(movieDTO);
        Movie savedMovie = repository.save(movieToSave);
        return createMessageResponse(savedMovie.getId(), "Created movie with ID ");
    }

    public List<MovieDTO> findAll() {
        return repository.findAll()
                .stream().map(MovieMapper.INSTANCE::toDTO)
                .collect(Collectors.toList());
    }

    public MovieDTO findById(Long id) throws MovieNotFoundException {
        Movie movie = verifyIfExists(id);
        return MovieMapper.INSTANCE.toDTO(movie);
    }

    public MessageResponseDTO updateById(Long id, MovieDTO movieDTO) throws MovieNotFoundException {
        verifyIfExists(id);
        Movie movieToUpdate = MovieMapper.INSTANCE.toModel(movieDTO);
        Movie updateMovie = repository.save(movieToUpdate);
        return createMessageResponse(updateMovie.getId(), "Update Person with ID ");
    }

    public void deleteById(Long id) throws MovieNotFoundException {
        verifyIfExists(id);
        repository.deleteById(id);
    }

    private Movie verifyIfExists(Long id) throws MovieNotFoundException {
        return repository.findById(id)
                .orElseThrow(() -> new MovieNotFoundException(id));
    }

    private MessageResponseDTO createMessageResponse(Long id , String message) {
        return MessageResponseDTO
                .builder()
                .message(message + id)
                .build();
    }
}
