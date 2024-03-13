package com.app.dto;

import javax.validation.constraints.NotBlank;

import com.app.enums.VehicleType;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class VehicleDto {
	
	@JsonProperty(access=Access.READ_ONLY)
	private Integer id;
	
	@NotBlank
	private String vehicleNo;
	
	@NotBlank
	private VehicleType vehicleType;
	

}
