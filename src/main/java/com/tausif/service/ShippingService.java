package com.tausif.service;

import org.springframework.stereotype.Service;

@Service
public class ShippingService {

    public double calculateCharge(double distance, double weight, String deliverySpeed) {
    	
        double rate;

        if (distance > 500) {
            rate = 1;
        } else if (distance > 100) {
            rate = 2;
        } else {
            rate = 3;
        }

        double charge = distance * weight * rate;

        if ("express".equalsIgnoreCase(deliverySpeed)) {
            charge += weight * 1.2;
        }

        return charge + 10;
    }
}