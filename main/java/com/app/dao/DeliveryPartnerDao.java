package com.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.pojos.DeliveryPartner;

public interface DeliveryPartnerDao extends JpaRepository<DeliveryPartner, Integer> {

}
