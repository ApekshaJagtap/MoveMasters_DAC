package com.app.service;

import com.app.dto.AddressDto;
import com.app.pojos.Address;

public interface AddressService {

	Object[] getAddress(int id);
	AddressDto addAddress(AddressDto address,Integer id);

}
