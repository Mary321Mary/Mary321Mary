package spring.models;

import java.util.Date;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Reader {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long   id;
	
	private String fio;
	private String phone;
	private String address;
	private Date birthday;

	/*@ManyToMany
	@JsonIgnore
	@JoinTable(name = "booking",
			joinColumns = @JoinColumn(name = "reader_id"),
			inverseJoinColumns = @JoinColumn(name = "book_id")
	)
	private List<Book> books;*/

}
