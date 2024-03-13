package com.app.service;

import com.app.dto.CustomerDto;
import com.app.pojos.Customer;

public interface CustomerService {

	CustomerDto getCustById(int id);
	
	CustomerDto customerLogin(String email, String password);

	CustomerDto registerCustomer(CustomerDto customer);

	CustomerDto updateCustomer(Integer id, CustomerDto customer);

	boolean authenticateUser(String email, String password);

	Customer getUserByEmail(String email);
	

}
