package service.strategy.billCalculationStrategy;

import models.Ticket;

import java.time.LocalDateTime;

public class LowBillCalculationStrategy implements BillCalculationStrategy{

    private static final int PER_HOUR_CHARGE_2_WHEELER = 50;
    private static final int PER_HOUR_CHARGE_4_WHEELER = 100;
    private static final double INCREMENT_FACTOR = 1.5;

    @Override
    public double calculateBillAmount(Ticket ticket, LocalDateTime exitTime) {
        return 0;
    }
}
