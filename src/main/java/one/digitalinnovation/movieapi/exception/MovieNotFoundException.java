package one.digitalinnovation.movieapi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class MovieNotFoundException extends Exception {
    public MovieNotFoundException(Long id) {
        super("Person not found with ID " + id);
    }
}
