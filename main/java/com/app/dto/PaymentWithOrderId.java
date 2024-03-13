package com.app.dto;

import com.app.pojos.Payment;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class PaymentWithOrderId {
    private Integer orderId;
    private Payment payment;
}
