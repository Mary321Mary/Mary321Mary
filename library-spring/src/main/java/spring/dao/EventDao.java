package spring.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import spring.models.Event;

import java.util.Date;
import java.util.List;

public interface EventDao extends JpaRepository<Event, Long> {

    List<Event> findAllByDateAfter(Date date);

    List<Event> findEventsByNameContaining(String name);

    List<Event> findByEmployeeId(long id);

}
