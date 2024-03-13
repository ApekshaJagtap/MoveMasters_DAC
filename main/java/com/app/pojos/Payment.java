
package com.app.pojos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.app.enums.PaymentStatus;
import com.app.enums.PaymentType;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name="payments")
public class Payment extends BaseEntity
{

	@Column(unique=true,nullable=false)
	private int transactionId;
	
	@Column(nullable=false)
	private double amount;
	
	@Enumerated(EnumType.STRING)
	@Column(nullable=false)
	private PaymentType paymentType;
	
	@Column(nullable=false)
	@Enumerated(EnumType.STRING)
	private PaymentStatus status;
	
	@OneToOne(mappedBy="payment")
	private Order order;
	
	
	

}
