package com.app.controller;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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

import com.app.dto.AddressDto;
import com.app.dto.ApiResponseDto;
import com.app.dto.CustomerDto;
import com.app.dto.OrderRequest;
import com.app.pojos.Customer;
import com.app.service.CustomerService;



@RestController
@RequestMapping("/customer")
@CrossOrigin(origins = "http://localhost:3000/")
public class CustomerController 
{
	@Autowired
	private CustomerService custService;
	@Autowired
	private ModelMapper mapper;
	
	public CustomerController() {
		System.out.println("In customer controller");
	}
	
	@GetMapping("/{id}")
	public CustomerDto getCustomerByID(@PathVariable int id)
	{
		return custService.getCustById(id);
	}
	
	@PostMapping("/login/{email}/{password}")
	public CustomerDto getCustomerLogin(@PathVariable String email,@PathVariable String password)
	{
		return custService.customerLogin(email, password);
	}
	
	@PostMapping("/register")
	public CustomerDto registerNewCustomer(@RequestBody CustomerDto customer)
	{
		return custService.registerCustomer(customer);
	}
	
	@PutMapping("/{id}")
	public CustomerDto updateExistingCustomer(@PathVariable Integer id,@RequestBody CustomerDto customer)
	{
		return custService.updateCustomer(id,customer);
	}
	
	
	  
	  @PostMapping("/api/login") 
	  public ResponseEntity<?> login(HttpServletRequest request,@RequestBody LoginRequest loginRequest)
	  {
		  System.out.println("Test One");
		  if(custService.authenticateUser(loginRequest.getEmail(), loginRequest.getPassword()))
		  { 
			  Customer user=custService.getUserByEmail(loginRequest.getEmail()); 
			  HttpSession session= request.getSession(); session.setAttribute("user",user);
			  return ResponseEntity.ok(mapper.map(user, CustomerDto.class)); }
		  else 
		  { 
			  return ResponseEntity.status(400).body(new ApiResponseDto("failed")); 
		  } 
	}
	  
	  @GetMapping("/api/logout") 
	  public void logOut(HttpSession session) 
	  {
		  session.invalidate(); 
	  }
	  
	 
	  
	 
	  
}

class LoginRequest{
	private String email;
	private String password;
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}