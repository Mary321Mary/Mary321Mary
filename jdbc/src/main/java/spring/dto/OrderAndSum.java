package spring.dto;

import java.util.ArrayList;
import java.util.List;

import spring.models.Product;

public class OrderAndSum {

	private List<Product> productList;
	private float sum;
	
	public OrderAndSum() {
		this.productList = new ArrayList<>();
		this.sum = 0;
	}
	
	public OrderAndSum(List<Product> productList, float sum) {
		this.productList = productList;
		this.sum = sum;
	}

	public List<Product> getProductList() {
		return productList;
	}

	public void setProductList(List<Product> productList) {
		this.productList = productList;
	}

	public float getSum() {
		return sum;
	}

	public void setSum(float sum) {
		this.sum = sum;
	}
	
	@Override
	public String toString() {
		return "Order productList " + productList + ", sum " + sum;
	}
}
