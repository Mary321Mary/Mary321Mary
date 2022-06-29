package spring.service;

import java.util.List;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import spring.dao.*;
import spring.dto.BookDto;
import spring.models.Book;
import spring.models.Reader;
import spring.models.User;

@Service
@Transactional
public class BookService {
	
	private BookDao bookDao;
	private PublishingDao publishingDao;
	private GenreDao genreDao;
	private ReaderDao readerDao;
	private UserDao userDao;

	public BookService(BookDao bookDao,
					   PublishingDao publishingDao,
					   GenreDao genreDao,
					   ReaderDao readerDao,
					   UserDao userDao) {
		this.bookDao = bookDao;
		this.publishingDao = publishingDao;
		this.genreDao = genreDao;
		this.readerDao = readerDao;
		this.userDao = userDao;
	}

	public List<Book> findAllBooks() {
		return this.bookDao.findAll();
	}

	public List<Book> findBooksByGenreId(long id) {
		return this.bookDao.findBooksByGenreId(id);
	}

	public List<Book> findBooksByPublishingId(long id) {
		return this.bookDao.findBooksByPublishingId(id);
	}

	public List<Book> findBooksByNameContaining(String name) {
		return this.bookDao.findBooksByNameContaining(name);
	}

	public List<Book> findBooksByAuthors(long id) {
		return this.bookDao.findBooksByAuthors(id);
	}

	public BookDto findBookById(long id) {
		if(id != -1){
			return BookDto.builder()
					.book(this.bookDao.findById(id).get())
					.publishing(this.publishingDao.findAll())
					.genres(this.genreDao.findAll()).build();
		} else {
			return BookDto.builder()
					.book(new Book())
					.publishing(this.publishingDao.findAll())
					.genres(this.genreDao.findAll()).build();
		}
	}

	@PreAuthorize("hasAnyAuthority('employee')")
	public Book saveBook(Book book) {
		return this.bookDao.save(book);
    }

	@PreAuthorize("hasAnyAuthority('employee')")
	public void deleteBookById(long id) {
        this.bookDao.deleteById(id);
    }

	@PreAuthorize("hasAnyAuthority('reader')")
	public void addBooking(String username, long bookId) {
		User byUsername = this.userDao.findByUsername(username);
		Reader reader = this.readerDao.findReaderByUserId(byUsername.getId());
		this.bookDao.addBooking(reader.getId(), bookId);
	}

	@PreAuthorize("hasAnyAuthority('reader')")
	public void deleteBooking(String username, long bookId) {
		User byUsername = this.userDao.findByUsername(username);
		Reader reader = this.readerDao.findReaderByUserId(byUsername.getId());
		this.bookDao.deleteBooking(reader.getId(), bookId);
	}

	@PreAuthorize("hasAnyAuthority('reader')")
	public List<Book> getBooking(String username) {
		User byUsername = this.userDao.findByUsername(username);
		Reader reader = this.readerDao.findReaderByUserId(byUsername.getId());
		return this.bookDao.getBooking(reader.getId());
	}

}
