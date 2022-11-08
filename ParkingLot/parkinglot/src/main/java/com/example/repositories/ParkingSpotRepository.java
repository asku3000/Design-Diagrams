package com.example.repositories;

import com.example.models.ParkingSpot;

import java.util.ArrayList;
import java.util.List;

public class ParkingSpotRepository {
    private List<ParkingSpot> parkingSpots = new ArrayList<>();

    public ParkingSpot save(ParkingSpot parkingSpot) {
        parkingSpots.add(parkingSpot);
        return parkingSpot;
    }

    public List<ParkingSpot> saveAll(List<ParkingSpot> parkingSpots) {
        this.parkingSpots.addAll(parkingSpots);
        return parkingSpots;
    }

}