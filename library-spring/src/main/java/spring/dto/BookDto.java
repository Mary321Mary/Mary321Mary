package spring.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import spring.models.Book;
import spring.models.Genre;
import spring.models.Publishing;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BookDto {

    private Book book;
    private List<Publishing> publishing;
    private List<Genre> genres;

}
