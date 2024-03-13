package com.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.app.pojos.Payment;

public interface PaymentDao extends JpaRepository<Payment, Integer> {
	@Query("SELECT p FROM Payment p JOIN p.order o WHERE o.customer.id = :customerId")
    Payment[] findByCustomerId(Integer customerId);

}
