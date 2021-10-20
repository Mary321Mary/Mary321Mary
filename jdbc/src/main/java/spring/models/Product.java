package spring.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@JsonIgnoreProperties("orders")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long   id;
	private String name;
	private int quantity;
	private double price;
	
	@ManyToMany(mappedBy = "products")
    private List<Order> orders;

	public Product() {
		this.name = "";
		this.quantity = 0;
		this.price = 0;
		this.orders = new ArrayList<>();
	}
	
	public Product(Long id, String name, int capacity, double price) {
		this.id = id;
		this.name = name;
		this.quantity = capacity;
		this.price = price;
		this.orders = new ArrayList<>();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public int getQuantity() {
		return quantity;
	}
	
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	public double getPrice() {
		return price;
	}
	
	public void setPrice(double price) {
		this.price = price;
	}

	public List<Order> getOrders() {
		return orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}
	
	@Override
	public String toString() {
		return "Product id " + id + ", name " + name + ", quantity " + quantity + ", price " + price;
	}
}
