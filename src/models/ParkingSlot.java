package models;

import models.constants.ParkingSlotStatus;
import models.constants.VehicleType;

public class ParkingSlot extends BaseModel{

    private int number;
    private VehicleType supportedVehicleType;

    private ParkingSlotStatus parkingSlotStatus;

    private Vehicle vehicle;
}
