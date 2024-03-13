package com.app.dto;


import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PaymentDto {
    
    private Integer id;
    private Double amount;
    private LocalDateTime paymentDate;
    private String paymentMethod;
    
}
