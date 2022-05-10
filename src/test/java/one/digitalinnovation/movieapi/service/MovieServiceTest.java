package one.digitalinnovation.movieapi.service;

import one.digitalinnovation.movieapi.dto.request.MovieDTO;
import one.digitalinnovation.movieapi.dto.response.MessageResponseDTO;
import one.digitalinnovation.movieapi.entity.Movie;
import one.digitalinnovation.movieapi.repository.MovieRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static one.digitalinnovation.movieapi.utils.MovieUtils.createFakeDTO;
import static one.digitalinnovation.movieapi.utils.MovieUtils.createFakeEntity;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class MovieServiceTest {
    @Mock
    private MovieRepository movieRepository;

    @InjectMocks
    private MovieService movieService;

    @Test
    void testGivenMovieDTOThenReturnSavedMessage() {
        MovieDTO movieDTO = createFakeDTO();
        Movie expectedSavedMovie = createFakeEntity();

        when(movieRepository.save(any(Movie.class))).thenReturn(expectedSavedMovie);

        MessageResponseDTO expectedSuccdessMessage = createExpectedMessageResponse(expectedSavedMovie.getId());
        MessageResponseDTO successMessage = movieService.createMovie(movieDTO);

        assertEquals(expectedSuccdessMessage, successMessage);
    }

    private MessageResponseDTO createExpectedMessageResponse(Long id) {
        return MessageResponseDTO
                .builder()
                .message("Created movie with ID " + id)
                .build();
    }
}
