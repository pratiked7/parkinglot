import repository.GateRepository;
import repository.ParkingFloorRepository;
import repository.ParkingLotRepository;
import repository.ParkingSlotRepository;
import service.InitServiceImpl;

public class Main {

    public static void main(String[] args) {

        ParkingLotRepository parkingLotRepository = new ParkingLotRepository();
        ParkingFloorRepository parkingFloorRepository = new ParkingFloorRepository();
        GateRepository gateRepository = new GateRepository();
        ParkingSlotRepository parkingSlotRepository = new ParkingSlotRepository();

        InitServiceImpl initService = new InitServiceImpl(parkingSlotRepository, parkingFloorRepository, gateRepository, parkingLotRepository);
        initService.init();


    }
}
