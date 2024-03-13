package com.app.pojos;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.app.enums.RequestStatus;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@ToString
@Getter
@Setter
public class Request {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int weight;
    private int cost;
    private Long customerId;
    private String pickupAddress;
    private String deliveryAddress;
    private int orderId;
    @Enumerated(EnumType.STRING)
    private RequestStatus status;
    
    public Request() {
        this.status = RequestStatus.NOTVISITED;
    }
    
}
