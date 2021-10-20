package spring.service;

import java.util.List;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import spring.daoi.ProductDaoI;
import spring.models.Product;

@Service
@Transactional
public class ProductService {
	
    private ProductDaoI productDao;

	public ProductService(ProductDaoI productDao){
		this.productDao = productDao;
	}

	@PreAuthorize("hasAnyAuthority('CUSTOMER', 'ADMIN')")
    public Product findProductById(long id) {
        return productDao.findProductById(id);
    }

	@PreAuthorize("hasAnyAuthority('CUSTOMER', 'ADMIN')")
    public List<Product> findAllProducts() {
        return productDao.findAll();
    }
}
