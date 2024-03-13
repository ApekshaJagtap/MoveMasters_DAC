package com.app.pojos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.app.enums.VehicleType;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name="vehicles")
public class Vehicle extends BaseEntity
{
	@Column(unique=true, nullable=false)
	private String vehicleNo;
	
	@Enumerated(EnumType.STRING)
	@Column(nullable=false)
	private VehicleType vehicleType;
	
	@OneToOne(mappedBy="vehicle")
	@JoinColumn(name="deliverypartner_id")
	private DeliveryPartner deliveryPartner;

}
