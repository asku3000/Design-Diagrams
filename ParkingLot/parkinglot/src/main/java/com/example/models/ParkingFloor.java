package com.example.models;

import java.util.ArrayList;
import java.util.List;

import lombok.Builder;
import lombok.Getter;
import lombok.experimental.SuperBuilder;

@Getter
@SuperBuilder
public class ParkingFloor extends BaseModel {

    @Builder.Default
    private List<ParkingSpot> parkingSpots = new ArrayList<>();

    private PaymentCounter paymentCounter;
}