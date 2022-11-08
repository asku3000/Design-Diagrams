package com.example.parkinglot;

import com.example.controllers.ParkingLotController;
import com.example.dto.CreateLotRequest;
import com.example.models.ParkingLot;
import com.example.repositories.ParkingLotRepository;
import com.example.repositories.ParkingSpotRepository;
import com.example.services.ParkingLotService;
import com.example.services.ParkingSpotService;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class ParkingLotTest {
    private ParkingLotController parkingLotController;
    private ParkingLotService parkingLotService;
    private ParkingSpotService parkingSpotService;

    @Before
    public void setUp() {
        parkingSpotService = new ParkingSpotService(new ParkingSpotRepository());
        parkingLotService = new ParkingLotService(new ParkingLotRepository(), parkingSpotService);
        parkingLotController = new ParkingLotController(parkingLotService);
    }

    @Test
    public void testCreateParkingLot() {
        CreateLotRequest request = CreateLotRequest.builder()
                .id(1L)
                .address("221B Baker Street")
                .name("Gringotts")
                .numberOfFloors(2)
                .numberOfGates(5)
                .numberOfSlotsPerFloor(5)
                .build();

        ParkingLot actual = parkingLotController.createParkingLot(request);
        assertNotNull("If parking lot is created, it should not be null", actual);

        assertEquals("If parking lot is created, it should have same id as requested", request.getId(), actual.getId());

        assertEquals("If parking lot is created, it should have same number of floors as requested",
                request.getNumberOfFloors(), actual.getFloors().size());

        assertEquals("If parking lot is created, it should have same number of slots per floor as requested",
                request.getNumberOfSlotsPerFloor(), actual.getFloors().get(0).getParkingSpots().size());

        assertEquals("If parking lot is created, it should have same number of entry gates as requested",
                request.getNumberOfGates(), actual.getEntryGates().size());
    }
}
