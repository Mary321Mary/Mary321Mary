package spring.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import spring.daoi.UserDaoI;
import spring.models.User;

@Repository
public class UserHibernateDao implements UserDaoI {
	
    private SessionFactory sessionFactory;
    private List<User> list;
    
    public UserHibernateDao(SessionFactory sessionFactory) {
    	this.sessionFactory = sessionFactory;
    	this.list = new ArrayList<>();
    }

	public User findByEmail(String email) {
        Session session = this.sessionFactory.getCurrentSession();
        if(this.list.isEmpty()) {
        	this.list = session.createQuery("FROM User", User.class).list();
        }
        for(User item: list) {
        	if(item.getEmail().equals(email)) {
        		return item;
        	}
        }
		return new User();
	}
}
