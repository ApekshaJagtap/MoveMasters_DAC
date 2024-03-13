package com.app.dto;

import java.time.LocalDateTime;

import javax.validation.constraints.NotNull;

import com.app.enums.OrderStatus;
import com.app.pojos.Customer;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderDto {
	
	@JsonProperty(access=Access.READ_ONLY)
	private Integer id;
	
	@NotNull
	private double weight;
	
	@NotNull
	private double cost;
	
	@JsonProperty(access=Access.READ_ONLY)
	private OrderStatus orderStatus;
	
	private LocalDateTime shippingDateTime;
	
	private LocalDateTime deliveryDateTime;
	
	 @NotNull
	 private Integer customerId;

}
