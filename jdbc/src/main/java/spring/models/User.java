package spring.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class User {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long   id;
	private String name;
	private String email;

	@OneToMany(mappedBy = "user")
    private List<Order> orders;
	
	public User() {
		this.id = (long) -1;
		this.name = "";
		this.email = "";
		this.orders = new ArrayList<>();
	}
	
	public User(Long id, String name, String email) {
		this.id = id;
		this.name = name;
		this.email = email;
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
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	@Override
	public String toString() {
		return "User [name=" + name + ", email=" + email + "]";
	}
}
