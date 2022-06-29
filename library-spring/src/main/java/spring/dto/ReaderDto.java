package spring.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ReaderDto {

    private Long   id;
    private String fio;
    private String phone;
    private String address;
    private Date birthday;

}
