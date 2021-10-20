package spring.dto;

import javax.validation.Valid;

public class OrderDto {

	private Integer[] idsOfProducts;
	
	@Valid
	private Customer customer;
	
	public OrderDto() {
		this.idsOfProducts = new Integer[] {};
		this.customer = new Customer();
	}
	
	public OrderDto(Integer[] idsOfProducts, Customer customer) {
		this.idsOfProducts = idsOfProducts;
		this.customer = customer;
	}
	
	public Integer[] getIdsOfProducts() {
		return idsOfProducts;
	}
	
	public void setIdsOfProducts(Integer[] idsOfProducts) {
		this.idsOfProducts = idsOfProducts;
	}
	
	public Customer getCustomer() {
		return customer;
	}
	
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
}
