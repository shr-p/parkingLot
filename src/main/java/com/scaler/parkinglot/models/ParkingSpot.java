package com.scaler.parkinglot.models;

import java.util.List;

public class ParkingSpot {
    private Long id;
    private ParkingSpotStatus parkingSpotStatus;
    private ParkingFloor parkingFloor;
    private List<VehicleType> supportedVehicleTypes;
    private int number;
}
