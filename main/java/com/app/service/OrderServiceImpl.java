package com.app.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.AddressDao;
import com.app.dao.CustomerDao;
import com.app.dao.OrderDao;
import com.app.dto.OrderDto;
import com.app.dto.OrderRequest;
import com.app.enums.OrderStatus;
import com.app.pojos.Address;
import com.app.pojos.Customer;
import com.app.pojos.Order;

@Service
@Transactional
public class OrderServiceImpl implements OrderService {
	
	@Autowired
	private OrderDao orderDao;
	
	@Autowired
	private CustomerDao custDao;
	
	@Autowired
	private AddressDao addrDao;
	
	@Autowired
	private ModelMapper mapper;

//	@Override
//	public OrderDto getOrder(int id) {
//		Order order=orderDao.findById(id).orElseThrow();
//		return mapper.map(order,OrderDto.class);
//	}
//
//	@Override
//	public OrderDto updateStatus(int id, String status) {
//		Order o=orderDao.findById(id).orElseThrow();
//		o.setOrderStatus(OrderStatus.valueOf(status.toUpperCase()));
//		if(status.toUpperCase().equals("SHIPPED"))
//		{
//			o.setShippingDateTime(LocalDateTime.now());
//		}
//		else if(status.toUpperCase().equals("DELIVERED"))
//		{
//			o.setDeliveryDateTime(LocalDateTime.now());
//		}
//		return mapper.map(o, OrderDto.class);
//	}
//
//	@Override
//	public Object[] getAllOrders(int id) {
//		Object[] cust=orderDao.findAllByCustomer_Id(id);
//		return cust;
//	}

	@Override
	public OrderDto getOrder(int id) {
		Order order=orderDao.findById(id).orElseThrow();
		return mapper.map(order,OrderDto.class);
	}

	@Override
	public OrderDto updateStatus(int id, String status) {
		Order o=orderDao.findById(id).orElseThrow();
		o.setOrderStatus(OrderStatus.valueOf(status.toUpperCase()));
		if(status.toUpperCase().equals("SHIPPED"))
		{
			o.setShippingDateTime(LocalDateTime.now());
		}
		else if(status.toUpperCase().equals("DELIVERED"))
		{
			o.setDeliveryDateTime(LocalDateTime.now());
		}
		return mapper.map(o, OrderDto.class);
	}

	@Override
	public Object[] getAllOrders(int id) {
		Object[] cust=orderDao.findAllByCustomer_Id(id);
		return cust;
	}
	
	
	@Override
	public OrderRequest addOrder(OrderRequest request, Integer id) {
        Order order = new Order();
        order.setWeight(request.getWeight());
        order.setCost(request.getCost());
        order.setOrderStatus(OrderStatus.PENDING); // Set initial order status
        
        Address pickupAddress = new Address();
        pickupAddress.setCity(request.getPickupAddress().getCity());
        pickupAddress.setPinCode(request.getPickupAddress().getPinCode());
        pickupAddress.setState(request.getPickupAddress().getState());
        pickupAddress.setFlatNo(request.getPickupAddress().getFlatNo());
        pickupAddress.setBuildingName(request.getPickupAddress().getBuildingName());
        pickupAddress.setStreetName(request.getPickupAddress().getStreetName());
        
        pickupAddress = addrDao.save(pickupAddress);
        
        Address deliveryAddress = new Address();
        deliveryAddress.setCity(request.getDeliveryAddress().getCity());
        deliveryAddress.setPinCode(request.getDeliveryAddress().getPinCode());
        deliveryAddress.setState(request.getDeliveryAddress().getState());
        deliveryAddress.setFlatNo(request.getDeliveryAddress().getFlatNo());
        deliveryAddress.setBuildingName(request.getDeliveryAddress().getBuildingName());
        deliveryAddress.setStreetName(request.getDeliveryAddress().getStreetName());
        
        deliveryAddress = addrDao.save(deliveryAddress);
        
        order.setPickup_address(pickupAddress);
        order.setDrop_address(deliveryAddress);
        
        Customer cust=custDao.findById(id).orElseThrow();
        order.setCustomer(cust);
        
        Order o= orderDao.save(order);
        return mapper.map(o, OrderRequest.class);
    }
	
	public Object[] getOrdersByCustomerId(Integer customerId) {
        Object[] orders = orderDao.findAllByCustomer_Id(customerId);
        return orders;
    }


}
