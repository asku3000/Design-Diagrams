package com.example.services;

import com.example.models.ParkingLot;
import com.example.models.ParkingSpot;
import com.example.repositories.ParkingSpotRepository;
import lombok.AllArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
public class ParkingSpotService {

    private ParkingSpotRepository repository;

    public List<ParkingSpot> createSpots(ParkingLot parkingLot) {
        List<ParkingSpot> parkingSpots = parkingLot
                .getFloors()
                .stream()
                .flatMap(floor -> floor.getParkingSpots().stream())
                .collect(Collectors.toList());
        return repository.saveAll(parkingSpots);
    }

}