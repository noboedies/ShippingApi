package com.tausif.dto;

import lombok.Data;

@Data
public class ShippingRequest {
	
	private Long sellerId;
    private Long customerId;
    private String deliverySpeed;
}
