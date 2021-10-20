package spring.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import spring.models.Product;
import spring.service.ProductService;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping("/products")
public class ProductController {

	private ProductService productService;
	
	public ProductController(ProductService productService) {
		this.productService = productService;
	}

    @GetMapping("")
	public List<Product> getProducts() {
		return this.productService.findAllProducts();
	}

    @GetMapping("/{id}")
	public Product getProduct(@PathVariable long id) {
		return this.productService.findProductById(id);
	}
}
