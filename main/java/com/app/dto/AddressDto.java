package com.app.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class AddressDto {

	@JsonProperty(access = Access.READ_ONLY)
	private Integer id;
	@NotBlank
	private String city;
	
	@NotBlank
	private int pinCode;
	
	@NotBlank
	private String State;
	
	@NotNull
	private int flatNo;
	
	@NotBlank
	private String buildingName;
	
	@NotBlank
	private String streetName;
	
//	private Integer 
	
}
