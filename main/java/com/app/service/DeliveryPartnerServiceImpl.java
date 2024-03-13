package com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.DeliveryPartnerDao;
import com.app.pojos.DeliveryPartner;

@Service
@Transactional
public class DeliveryPartnerServiceImpl implements DeliveryPartnerService {

	@Autowired
	private DeliveryPartnerDao dpDao;

	@Override
	public List<DeliveryPartner> getAllDeliveryPartners() {

		return dpDao.findAll();
	}

	@Override
	public DeliveryPartner addDPDetails(DeliveryPartner newDeliveryPartner) {
		return dpDao.save(newDeliveryPartner);
	}

	@Override
	public String deleteDPDetails(Integer DeliveryPartnerId) {
		if (dpDao.existsById(DeliveryPartnerId)) {
			dpDao.deleteById(DeliveryPartnerId);
			return "Deleted Delivery Partner details....";
		}
		return "Invalid Delivery Partner id !!!!!!";
	}

	@Override
	public DeliveryPartner updateDPDetails(DeliveryPartner newDP) {
		DeliveryPartner oldDP = dpDao.findById(newDP.getId()).orElse(null);
		oldDP.setFirstName(newDP.getFirstName());
		oldDP.setLastName(newDP.getLastName());
		oldDP.setEmail(newDP.getEmail());
		oldDP.setPhoneNumber(newDP.getPhoneNumber());
		oldDP.setPassword(newDP.getPassword());
		oldDP.setLicenceNo(newDP.getLicenceNo());
		oldDP.setPaymentStatus(newDP.getPaymentStatus());
		oldDP.setVehicle(newDP.getVehicle());
		return dpDao.save(oldDP);
	}

}
