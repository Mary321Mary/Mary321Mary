package spring.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import spring.models.Reader;

public interface ReaderDao extends JpaRepository<Reader, Long> {

    @Query(nativeQuery = true,
            value = "SELECT id, fio, phone, address, passport, birthday " +
                    "FROM reader where user_id = :userId")
    Reader findReaderByUserId(@Param("userId") long userId);

}
