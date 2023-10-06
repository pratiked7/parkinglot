package repository;

import exception.ParkingLotNotFoundException;
import exception.ParkingSlotNotFoundException;
import models.ParkingLot;
import models.ParkingSlot;

import java.util.HashMap;

public class ParkingLotRepository {

    private HashMap<Integer, ParkingLot> parkingLotMap;

    public ParkingLotRepository() {
        this.parkingLotMap = new HashMap<>();
    }

    public ParkingLot get(int gateId){
        ParkingLot parkingLot = parkingLotMap.get(gateId);
        if(parkingLot == null){
            throw new ParkingLotNotFoundException("Parking slot not found for Id: " + gateId);
        }
        return parkingLot;
    }

    public ParkingLot put(ParkingLot parkingLot){
        parkingLotMap.put(parkingLot.getId(), parkingLot);
        return parkingLot;
    }
}
