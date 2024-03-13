package com.app.pojos;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

import com.app.enums.OrderStatus;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name="orders")
public class Order extends BaseEntity
{

	private double weight;
	
	@Column(nullable=false)
	private double cost;
	
	@Enumerated(EnumType.STRING)
	private OrderStatus orderStatus;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDateTime shippingDateTime;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDateTime deliveryDateTime;
	
	@ManyToOne
	@JoinColumn(name="customer_id")
	private Customer customer;
	
	@OneToOne
	private Address pickup_address;
	
	@OneToOne()
	private Address drop_address;
	
	@OneToOne
	private Payment payment;
	

	
}
