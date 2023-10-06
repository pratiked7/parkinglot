package repository;

import exception.GateNotFoundException;
import exception.ParkingSlotNotFoundException;
import models.Gate;
import models.ParkingSlot;

import java.util.HashMap;

public class ParkingSlotRepository {

    private HashMap<Integer, ParkingSlot> parkingSlotMap;

    public ParkingSlotRepository() {
        this.parkingSlotMap = new HashMap<>();
    }

    public ParkingSlot get(int gateId){
        ParkingSlot parkingSlot = parkingSlotMap.get(gateId);
        if(parkingSlot == null){
            throw new ParkingSlotNotFoundException("Parking slot not found for Id: " + gateId);
        }
        return parkingSlot;
    }

    public ParkingSlot put(ParkingSlot parkingSlot){
        parkingSlotMap.put(parkingSlot.getId(), parkingSlot);
        return parkingSlot;
    }
}
