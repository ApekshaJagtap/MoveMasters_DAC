package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.AddressDto;
import com.app.service.AddressService;

@RestController
@RequestMapping("/address")
@CrossOrigin(origins = "http://localhost:3000")
public class AddressController {
	
	@Autowired
	private AddressService addrService;
	
//	@GetMapping("/{id}")
//	public AddressDto getAddressById(@PathVariable int id)
//	{
//		return addrService.getAddress(id);
//	}
	
	@GetMapping("/{id}")
	public Object[] getAddressById(@PathVariable int id)
	{
		return addrService.getAddress(id);
	}
	
	@PostMapping("/addPickupAddr/{id}")
    public AddressDto addAddress(@RequestBody AddressDto address,@PathVariable Integer id) {
        return addrService.addAddress(address,id);
    }

}
