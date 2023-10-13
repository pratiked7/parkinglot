package service;

import models.Gate;
import models.ParkingFloor;
import models.ParkingLot;
import models.ParkingSlot;
import models.constants.*;
import repository.GateRepository;
import repository.ParkingFloorRepository;
import repository.ParkingLotRepository;
import repository.ParkingSlotRepository;
import service.strategy.billCalculationStrategy.BillCalculationStrategyFactory;
import service.strategy.slotAllocationStrategy.SlotAllocationStrategyFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InitServiceImpl implements InitService {

    private final ParkingSlotRepository parkingSlotRepository;
    private final ParkingFloorRepository parkingFloorRepository;
    private final GateRepository gateRepository;
    private final ParkingLotRepository parkingLotRepository;

    public InitServiceImpl(ParkingSlotRepository parkingSlotRepository,
                           ParkingFloorRepository parkingFloorRepository,
                           GateRepository gateRepository,
                           ParkingLotRepository parkingLotRepository) {
        this.parkingSlotRepository = parkingSlotRepository;
        this.parkingFloorRepository = parkingFloorRepository;
        this.gateRepository = gateRepository;
        this.parkingLotRepository = parkingLotRepository;
    }

    @Override
    public void init() {

        //add a parking lot
        ParkingLot parkingLot = new ParkingLot();
        parkingLot.setId(1);
        parkingLot.setName("Parking Lot 1");
        parkingLot.setAddress("Street 123");
        parkingLot.setParkingLotStatus(ParkingLotStatus.OPEN);
        parkingLot.setSupportedVehicleType(new ArrayList<>(Arrays.asList(VehicleType.CAR, VehicleType.BIKE)));
        parkingLot.setSlotAllocationStrategy(SlotAllocationStrategyFactory.getSlotAllocationStrategy());
        parkingLot.setBillCalculationStrategy(BillCalculationStrategyFactory.getBillCalculationStrategy());

        //add floors
        List<ParkingFloor> floors = new ArrayList<>();

        for (int i = 0; i < 10; i++) {

            ParkingFloor parkingFloor = new ParkingFloor();
            parkingFloor.setId(i);
            parkingFloor.setFloorNumber(i);

            //add slots
            List<ParkingSlot> slots = new ArrayList<>();

            for (int j = 1; j <= 10; j++) {

                VehicleType supportedVehicleType = j%2 != 0 ? VehicleType.BIKE : VehicleType.CAR;

                ParkingSlot parkingSlot = new ParkingSlot(i*100 + j, i*100 + j, supportedVehicleType);
                slots.add(parkingSlot);
                parkingSlotRepository.put(parkingSlot);
            }
            parkingFloor.setParkingSlots(slots);
            parkingFloor.setParkingFloorStatus(ParkingFloorStatus.OPEN);

            Gate entryGate = new Gate();
            entryGate.setId(i * 10 + 1);
            entryGate.setGateNumber(String.valueOf(i * 10 + 1));
            entryGate.setGateStatus(GateStatus.OPEN);
            entryGate.setGateType(GateType.ENTRY);
            entryGate.setOperator("Pratik");
            entryGate.setParkingLotId(1);
            entryGate.setFloorNumber(i);

            Gate exitGate = new Gate();
            exitGate.setId(i * 10 + 2);
            exitGate.setGateNumber(String.valueOf(i * 10 + 2));
            exitGate.setGateStatus(GateStatus.OPEN);
            exitGate.setGateType(GateType.EXIT);
            exitGate.setOperator("Neha");
            exitGate.setParkingLotId(1);
            exitGate.setFloorNumber(i);

            gateRepository.put(entryGate);
            gateRepository.put(exitGate);

            List<Gate> gates = new ArrayList<>(Arrays.asList(entryGate, exitGate));
            parkingFloor.setGates(gates);

            floors.add(parkingFloor);
            parkingFloorRepository.put(parkingFloor);

            floors.add(parkingFloor);
        }

        parkingLot.setParkingFloors(floors);
        parkingLotRepository.put(parkingLot);
    }
}
