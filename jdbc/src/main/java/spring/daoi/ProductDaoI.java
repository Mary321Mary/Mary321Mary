package spring.daoi;

import java.util.List;

import spring.models.Product;

public interface ProductDaoI {

	public Product findProductById(long id);

	public List<Product> findAll();
}
