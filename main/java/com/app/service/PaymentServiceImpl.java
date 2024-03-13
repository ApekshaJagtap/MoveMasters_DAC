package com.app.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.OrderDao;
import com.app.dao.PaymentDao;
import com.app.dto.PaymentWithOrderId;
import com.app.pojos.Order;
import com.app.pojos.Payment;


@Service
@Transactional
public class PaymentServiceImpl implements PaymentService {
	
	@Autowired
	private PaymentDao paymentDao;
	
	@Autowired
	private OrderDao orderDao;

	
	

	@Override
	public Payment addPaymentDetails(Payment newPayment) {
		// TODO Auto-generated method stub
		return paymentDao.save(newPayment);
	}

	@Override
	public String deletePaymentDetails(Integer PaymentId) {
		if(paymentDao.existsById(PaymentId)) {
			paymentDao.deleteById(PaymentId);
			return "Deleted payment details....";
		}
		return "Invalid payment id !!!!!!";
	}

	@Override
	public Payment updatePaymentDetails(Payment newPayment) {
		Payment oldPayment=paymentDao.findById(newPayment.getId()).orElse(null);
		
		oldPayment.setTransactionId(newPayment.getTransactionId());
		oldPayment.setAmount(newPayment.getAmount());
		oldPayment.setPaymentType(newPayment.getPaymentType());
		
		return paymentDao.save(oldPayment);
	}

//	@Override
//	public Object[] getAllPayments(Integer id) {
//	    Order[] orders = orderDao.findAllByCustomer_Id(id);
//	    Object[] payments = new Object[orders.length];
//	    
//	    // Iterate through orders and retrieve payment for each order
//	    for (int i = 0; i < orders.length; i++) {
//	        Order order = orders[i];
//	        Payment payment = order.getPayment(); // Access the associated payment
//	        payments[i] = payment; // Add payment to the array
//	    }
//	    
//	    return payments;
//	}

	
	@Override
	public Object[] getAllPayments(Integer customerId) {
	    List<Object> paymentsList = new ArrayList<>();
	    
	    Order[] orders = orderDao.findByCustomerId(customerId);
	    
	    for (Order order : orders) {
	        Payment payment = order.getPayment();
	        if (payment != null) {
	            // Include order ID along with payment
	            PaymentWithOrderId paymentWithOrderId = new PaymentWithOrderId(order.getId(), payment);
	            paymentsList.add(paymentWithOrderId);
	        }
	    }
	    return paymentsList.toArray();
	}



}
