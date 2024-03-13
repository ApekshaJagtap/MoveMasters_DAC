package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.pojos.DeliveryPartner;
import com.app.service.DeliveryPartnerService;

@RestController
@RequestMapping("/deliverypartner")
@CrossOrigin(origins = "http://localhost:3000")
public class DeliveryPartnerController {
	
	@Autowired
	private DeliveryPartnerService dpService;
	
	public DeliveryPartnerController() {
		System.out.println("in ctor of " + getClass());
	}

	@PostMapping("/add")
	public DeliveryPartner addDpDetails(@RequestBody DeliveryPartner newDP)
	{
		System.out.println("in add dp " + newDP);
		return dpService.addDPDetails(newDP);

	}
	
	@GetMapping("/getAll")
	public List<DeliveryPartner> listAllDps() {
		System.out.println("in list all delivery partners");
		return dpService.getAllDeliveryPartners();
	}
	
	@PutMapping("/update")
	public DeliveryPartner updateDpDetails(@RequestBody DeliveryPartner dp)
	{
		System.out.println("in update delivery partner details");
		return dpService.updateDPDetails(dp);
	}
		
	@DeleteMapping("/delete/{dpId}")
	public String deleteDpDetails(@PathVariable Integer dpId) {
		System.out.println("in del dp dtls " + dpId);
		return dpService.deleteDPDetails(dpId);
	}

}
