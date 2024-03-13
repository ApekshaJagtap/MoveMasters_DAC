package com.app.service;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.VehicleDao;
import com.app.dto.VehicleDto;
import com.app.pojos.Vehicle;

@Service
@Transactional
public class VehicleServiceImpl implements VehicleService {
	
	@Autowired
	private VehicleDao vehDao;
	
	@Autowired
	private ModelMapper mapper;

	@Override
	public VehicleDto getVehicleInfo(int id) {
		Vehicle vehicle=vehDao.findById(id).orElseThrow();
		return mapper.map(vehicle, VehicleDto.class);
	}

	@Override
	public VehicleDto addVehicle(VehicleDto vehicle) {
		
		Vehicle veh=mapper.map(vehicle, Vehicle.class);
		Vehicle persistantVeh=vehDao.save(veh);
		return mapper.map(persistantVeh, VehicleDto.class);
	}

	@Override
	public VehicleDto updateVehicle(VehicleDto vehicle, int id) {
		Vehicle veh=vehDao.findById(id).orElseThrow();
		if(veh!=null)
		{
			veh.setVehicleNo(vehicle.getVehicleNo());
			veh.setVehicleType(vehicle.getVehicleType());
		}
		return mapper.map(veh, VehicleDto.class);
	}

}
