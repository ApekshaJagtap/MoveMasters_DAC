package com.app.service;

import java.util.List;

import com.app.pojos.Payment;

public interface PaymentService {
	Object[] getAllPayments(Integer id);

	Payment addPaymentDetails(Payment newPayment);

	String deletePaymentDetails(Integer PaymentId);

	Payment updatePaymentDetails(Payment newPayment);
}
