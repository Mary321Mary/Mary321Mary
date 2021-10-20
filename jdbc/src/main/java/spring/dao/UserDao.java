package spring.dao;

import org.springframework.jdbc.core.JdbcTemplate;

import spring.daoi.UserDaoI;
import spring.models.User;

public class UserDao implements UserDaoI {
	
    private JdbcTemplate jdbcTemplate;

	public UserDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
	}

	public User findByEmail(String email) {
		return jdbcTemplate.queryForObject("SELECT * FROM User WHERE Email = ?", User.class, email);
	}
}
