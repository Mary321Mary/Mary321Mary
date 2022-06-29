package spring.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import spring.models.Author;

import java.util.List;

public interface AuthorDao extends JpaRepository<Author, Long> {

    List<Author> findAuthorsByFioContaining(String name);

}
