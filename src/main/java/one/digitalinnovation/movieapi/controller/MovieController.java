package one.digitalinnovation.movieapi.controller;

import one.digitalinnovation.movieapi.dto.request.MovieDTO;
import one.digitalinnovation.movieapi.dto.response.MessageResponseDTO;
import one.digitalinnovation.movieapi.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/movie")
public class MovieController {
    @Autowired
    public MovieService service;
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MessageResponseDTO createMovie(@RequestBody @Valid MovieDTO movieDTO) {
        return service.createMovie(movieDTO);
    }
}
