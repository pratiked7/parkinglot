package models;

import models.constants.ParkingLotStatus;
import models.constants.VehicleType;

import java.util.List;

public class ParkingLot extends BaseModel{

    private String name;
    private String address;
    private List<ParkingFloor> parkingFloors;
    private ParkingLotStatus parkingLotStatus;
    private List<VehicleType> supportedVehicleType;

    private SlotAllocationStrategy slotAllocationStrategy;
    private BillCalculationStrategy billCalculationStrategy;


}
