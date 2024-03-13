package com.app.service;

import java.util.List;

import com.app.pojos.DeliveryPartner;

public interface DeliveryPartnerService {
	List<DeliveryPartner> getAllDeliveryPartners();

	DeliveryPartner addDPDetails(DeliveryPartner newDeliveryPartner);

	String deleteDPDetails(Integer DeliveryPartnerId);

	DeliveryPartner updateDPDetails(DeliveryPartner newDeliveryPartner);
}
