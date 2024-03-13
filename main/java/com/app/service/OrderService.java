package com.app.service;

import com.app.dto.OrderDto;
import com.app.dto.OrderRequest;

public interface OrderService {

	OrderDto getOrder(int id);

	OrderDto updateStatus(int id, String status);

	Object[] getAllOrders(int id);

	OrderRequest addOrder(OrderRequest request,Integer id);

	Object[] getOrdersByCustomerId(Integer customerId);

}
