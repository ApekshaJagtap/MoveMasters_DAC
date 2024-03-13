package com.app.pojos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="address")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Address extends BaseEntity
{
	
	@Column(nullable=false)
	private String city;
	
	@Column(nullable=false)
	private int pinCode;
	
	@Column(nullable=false)
	private String State;
	
	@Column(nullable=false)
	private int flatNo;
	
	@Column(nullable=false)
	private String buildingName;
	
	@Column(nullable=false)
	private String streetName;
	
	
	@ManyToOne()
	@JoinColumn(name="customer_id")
	private Customer customer;
	
	@OneToOne(mappedBy="pickup_address", fetch = FetchType.LAZY)
	private Order orderP;
	
	@OneToOne(mappedBy="drop_address", fetch = FetchType.LAZY)
	private Order orderD;

}
