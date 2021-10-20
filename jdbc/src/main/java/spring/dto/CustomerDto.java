package spring.dto;

public class CustomerDto {
	
	private Customer customer;
	private float sum;
	private long idOrder;
	
	public CustomerDto() {
		this.customer = new Customer();
		this.sum = -1;
		this.idOrder = -1;
	}
	
	public CustomerDto(Customer customer, float sum, long idOrder) {
		this.customer = customer;
		this.sum = sum;
		this.idOrder = idOrder;
	}
	
	public Customer getCustomer() {
		return customer;
	}
	
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
	public float getSum() {
		return sum;
	}
	
	public void setSum(float sum) {
		this.sum = sum;
	}

	public long getIdOrder() {
		return idOrder;
	}

	public void setIdOrder(long idOrder) {
		this.idOrder = idOrder;
	}
}
