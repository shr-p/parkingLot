package com.parkinglot.models;

import java.util.List;

public class ParkingSpot extends BaseEntity {

    private ParkingSpotStatus parkingSpotStatus;
    //private ParkingFloor parkingFloor;
    private List<VehicleType> supportedVehicleTypes;
    private int number;



    public ParkingSpotStatus getParkingSpotStatus() {
        return parkingSpotStatus;
    }

    public void setParkingSpotStatus(ParkingSpotStatus parkingSpotStatus) {
        this.parkingSpotStatus = parkingSpotStatus;
    }

    public List<VehicleType> getSupportedVehicleTypes() {
        return supportedVehicleTypes;
    }

    public void setSupportedVehicleTypes(List<VehicleType> supportedVehicleTypes) {
        this.supportedVehicleTypes = supportedVehicleTypes;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}
