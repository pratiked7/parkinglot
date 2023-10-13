package service.strategy.slotAllocationStrategy;

import exception.NoParkingSlotAvailableException;
import models.Gate;
import models.ParkingLot;
import models.ParkingSlot;
import models.constants.ParkingSlotStatus;
import models.constants.VehicleType;

public class NearestSlotAllocationStrategy implements SlotAllocationStrategy{

    @Override
    public ParkingSlot findParkingSlot(VehicleType vehicleType, ParkingLot parkingLot, Gate entryGate) {

        int floorNumber = entryGate.getFloorNumber();

        ParkingSlot onTheSameFloor = searchAvailableSlot(parkingLot, vehicleType, floorNumber);
        if(onTheSameFloor != null){
            return onTheSameFloor;
        }

        int i = floorNumber - 1;
        int j = floorNumber + 1;

        while (i >= 0 || j < parkingLot.getParkingFloors().size()){
            if(i >= 0){
                ParkingSlot downFloor = searchAvailableSlot(parkingLot, vehicleType, i);
                if(downFloor != null){
                    return downFloor;
                }
            }

            if(j < parkingLot.getParkingFloors().size()){
                ParkingSlot upFloor = searchAvailableSlot(parkingLot, vehicleType, j);
                if(upFloor != null){
                    return upFloor;
                }
            }
            i--;
            j++;
        }

        throw new NoParkingSlotAvailableException("No parking slot available");
    }

    private ParkingSlot searchAvailableSlot(ParkingLot parkingLot, VehicleType vehicleType, int floorNumber){

        for (ParkingSlot slot: parkingLot.getParkingFloors().get(floorNumber).getParkingSlots()){
            if(slot.getSupportedVehicleType().equals(vehicleType)
                    && slot.getParkingSlotStatus().equals(ParkingSlotStatus.AVAILABLE)){
                return slot;
            }
        }
        return null;
    }
}
