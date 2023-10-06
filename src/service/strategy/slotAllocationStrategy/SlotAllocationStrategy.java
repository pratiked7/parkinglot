package service.strategy.slotAllocationStrategy;

import models.Gate;
import models.ParkingLot;
import models.ParkingSlot;
import models.constants.VehicleType;

public interface SlotAllocationStrategy {
    ParkingSlot findParkingSlot(VehicleType vehicleType, ParkingLot parkingLot, Gate entryGate);
}
