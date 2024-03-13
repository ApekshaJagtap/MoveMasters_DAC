	package com.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.app.pojos.Address;

public interface AddressDao extends JpaRepository<Address, Integer>{

//	@Query(" select e from Address e where e.orderD=:id")
//	 Address getAddress(int id); 
	
	 @Query(value  ="SELECT o.id AS order_id, pa.state AS pickup_state, pa.building_name AS pickup_building_name, pa.city AS pickup_city, pa.flat_no AS pickup_flat_no, pa.pin_code AS pickup_pin_code FROM orders o JOIN address pa ON o.pickup_address_id = pa.id WHERE o.id = ?1"
	 		,nativeQuery = true)
		Object[] getAddress(int id);
}
