package spring.unit;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import spring.dao.*;
import spring.models.Book;
import spring.models.Reader;
import spring.models.User;
import spring.service.BookService;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.only;

@ExtendWith(MockitoExtension.class)
public class BookServiceTest {

    public static final Long ID = 2L;
    public static final String NAME = "дочка";
    public static final String USERNAME = "mary";
    public static final List<Book> LIST = new ArrayList<>();

    @Mock
    private BookDao bookDao;
    @Mock
    private ReaderDao readerDao;
    @Mock
    private UserDao userDao;

    @InjectMocks
    private BookService bookService;

    @Test
    void shouldFindAllBooks() {
        given(bookDao.findAll()).willReturn(LIST);

        List<Book> expected = new ArrayList<>();
        List<Book> actual = bookService.findAllBooks();

        assertEquals(expected, actual);

        then(bookDao).should(only()).findAll();
        then(readerDao).shouldHaveNoInteractions();
        then(userDao).shouldHaveNoInteractions();
    }

    @Test
    void shouldFindBooksByGenreId() {
        given(bookDao.findBooksByGenreId(ID)).willReturn(LIST);

        List<Book> expected = new ArrayList<>();
        List<Book> actual = bookService.findBooksByGenreId(ID);

        assertEquals(expected, actual);

        then(bookDao).should(only()).findBooksByGenreId(ID);
        then(readerDao).shouldHaveNoInteractions();
        then(userDao).shouldHaveNoInteractions();
    }

    @Test
    void shouldFindBooksByPublishingId() {
        given(bookDao.findBooksByPublishingId(ID)).willReturn(LIST);

        List<Book> expected = new ArrayList<>();
        List<Book> actual = bookService.findBooksByPublishingId(ID);

        assertEquals(expected, actual);

        then(bookDao).should(only()).findBooksByPublishingId(ID);
        then(readerDao).shouldHaveNoInteractions();
        then(userDao).shouldHaveNoInteractions();
    }

    @Test
    void shouldFindBooksByNameContaining() {
        given(bookDao.findBooksByNameContaining(NAME)).willReturn(LIST);

        List<Book> expected = new ArrayList<>();
        List<Book> actual = bookService.findBooksByNameContaining(NAME);

        assertEquals(expected, actual);

        then(bookDao).should(only()).findBooksByNameContaining(NAME);
        then(readerDao).shouldHaveNoInteractions();
        then(userDao).shouldHaveNoInteractions();
    }

    @Test
    void shouldFindBooksByAuthors() {
        given(bookDao.findBooksByAuthors(ID)).willReturn(LIST);

        List<Book> expected = new ArrayList<>();
        List<Book> actual = bookService.findBooksByAuthors(ID);

        assertEquals(expected, actual);

        then(bookDao).should(only()).findBooksByAuthors(ID);
        then(readerDao).shouldHaveNoInteractions();
        then(userDao).shouldHaveNoInteractions();
    }

    @Test
    void shouldGetBooking() {
        User user = new User(1L, "mary", "mary", "reader");
        Reader reader = new Reader(1L, "Зайцева Мария Викторовна", "123456", "ул. Кирова 122а", new Date());

        given(userDao.findByUsername(USERNAME)).willReturn(user);
        given(readerDao.findReaderByUserId(user.getId())).willReturn(reader);
        given(bookDao.getBooking(reader.getId())).willReturn(LIST);

        List<Book> expected = new ArrayList<>();
        List<Book> actual = bookService.getBooking(USERNAME);

        assertEquals(expected, actual);

        then(bookDao).should(only()).getBooking(reader.getId());
        then(readerDao).should(only()).findReaderByUserId(user.getId());
        then(userDao).should(only()).findByUsername(USERNAME);
    }
}
