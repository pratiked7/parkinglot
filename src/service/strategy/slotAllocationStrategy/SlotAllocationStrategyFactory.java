package service.strategy.slotAllocationStrategy;

public class SlotAllocationStrategyFactory {

    //TODO: use switch case to select correct strategy

    public static SlotAllocationStrategy getSlotAllocationStrategy(){
        return new NearestSlotAllocationStrategy();
    }


}
