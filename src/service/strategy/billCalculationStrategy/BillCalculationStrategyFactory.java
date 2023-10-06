package service.strategy.billCalculationStrategy;

public class BillCalculationStrategyFactory {

    //TODO: add enum for different strategies
    public static BillCalculationStrategy getBillCalculationStrategy(){
        return new LowBillCalculationStrategy();
    }
}
