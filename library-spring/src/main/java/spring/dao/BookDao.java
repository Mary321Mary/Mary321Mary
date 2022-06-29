package spring.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import spring.models.Author;
import spring.models.Book;

import java.util.List;

public interface BookDao extends JpaRepository<Book, Long> {

    List<Book> findBooksByGenreId(long id);
    List<Book> findBooksByPublishingId(long id);
    List<Book> findBooksByNameContaining(String name);

    @Query(nativeQuery = true,
            value = "SELECT * FROM book WHERE id IN (SELECT book_id FROM authorbook WHERE author_id = :authorId)")
    List<Book> findBooksByAuthors(@Param("authorId") long authorId);

    @Transactional
    @Modifying
    @Query(nativeQuery = true,
            value = "INSERT INTO public.booking(reader_id, book_id) " +
                    "SELECT * FROM (SELECT :readerId, :bookId) tmp WHERE NOT EXISTS (" +
                    "SELECT * FROM booking WHERE reader_id = :readerId AND book_id = :bookId);")
    void addBooking(@Param("readerId") long readerId, @Param("bookId") long bookId);

    @Transactional
    @Modifying
    @Query(nativeQuery = true,
            value = "DELETE FROM booking WHERE reader_id = :readerId AND book_id = :bookId")
    void deleteBooking(@Param("readerId") long readerId, @Param("bookId") long bookId);

    @Query(nativeQuery = true,
            value = "SELECT b.id, b.name, b.publ_id, b.genre_id, b.year, b.pages, b.count, b.description, b.image " +
                    "FROM booking bo, book b WHERE bo.reader_id = :readerId AND bo.book_id = b.id")
    List<Book> getBooking(@Param("readerId") long readerId);
	
}
