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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InitServiceImpl implements InitService {

    private ParkingSlotRepository parkingSlotRepository;
    private ParkingFloorRepository parkingFloorRepository;
    private GateRepository gateRepository;
    private ParkingLotRepository parkingLotRepository;

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
        ParkingLot parkingLot = new ParkingLot();
        parkingLot.setId(1);
        parkingLot.setName("Parking Lot 1");
        parkingLot.setAddress("Street 123");
        parkingLot.setParkingLotStatus(ParkingLotStatus.OPEN);
        parkingLot.setSupportedVehicleType(new ArrayList<>(Arrays.asList(VehicleType.CAR, VehicleType.BIKE)));
        List<ParkingFloor> floors = new ArrayList<>();

        for (int i = 0; i < 10; i++) {

            ParkingFloor parkingFloor = new ParkingFloor();
            parkingFloor.setId(i);
            parkingFloor.setFloorNumber(i);
            List<ParkingSlot> slots = new ArrayList<>();

            for (int j = 1; j <= 10; j++) {
                ParkingSlot parkingSlot = new ParkingSlot();
                parkingSlot.setNumber(i * 100 + j);
                if(j%2 == 0){
                    parkingSlot.setSupportedVehicleType(VehicleType.CAR);
                } else {
                    parkingSlot.setSupportedVehicleType(VehicleType.BIKE);
                }
                parkingSlot.setParkingSlotStatus(ParkingSlotStatus.AVAILABLE);
                slots.add(parkingSlot);
                parkingSlotRepository.put(parkingSlot);
            }
            parkingFloor.setParkingSlots(slots);

            Gate entryGate = new Gate();
            entryGate.setId(i * 10 + 1);
            entryGate.setGateNumber(String.valueOf(i * 10 + 1));
            entryGate.setGateStatus(GateStatus.OPEN);
            entryGate.setGateType(GateType.ENTRY);
            entryGate.setOperator("Rahul");
            entryGate.setParkingLotId(1);
            entryGate.setFloorNumber(i);

            Gate exitGate = new Gate();
            exitGate.setId(i * 10 + 1);
            exitGate.setGateNumber(String.valueOf(i * 10 + 1));
            exitGate.setGateStatus(GateStatus.OPEN);
            exitGate.setGateType(GateType.EXIT);
            exitGate.setOperator("Ram");
            exitGate.setParkingLotId(1);
            exitGate.setFloorNumber(i);

            gateRepository.put(exitGate);
            gateRepository.put(exitGate);

            List<Gate> gates = new ArrayList<>(Arrays.asList(entryGate, exitGate));
            parkingFloor.setGates(gates);

            floors.add(parkingFloor);
            parkingFloorRepository.put(parkingFloor);
        }

        parkingLot.setParkingFloors(floors);
        parkingLotRepository.put(parkingLot);

    }
}
