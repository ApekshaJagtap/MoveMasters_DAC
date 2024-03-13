package com.app.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.app.pojos.Order;

public interface OrderDao extends JpaRepository<Order, Integer> {
//	@Query("select e.customer from Order e where e.customer=:id")
//	List<Order> findAllOrders(Integer id);

	 @Query(value  ="select * from orders where customer_id=?1",nativeQuery = true)
	 Order[] findAllByCustomer_Id(int customerId);	 
	 
	    Order[] findByCustomerId(Integer customerId);

	 

	 

}
