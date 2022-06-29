package spring.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import spring.dao.GenreDao;
import spring.models.Genre;

import java.util.List;

@Service
@Transactional
public class GenreService {

    private GenreDao genreDao;

    public GenreService(GenreDao genreDao) {
        this.genreDao = genreDao;
    }

    public List<Genre> findAllGenre() {
        return this.genreDao.findAll();
    }

}
