package controller;

import dto.TicketRequestDTO;
import dto.TicketResponseDTO;
import models.Vehicle;
import repository.GateRepository;
import repository.ParkingLotRepository;
import repository.TicketRepository;
import service.TicketService;
import service.TicketServiceImpl;

public class TicketController {


    private TicketService ticketService;


    public TicketController(ParkingLotRepository parkingLotRepository, GateRepository gateRepository, TicketRepository ticketRepository){
        this.ticketService = new TicketServiceImpl();
    } {
    }

    public TicketResponseDTO createTicket(TicketRequestDTO ticketRequestDTO){

        Vehicle vehicle = new Vehicle();
    }
}
