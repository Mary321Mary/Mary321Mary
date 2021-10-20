package spring.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import spring.daoi.OrderDaoI;
import spring.models.Order;

@Repository
public class OrderHibernateDao implements OrderDaoI {
	
    private SessionFactory sessionFactory;
    
    public OrderHibernateDao(SessionFactory sessionFactory) {
    	this.sessionFactory = sessionFactory;
    }

    public List<Order> findAll() {
        Session session = this.sessionFactory.getCurrentSession();
		return session.createQuery("FROM Order", Order.class).list();
    }

	public Long save(Order order) {
        Session session = this.sessionFactory.getCurrentSession();
		return (Long) session.save(order);
	}
}
