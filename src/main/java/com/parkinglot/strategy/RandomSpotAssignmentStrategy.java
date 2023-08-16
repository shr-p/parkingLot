package com.parkinglot.strategy;

import com.parkinglot.models.*;
import com.parkinglot.services.ParkingLotService;
import com.parkinglot.services.ParkingSpotService;

import java.util.List;

public class RandomSpotAssignmentStrategy implements SpotAssignmentStrategy{

    private ParkingLotService parkingLotService;
    private ParkingSpotService parkingSpotService;
    public  RandomSpotAssignmentStrategy(ParkingLotService parkingLotService, ParkingSpotService parkingSpotService){
        this.parkingLotService  = parkingLotService;
        this.parkingSpotService = parkingSpotService;
    }
    @Override
    public ParkingSpot assignSpot(VehicleType vehicleType, Gate gate) {
        // From gate get the Parking Lot

        ParkingLot parkingLot = parkingLotService.getParkingLotForGate(gate);
        List<ParkingSpot> parkingSpots = parkingSpotService.getParkingSpotsByLot(parkingLot);

        for (ParkingSpot parkingSpot :
                parkingSpots) {
            if(parkingSpot.getParkingSpotStatus().equals(ParkingSpotStatus.AVAILABLE) && parkingSpot.getSupportedVehicleTypes().contains(vehicleType)){
                    return parkingSpot;
            }
        }
        return null;
    }
}
