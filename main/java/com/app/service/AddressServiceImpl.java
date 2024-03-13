package com.app.service;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.AddressDao;
import com.app.dto.AddressDto;
import com.app.pojos.Address;

@Service
@Transactional
public class AddressServiceImpl implements AddressService {
	
	@Autowired
	private AddressDao addrDao;
	
	@Autowired
	private ModelMapper mapper;

//	@Override
//	public AddressDto getAddress(int id) {
//		Address addr=addrDao.getAddress(id);
//		return mapper.map(addr, AddressDto.class);
//	}
	@Override
	public Object[] getAddress(int id) {
		Object[] addr=addrDao.getAddress(id);
		return addr;
	}
	
	public AddressDto addAddress(AddressDto address, Integer id) {
        Address add=mapper.map(address, Address.class);
        Address addr= addrDao.save(add);
        return mapper.map(addr, AddressDto.class);
    }

}
