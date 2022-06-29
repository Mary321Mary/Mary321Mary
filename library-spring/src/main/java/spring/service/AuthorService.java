package spring.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import spring.dao.AuthorDao;
import spring.dao.BookDao;
import spring.models.Author;

import java.util.List;

@Service
@Transactional
public class AuthorService {

    private AuthorDao authorDao;

    public AuthorService(AuthorDao authorDao) {
        this.authorDao = authorDao;
    }

    public List<Author> findAllAuthors() {
        return this.authorDao.findAll();
    }

    public List<Author> findAuthorsByNameContaining(String name) {
        return this.authorDao.findAuthorsByFioContaining(name);
    }

}
