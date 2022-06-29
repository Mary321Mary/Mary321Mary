package spring.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import spring.models.Employee;

public interface EmployeeDao extends JpaRepository<Employee, Long> {

    Employee findByFio(String fio);

}
