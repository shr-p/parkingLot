package com.parkinglot.controllers;

import com.parkinglot.dto.GenerateTicketRequestDto;
import com.parkinglot.dto.GenerateTicketResponseDto;
import com.parkinglot.models.Gate;
import com.parkinglot.models.Ticket;
import com.parkinglot.models.Vehicle;
import com.parkinglot.services.TicketService;

public class TicketController {

    private TicketService ticketService;

    public TicketController(TicketService ticketService){
        this.ticketService = ticketService;
    }

    // generate Ticket is used by the client, So it is nota  good idea to expose our internal models to our client.
    public GenerateTicketResponseDto generateTicket(GenerateTicketRequestDto requestDto){
        //1. get the vehicle from the DB.
        //2. If the vehicle is there get the details else create the vehicle and store it in the DB.

        // 2 ways to fetch data from DB.
        /*
            => Controllers should be as light as possible.
            -> 1. vehicleService.getVehicleByVehicleNumber(number) = Better Approach.
            -> 2. vehicleRepository.fetchVehicle(number)
        */

        Ticket ticket = ticketService.generateTicket(requestDto.getVehicleNumber(),  requestDto.getVehicleType(), requestDto.getGateId());

        GenerateTicketResponseDto responseDto = new GenerateTicketResponseDto();
        responseDto.setTicket(ticket);
        //responseDto.setResponseStatus();
        return null;
    }
}

/*
We are exposing the models directly to the client, Not a good approach.

problems with directly involving Models in the Controller API's :-

1. If we add/remove models from the input, current clients will start failing.
2. We should not expose the Model details to client because of privacy.

The solution to this : Data Transfer Objects (DTO).
 */