package spring.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import spring.models.Issued;

import java.util.List;

public interface IssuedDao extends JpaRepository<Issued, Long> {

    List<Issued> findByDateReturnIsNull();
    List<Issued> findByBookId(long id);
    List<Issued> findByReaderId(long id);
    List<Issued> findByEmployeeId(long id);

}
