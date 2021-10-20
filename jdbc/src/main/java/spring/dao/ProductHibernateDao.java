package spring.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import spring.daoi.ProductDaoI;
import spring.models.Product;

@Repository
public class ProductHibernateDao implements ProductDaoI {
	
    private SessionFactory sessionFactory;
    
    public ProductHibernateDao(SessionFactory sessionFactory) {
    	this.sessionFactory = sessionFactory;
    }

    public Product findProductById(long id) {
        Session session = this.sessionFactory.getCurrentSession();
		return session.load(Product.class, id);
    }

    public List<Product> findAll() {
        Session session = this.sessionFactory.getCurrentSession();
		return session.createQuery("FROM Product", Product.class).list();
    }
}
