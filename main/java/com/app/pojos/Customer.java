package com.app.pojos;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name="customers")
@ToString(exclude="address")
public class Customer extends User 
{
	@OneToMany(mappedBy="customer", cascade=CascadeType.ALL, orphanRemoval=true ,fetch = FetchType.EAGER)
	private List<Address> address=new ArrayList<>();
	
	@OneToMany(mappedBy="customer", cascade=CascadeType.ALL, orphanRemoval=true)
	private List<Order> order=new ArrayList<>();
	
	//helper method to add and address to list
	public void addAddress(Address addr)
	{
		address.add(addr);
		addr.setCustomer(this);
	}
	public void removeAddress(Address addr)
	{
		address.remove(addr);
		addr.setCustomer(null);
	}
	
	//helper method to add and order to list
	public void addOrder(Order ord)
	{
		order.add(ord);
		ord.setCustomer(this);
	}
	public void removeOrder(Order ord)
	{
		order.remove(ord);
		ord.setCustomer(null);
	}

	
	
}
