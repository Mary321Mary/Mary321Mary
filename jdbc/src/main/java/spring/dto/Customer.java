package spring.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class Customer {

	private String name;
	
	@NotNull
	@Pattern(regexp = "^\\+375\\s\\(\\d{2}\\)\\s\\d{3}-\\d{2}-\\d{2}$",
			message = " Phone number is not valid (+375 (11) 222-33-44)")
	private String phone;

	@NotNull
	@Pattern(regexp = "^[a-z0-9_.-]+@[a-z_.-]+\\.[a-z]{2,}$",
			message = " Email is not valid (a@a.aa)")
	private String email;

	@NotNull
	@Pattern(regexp = "^\\d{10}$",
			message = " Card number is not valid (10 digits)")
	private String cardNumber;
	private String address;
	private String comment;
	
	public Customer() {
		this.name = "";
		this.phone = "";
		this.email = "";
		this.cardNumber = "";
		this.address = "";
		this.comment = "";
	}
	
	public Customer(String name, String phone, String email, String cardNumber, String address, String comment) {
		this.name = name;
		this.phone = phone;
		this.email = email;
		this.cardNumber = cardNumber;
		this.address = address;
		this.comment = comment;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getPhone() {
		return phone;
	}
	
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
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
	
	@Override
	public String toString() {
		return "Customer name " + name + ", phone " + phone + ", email " + email + ", cardNumber " + cardNumber
				+ ", address " + address + ", comment " + comment;
	}
}
