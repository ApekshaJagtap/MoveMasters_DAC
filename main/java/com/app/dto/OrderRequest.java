package com.app.dto;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class OrderRequest {
	@JsonProperty(access=Access.READ_ONLY)
	private Integer id;
    private double weight;
    private double cost;
    @NotNull
    private Integer customerId;
    private AddressDto pickupAddress;
    private AddressDto deliveryAddress;
    private CustomerDto customer; 

}
