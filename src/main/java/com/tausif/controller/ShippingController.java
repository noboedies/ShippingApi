package com.tausif.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import com.tausif.dto.*;
import com.tausif.entity.*;
import com.tausif.repository.*;
import com.tausif.service.*;
import com.tausif.util.DistanceUtil;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class ShippingController {

    private final WarehouseService warehouseService;
    private final ShippingService shippingService;
    private final CustomerRepository customerRepository;
    private final ProductRepository productRepository;

    @PostMapping("/shipping-charge/calculate")
    public ShippingResponse calculate(@RequestBody ShippingRequest request) {

        Warehouse warehouse = warehouseService
                .findNearestWarehouse(request.getSellerId());

        Customer customer = customerRepository
                .findById(request.getCustomerId())
                .orElseThrow(() -> new RuntimeException("Customer not found"));

        Product product = productRepository
                .findAll()
                .stream()
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Product not found"));

        double distance = DistanceUtil.calculateDistance(
                warehouse.getLatitude(),
                warehouse.getLongitude(),
                customer.getLatitude(),
                customer.getLongitude());

        double charge = shippingService.calculateCharge(
                distance,
                product.getWeight(),
                request.getDeliverySpeed());

        return new ShippingResponse(charge, warehouse.getId());
    }
}