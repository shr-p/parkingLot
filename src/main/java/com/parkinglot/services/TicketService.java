package com.parkinglot.services;

import com.parkinglot.models.*;
import com.parkinglot.strategy.SpotAssignmentStrategy;


public class TicketService {

    private VehicleService vehicleService;
    private GateService gateService;

    private SpotAssignmentStrategy spotAssignmentStrategy;
    public TicketService(VehicleService vehicleService, GateService gateService, SpotAssignmentStrategy spotAssignmentStrategy){
        this.vehicleService = vehicleService;
        this.gateService = gateService;
        this.spotAssignmentStrategy = spotAssignmentStrategy;
    }
    public Ticket generateTicket(String vehicleNumber, VehicleType vehicleType, Long gateId){
        /*
            1. Get the Vehicle details from the DB, if the vehicle is not present create a vehicle object and store in the DB.

         */

        Vehicle vehicle = vehicleService.getVehicle(vehicleNumber);

        if(vehicle == null){
            vehicle = vehicleService.registerVehicle(vehicleNumber, vehicleType);
        }

        Gate gate = gateService.getGateUsingId(gateId);

        Ticket ticket = new Ticket();
        ticket.setVehicle(vehicle);
        ticket.setGate(gate);
        ticket.setOperator(gate.getOperator());
        ticket.setEntryTime(System.currentTimeMillis());

        //  Parking Spot Assignment
        ParkingSpot parkingSpot = spotAssignmentStrategy.assignSpot(vehicleType, gate);

        if(parkingSpot == null){
            // No parking sot is available/
            //Throw an Exception
        }
        ticket.setParkingSpot(parkingSpot);
        return null;
    }
}
