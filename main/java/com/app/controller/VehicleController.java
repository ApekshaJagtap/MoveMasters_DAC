package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.VehicleDto;
import com.app.pojos.Vehicle;
import com.app.service.VehicleService;

@RestController
@RequestMapping("/vehicle")
@CrossOrigin(origins = "http://localhost:3000")
public class VehicleController {
	@Autowired
	private VehicleService vehService;
	
	@GetMapping("/{id}")
	public VehicleDto getVehicleById(@PathVariable int id)
	{
		return vehService.getVehicleInfo(id);
	}
	
	@PostMapping
	public VehicleDto addNewVehicle(VehicleDto vehicle)
	{
		return vehService.addVehicle(vehicle);
	}
	
	@PutMapping("/{id}")
	public VehicleDto updateExistingVehicle(VehicleDto vehicle,@PathVariable int id)
	{
		return vehService.updateVehicle(vehicle,id);
	}

}
