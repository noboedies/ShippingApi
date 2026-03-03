package com.tausif.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import com.tausif.entity.Seller;
import com.tausif.entity.Warehouse;
import com.tausif.repository.SellerRepository;
import com.tausif.repository.WarehouseRepository;
import com.tausif.util.DistanceUtil;

import java.util.Comparator;

@Service
@RequiredArgsConstructor
public class WarehouseService {

    private final WarehouseRepository warehouseRepository;
    private final SellerRepository sellerRepository;

    public Warehouse findNearestWarehouse(Long sellerId) {

        Seller seller = sellerRepository.findById(sellerId)
                .orElseThrow(() -> new RuntimeException("Seller not found"));

        return warehouseRepository.findAll()
                .stream()
                .min(Comparator.comparing(w ->
                        DistanceUtil.calculateDistance(
                                seller.getLatitude(),
                                seller.getLongitude(),
                                w.getLatitude(),
                                w.getLongitude())))
                .orElseThrow(() -> new RuntimeException("No warehouse found"));
    }
}