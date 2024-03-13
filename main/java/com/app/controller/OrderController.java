package com.app.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.CustomerDto;
import com.app.dto.OrderDto;
import com.app.dto.OrderRequest;
import com.app.pojos.Customer;
import com.app.service.CustomerService;
import com.app.service.OrderService;

@RestController
@RequestMapping("/order")
@CrossOrigin(origins = "http://localhost:3000")
public class OrderController {
	@Autowired
	private OrderService orderService;
	@Autowired
	private CustomerService customerService;
	@Autowired
	private ModelMapper mapper;
	

	
	@GetMapping("/{id}")
	public ResponseEntity<?> getAllOrdersOfCustomer(@PathVariable int id) {
	    CustomerDto cust = customerService.getCustById(id);
	    Customer customer=mapper.map(cust, Customer.class);
	    if (customer != null) {
	        customer.getAddress().size();
	        return ResponseEntity.ok(orderService.getAllOrders(id));
	    } else {
	        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No customer found with id: " + id);
	    }
	}


	@PutMapping("/{id}")
	public OrderDto updateOrderStatus(@PathVariable Integer id,@RequestBody String status)
	{
		System.out.println(id+"    "+status);
		return orderService.updateStatus(id,status.replace("\"", ""));
	}

	
	@PostMapping("/addOrder/{id}")
    public OrderRequest addOrder(@RequestBody OrderRequest request,@PathVariable Integer id) {
        return orderService.addOrder(request,id);
    }
	

}
