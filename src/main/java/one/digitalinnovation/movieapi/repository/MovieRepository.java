package one.digitalinnovation.movieapi.repository;

import one.digitalinnovation.movieapi.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie, Long> {
}
