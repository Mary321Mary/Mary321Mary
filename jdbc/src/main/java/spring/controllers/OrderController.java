package spring.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import spring.dto.CustomerDto;
import spring.dto.NotValidError;
import spring.dto.OrderAndSum;
import spring.dto.OrderDto;
import spring.models.Order;
import spring.service.OrderService;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping("/order")
public class OrderController {

	private OrderService orderService;
	
	public  OrderController(OrderService orderService) {
		this.orderService = orderService;
	}

    @PostMapping("")
	public OrderAndSum getBasket(@RequestBody Integer[] idsOfProducts) {
    	if(idsOfProducts.length == 0) {
    		return new OrderAndSum();
    	} else {
    		return this.orderService.getBasket(idsOfProducts);
    	}
	}
    
    @PostMapping("/makeOrder")
	public CustomerDto makeOrder(@Valid @RequestBody OrderDto orderDto) {
    	return this.orderService.makeOrder(orderDto);
	}

    @GetMapping("/getOrders")
	public List<Order> getProduct() {
		return this.orderService.findAllOrders();
	}
    
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public List<NotValidError> handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
    	List<NotValidError> notValidErrors = new ArrayList<>();
		for(FieldError fieldError: e.getFieldErrors()) {
			notValidErrors.add(new NotValidError(fieldError.getField(), fieldError.getDefaultMessage()));
		}
    	return notValidErrors;
    }
}
