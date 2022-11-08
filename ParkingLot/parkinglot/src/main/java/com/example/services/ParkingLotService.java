package com.example.services;

import com.example.models.ParkingLot;
import com.example.models.ParkingSpot;
import com.example.repositories.ParkingLotRepository;
import lombok.AllArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
public class ParkingLotService {

    private ParkingLotRepository repository;
    private ParkingSpotService parkingSpotService;

    public ParkingLot createParkingLot(ParkingLot parkingLot) {
        ParkingLot lot = repository.save(parkingLot);

        // Create parking spots
        parkingSpotService.createSpots(parkingLot);
        return lot;
    }
}
