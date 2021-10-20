package spring.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import spring.daoi.OrderDaoI;
import spring.models.Order;

public class OrderDao implements OrderDaoI {
	
    private JdbcTemplate jdbcTemplate;

	public OrderDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
	}

	public Long save(Order order) {
		jdbcTemplate.update("INSERT INTO Orders(IdUser, Phone, CardNumber, Address, Comment) VALUES (?, ?, ?, ?, ?)",
				order.getId(), order.getPhone(), order.getCardNumber(), order.getAddress(), order.getComment());
		return jdbcTemplate.queryForObject("SELECT Id FROM Orders ORDER BY Id DESC LIMIT 1", Long.class);
	}

	public List<Order> findAll() {
		return new ArrayList<>();
	}

}
