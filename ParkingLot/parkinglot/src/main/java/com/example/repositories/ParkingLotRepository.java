package com.example.repositories;

import com.example.models.ParkingLot;
import com.example.models.ParkingSpot;

import java.util.ArrayList;
import java.util.List;

public class ParkingLotRepository {

    private List<ParkingLot> parkingLots = new ArrayList<>();

    public ParkingLot save(ParkingLot parkingLot){
        parkingLots.add(parkingLot);
        return parkingLot;
    }

}
