package spring.models;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long   id;
    
	private String fio;

//	@ManyToMany
//	@JsonIgnore
//	@JoinTable(name = "authorbook",
//			joinColumns = @JoinColumn(name = "book_id"),
//			inverseJoinColumns = @JoinColumn(name = "author_id")
//	)
//	private List<Book> books;

}
