package spring.daoi;

import java.util.List;

import spring.models.Order;

public interface OrderDaoI {

	public Long save(Order order);

	public List<Order> findAll();
}
