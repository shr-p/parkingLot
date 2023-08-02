package com.scaler.parkinglot.models;

import java.util.List;

public class ParkingLot {
    private Long id;
    private List<ParkingFloor> parkingFloors;
    private List<Gate> gates;
    private ParkingLotStatus parkingLotStatus;
    private String name;
    private String address;
}
