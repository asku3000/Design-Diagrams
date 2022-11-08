package com.example.controllers;

import com.example.dto.CreateLotRequest;
import com.example.models.ParkingLot;
import com.example.services.ParkingLotService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;

@AllArgsConstructor
public class ParkingLotController {

    private ParkingLotService service;

    @RequestMapping
    public ParkingLot createParkingLot(CreateLotRequest request) {
        // Validate request DTOs
        validate(request);

        // 2. Data mapping
        return service.createParkingLot(request.toParkingLot());
    }

    private void validate(CreateLotRequest request) {
        if (request.getId() == null) {
            throw new RuntimeException("Id cannot be null");
        }
    }
}
