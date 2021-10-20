package spring.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import spring.daoi.OrderDaoI;
import spring.daoi.ProductDaoI;
import spring.daoi.UserDaoI;
import spring.dto.CustomerDto;
import spring.dto.OrderAndSum;
import spring.dto.OrderDto;
import spring.models.Order;
import spring.models.Product;
import spring.models.User;

@Service
@Transactional
public class OrderService {

    private ProductDaoI productDao;
    private UserDaoI userDao;
    private OrderDaoI orderDao;

	public OrderService(ProductDaoI productDao, OrderDaoI orderDao, UserDaoI userDao){
		this.productDao = productDao;
		this.orderDao = orderDao;
		this.userDao = userDao;
	}

	@PreAuthorize("hasAnyAuthority('CUSTOMER', 'ADMIN')")
    public OrderAndSum getBasket(Integer[] idsOfProducts) {
	    List<Product> products = new ArrayList<>();
	    float sum = 0;
	    for(int i = 0; i < idsOfProducts.length; i++) {
	    	Product tempP = this.productDao.findProductById(idsOfProducts[i]);
	    	sum += tempP.getPrice();
	    	products.add(tempP);
	    }
		return new OrderAndSum(products, sum);
    }

	@PreAuthorize("hasAnyAuthority('CUSTOMER', 'ADMIN')")
    public CustomerDto makeOrder(OrderDto orderDto) {
    	List<Product> products = new ArrayList<>();
	    float sum = 0;
	    for(int i = 0; i < orderDto.getIdsOfProducts().length; i++) {
	    	Product tempP = this.productDao.findProductById(orderDto.getIdsOfProducts()[i]);
	    	sum += tempP.getPrice();
	    	products.add(tempP);
	    }
    	User user = userDao.findByEmail(orderDto.getCustomer().getEmail());
	    Order order = new Order(orderDto.getCustomer().getPhone(), orderDto.getCustomer().getCardNumber(),
				orderDto.getCustomer().getAddress(), orderDto.getCustomer().getComment(), user, products);
    	long idOrder = orderDao.save(order);
		return new CustomerDto(orderDto.getCustomer(), sum, idOrder);
    }

	@PreAuthorize("hasAuthority('ADMIN')")
    public List<Order> findAllOrders() {
        return orderDao.findAll();
    }
}
