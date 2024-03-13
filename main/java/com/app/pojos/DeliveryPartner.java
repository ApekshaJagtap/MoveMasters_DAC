package com.app.pojos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Lob;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.app.enums.PaymentStatus;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name="delivery_partners")
public class DeliveryPartner extends User
{
	@Column(unique=true)
	private long licenceNo;
	
	@Lob
	private byte[] userImage;
	
	@Enumerated(EnumType.STRING)
	private PaymentStatus paymentStatus;

	@OneToOne
	private Vehicle vehicle;
}
