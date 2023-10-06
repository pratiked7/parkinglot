package service.strategy.billCalculationStrategy;

import models.Ticket;
import models.Vehicle;
import models.constants.VehicleType;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class LowBillCalculationStrategy implements BillCalculationStrategy{

    private static final int PER_HOUR_CHARGE_2_WHEELER = 50;
    private static final int PER_HOUR_CHARGE_4_WHEELER = 100;
    private static final double INCREMENT_FACTOR = 0.1;

    @Override
    public double calculateBillAmount(Ticket ticket, LocalDateTime exitTime) {

        LocalDateTime entryTime = ticket.getEntryTime();
        long totalHours = ChronoUnit.HOURS.between(exitTime, entryTime);
        //TODO: improve
        int costPerHour = (ticket.getVehicle().equals(VehicleType.CAR)) ?
                PER_HOUR_CHARGE_4_WHEELER :
                PER_HOUR_CHARGE_2_WHEELER;

        double baseCost = costPerHour * totalHours;
        return baseCost + (baseCost * (INCREMENT_FACTOR * (totalHours - 1)));
    }
}
