package one.digitalinnovation.movieapi.dto.request;

import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.Size;

@Data
@Builder
public class MovieDTO {
    private Long id;

    @Size(min = 2, max = 100)
    private String title;

    @Size(min = 2, max = 100)
    private String synopsis;

    @Size(min = 2, max = 20)
    private String gender;

    @Size(min = 2, max = 4)
    private String year;
}
