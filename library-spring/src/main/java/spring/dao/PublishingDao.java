package spring.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import spring.models.Publishing;

public interface PublishingDao extends JpaRepository<Publishing, Long> {

    Publishing findByName(String name);

}
