package spring.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import spring.models.Genre;

public interface GenreDao extends JpaRepository<Genre, Long> {
}
