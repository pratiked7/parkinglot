import controller.TicketController;
import dto.TicketRequestDTO;
import dto.TicketResponseDTO;
import models.ParkingLot;
import models.ParkingSlot;
import models.constants.VehicleType;
import repository.*;
import service.InitServiceImpl;

public class Main {

    public static void main(String[] args) {

        ParkingLotRepository parkingLotRepository = new ParkingLotRepository();
        ParkingFloorRepository parkingFloorRepository = new ParkingFloorRepository();
        GateRepository gateRepository = new GateRepository();
        ParkingSlotRepository parkingSlotRepository = new ParkingSlotRepository();
        TicketRepository ticketRepository = new TicketRepository();

        InitServiceImpl initService = new InitServiceImpl(parkingSlotRepository, parkingFloorRepository, gateRepository, parkingLotRepository);
        initService.init();

        TicketController ticketController = new TicketController(parkingLotRepository, gateRepository, ticketRepository);

        ParkingLot parkingLot = parkingLotRepository.get(1);

        TicketRequestDTO ticketRequestDTO = new TicketRequestDTO();
        ticketRequestDTO.setParkingLotId(1);
        ticketRequestDTO.setGateId(31);
        ticketRequestDTO.setName("BMW");
        ticketRequestDTO.setColor("White");
        ticketRequestDTO.setVehicleType(VehicleType.CAR);
        ticketRequestDTO.setNumber("MH 01 AB 555");

        TicketResponseDTO ticketResponseDTO = ticketController.createTicket(ticketRequestDTO);
        System.out.println(ticketResponseDTO);
    }
}
