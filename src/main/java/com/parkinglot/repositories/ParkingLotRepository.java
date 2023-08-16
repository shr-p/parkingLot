package com.parkinglot.repositories;

import com.parkinglot.models.Gate;
import com.parkinglot.models.ParkingLot;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ParkingLotRepository {

    //private List<ParkingLot> parkingLots;
    private Map<Long, ParkingLot> parkingLots = new HashMap<>();
    public ParkingLot getParkingLotByGate(Gate gate){

//        for(ParkingLot parkingLot : parkingLots){
//            if(parkingLot.getGates().contains(gate)){
//                return parkingLot;
//            }
//        }

        for (ParkingLot parkingLot: parkingLots.values()) {
            for (Gate g :
                    parkingLot.getGates()) {
                if(g.getId().equals(gate.getId())){
                    return parkingLot;
                }
            }

        }
        return null;
    }
}
