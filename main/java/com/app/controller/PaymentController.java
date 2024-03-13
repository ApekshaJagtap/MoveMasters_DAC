package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.pojos.Payment;
import com.app.service.OrderService;
import com.app.service.PaymentService;

@RestController
@RequestMapping("/payments")
@CrossOrigin(origins = "http://localhost:3000")
public class PaymentController {
	@Autowired
	private PaymentService paymentService;
	@Autowired
	private OrderService orderService;
	
	@PostMapping("/add")
	public Payment addpaymentDetails(@RequestBody Payment newPayment)
	{
		System.out.println("in add payment details " + newPayment);
		return paymentService.addPaymentDetails(newPayment);

	}
//	@GetMapping("/{id}")
//	public Object[] listAllPaymentsByCustomerId(@PathVariable Integer id)
//	{
//		Object[] payments= paymentService.getAllPayments(id);
//		return payments;
//	}

	
	@GetMapping("/getAllPayments/{customerId}")
	public ResponseEntity<Object[]> getAllPaymentsForCustomer(@PathVariable Integer customerId) {
	    Object[] payments = paymentService.getAllPayments(customerId);
	    if (payments != null && payments.length > 0) {
	        return ResponseEntity.ok(payments);
	    } else {
	        return ResponseEntity.notFound().build();
	    }
	}



	
	@PutMapping("/update")
	public Payment updatepaymentDetails(@RequestBody Payment payment)
	{
		System.out.println("in update payment details");
		return paymentService.updatePaymentDetails(payment);
	}
		
	@DeleteMapping("/delete/{paymentId}")
	public String deletepaymentDetails(@PathVariable Integer paymentId) {
		System.out.println("in del payment dtls " + paymentId);
		return paymentService.deletePaymentDetails(paymentId);
	}
}
