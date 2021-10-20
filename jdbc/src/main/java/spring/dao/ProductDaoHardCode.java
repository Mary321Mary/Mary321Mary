package spring.dao;

import java.util.ArrayList;
import java.util.List;

import spring.daoi.ProductDaoI;
import spring.models.Product;

public class ProductDaoHardCode implements ProductDaoI {
	
	private List<Product> productList = new ArrayList<>();
	
	public ProductDaoHardCode(){
    	this.productList.add(new Product((long) 0, "Milk", 12, 1.5));
    	this.productList.add(new Product((long) 1, "Kefir", 1, 1.3));
    	this.productList.add(new Product((long) 2, "Sour cream", 5, 3.15));
    	this.productList.add(new Product((long) 3, "Cheese", 2, 2.25));
	}

	public Product findProductById(long id) {
		for(Product p: productList) {
			if(p.getId() == id) {
				return p;
			}
		}
		return null;
	}

	public List<Product> findAll() {
		return productList;
	}

	public void setProductList(List<Product> productList) {
		this.productList = productList;
	}
}
