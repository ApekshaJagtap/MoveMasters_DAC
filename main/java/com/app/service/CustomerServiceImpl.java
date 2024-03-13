package com.app.service;


import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.CustomerDao;
import com.app.dto.CustomerDto;
import com.app.pojos.Customer;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerDao custDao;
	@Autowired
	private ModelMapper mapper;
	
	@Override
	public CustomerDto getCustById(int id) {	
		Customer cust=custDao.findById(id).orElseThrow();
		return mapper.map(cust, CustomerDto.class);
	}

	@Override
	public CustomerDto customerLogin(String email, String password) {
		Customer cust=custDao.findByEmail(email);
		if(cust!=null && cust.getPassword().equals(password))
		{
			return getCustById(cust.getId());
		}
		return null;
	}

	@Override
	public CustomerDto registerCustomer(CustomerDto customer) {
		Customer cust=mapper.map(customer, Customer.class);
		Customer persistantCust=custDao.save(cust);
		return mapper.map(persistantCust, CustomerDto.class);
	}

	@Override
	public CustomerDto updateCustomer(Integer id, CustomerDto customer) {
		Customer cust=custDao.findById(id).orElseThrow();
		if(cust!=null)
		{
			cust.setFirstName(customer.getFirstName());
			cust.setLastName(customer.getLastName());
			cust.setEmail(customer.getEmail());
			cust.setPassword(customer.getPassword());
			cust.setPhoneNumber(customer.getPhoneNumber());
		}
		return mapper.map(cust, CustomerDto.class);
	}
	
	public boolean authenticateUser(String email,String password) {
	Customer user=custDao.findByEmail(email);
	return user!=null && user.getPassword().equals(password);
}
	@Override
	public Customer getUserByEmail(String email) {
		Customer cust=custDao.findByEmail(email);
		return cust ;
	}

}
