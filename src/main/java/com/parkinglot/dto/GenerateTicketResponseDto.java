package com.parkinglot.dto;

import com.parkinglot.models.ResponseStatus;
import com.parkinglot.models.Ticket;

public class GenerateTicketResponseDto {

    private Ticket ticket;
    private ResponseStatus responseStatus;
    public Ticket getTicket() {
        return ticket;
    }

    public ResponseStatus getResponseStatus() {
        return responseStatus;
    }

    public void setResponseStatus(ResponseStatus responseStatus) {
        this.responseStatus = responseStatus;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }
}
