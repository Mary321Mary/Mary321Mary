package spring.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import spring.models.Book;

import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class IssuedDto {

    private Long id;
    private Book book;
    private ReaderDto readerDto;
    private String employee;
    private Date dateIss;
    private Date dateReturn;

}
