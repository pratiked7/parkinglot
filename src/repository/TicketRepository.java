package repository;

import exception.TicketNotFoundException;
import models.Ticket;

import java.util.HashMap;

public class TicketRepository {

    private HashMap<Integer, Ticket> ticketMap;

    public TicketRepository() {
        this.ticketMap = new HashMap<>();
    }

    public Ticket get(int ticketId){
        Ticket ticket = ticketMap.get(ticketId);
        if(ticket == null){
            throw new TicketNotFoundException("Ticket not found for Id: " + ticketId);
        }
        return ticket;
    }

    public Ticket put(Ticket ticket){
        ticketMap.put(ticket.getId(), ticket);
        return ticket;
    }
}
