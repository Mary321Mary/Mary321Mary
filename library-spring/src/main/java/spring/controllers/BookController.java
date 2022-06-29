package spring.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import spring.dto.BookDto;
import spring.dto.BookingDto;
import spring.models.Book;
import spring.service.BookService;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping("/books")
public class BookController {

	private BookService bookService;
	
	public BookController(BookService bookService) {
		this.bookService = bookService;
	}

    @GetMapping
	public List<Book> findAllBooks() {
		return this.bookService.findAllBooks();
	}

    @GetMapping("/genre/{id}")
    public List<Book> findBooksByGenreId(@PathVariable long id) {
        return this.bookService.findBooksByGenreId(id);
    }

    @GetMapping("/publishing/{id}")
    public List<Book> findBooksByPublishingName(@PathVariable long id) {
        return this.bookService.findBooksByPublishingId(id);
    }

    @GetMapping("/name/{name}")
    public List<Book> findBooksByNameContaining(@PathVariable String name) {
        return this.bookService.findBooksByNameContaining(name);
    }

    @GetMapping("/author/{id}")
    public List<Book> findBooksByAuthors(@PathVariable long id) {
        return this.bookService.findBooksByAuthors(id);
    }

    @GetMapping("/{id}")
	public BookDto findBookById(@PathVariable long id) {
		return this.bookService.findBookById(id);
	}

    @PostMapping
    public Book createBook(@RequestBody Book book) {
        return this.bookService.saveBook(book);
    }

    @PutMapping
    public Book updateBook(@RequestBody Book book) {
        return this.bookService.saveBook(book);
    }

    @DeleteMapping("/{id}")
    public void deleteBookById(@PathVariable long id) {
    	this.bookService.deleteBookById(id);
    }

    @PostMapping("/booking")
    public void addBooking(@RequestBody BookingDto bookingDto) {
        this.bookService.addBooking(bookingDto.getUsername(), bookingDto.getBookId());
    }

    @DeleteMapping("/{username}/{bookId}")
    public void deleteBooking(@PathVariable String username, @PathVariable long bookId) {
        this.bookService.deleteBooking(username, bookId);
    }

    @GetMapping("/booking/{username}")
    public List<Book> getBooking(@PathVariable String username) {
        return this.bookService.getBooking(username);
    }

}
