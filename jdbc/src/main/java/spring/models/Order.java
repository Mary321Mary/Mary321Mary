package spring.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "Orders")
@JsonIgnoreProperties("products")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long   id;
	private String phone;
	
	@Column(name = "card_number")
	private String cardNumber;
	private String address;
	private String comment;

    @ManyToOne
    private User user;

    @ManyToMany
    @JoinTable(name = "Ordered_products",
            joinColumns = @JoinColumn(name = "Order_id"),
            inverseJoinColumns = @JoinColumn(name = "Product_id")
    )
    private List<Product> products;

	public Order() {
		this.phone = "";
		this.cardNumber = "";
		this.address = "";
		this.comment = "";
		this.products = new ArrayList<>();
	}

	public Order(String phone, String cardNumber, String address, String comment, User user, List<Product> products) {
		this.phone = phone;
		this.cardNumber = cardNumber;
		this.address = address;
		this.comment = comment;
		this.user = user;
		this.products = products;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	@Override
	public String toString() {
		return "Order [id=" + id + ", phone=" + phone + ", cardNumber=" + cardNumber + ", address=" + address
				+ ", comment=" + comment + ", user=" + user + ", products=" + products + "]";
	}
}
