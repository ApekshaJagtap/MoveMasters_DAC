package com.app.service;

import com.app.dto.VehicleDto;
import com.app.pojos.Vehicle;

public interface VehicleService {

	VehicleDto getVehicleInfo(int id);

	VehicleDto addVehicle(VehicleDto vehicle);

	VehicleDto updateVehicle(VehicleDto vehicle, int id);

}
