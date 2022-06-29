package spring.models;

import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long   id;
	private String name;
	private int year;
	private int pages;
    private String description;
    private String image;
    private int count;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "publ_id")
	private Publishing publishing;
    
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "genre_id")
	private Genre genre;

    @ManyToMany
    @JoinTable(name = "authorbook",
            joinColumns = @JoinColumn(name = "book_id"),
            inverseJoinColumns = @JoinColumn(name = "author_id")
    )
    private List<Author> authors;

}
