package com.tausif.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ShippingResponse {
	
	private double shippingCharge;
	private Long warehouseId;
}
