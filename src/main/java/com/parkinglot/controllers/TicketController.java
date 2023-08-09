package com.parkinglot.controllers;

import com.parkinglot.dto.GenerateTicketRequestDto;
import com.parkinglot.dto.GenerateTicketResponseDto;
import com.parkinglot.models.Gate;
import com.parkinglot.models.Ticket;
import com.parkinglot.models.Vehicle;

public class TicketController {
    public GenerateTicketResponseDto generateTicket(GenerateTicketRequestDto requestDto){
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