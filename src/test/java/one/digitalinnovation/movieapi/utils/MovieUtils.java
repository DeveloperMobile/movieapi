package one.digitalinnovation.movieapi.utils;

import one.digitalinnovation.movieapi.dto.request.MovieDTO;
import one.digitalinnovation.movieapi.entity.Movie;

public class MovieUtils {
    private static final String TITLE = "Homem Aranha";
    private static final String SYNOPSIS = "Peter Parker (Tobey Maguire) é um jovem estudioso que vive com seus tios, Ben (Cliff Robertson) e May (Rosemary Harris), desde que seus pais faleceram. Inteligente e com um grande interesse pela ciência.";
    private static final String GENDER = "Super Hro";
    private static final String YEAR = "2002";
    private static final long MOVIE_ID = 1L;

    public static MovieDTO createFakeDTO() {
        return MovieDTO.builder()
                .title(TITLE)
                .synopsis(SYNOPSIS)
                .gender(GENDER)
                .year(YEAR)
                .build();
    }

    public static Movie createFakeEntity() {
        return Movie.builder()
                .id(MOVIE_ID)
                .title(TITLE)
                .synopsis(SYNOPSIS)
                .gender(GENDER)
                .year(YEAR)
                .build();
    }
}
