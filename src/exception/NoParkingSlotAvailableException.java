package exception;

public class NoParkingSlotAvailableException extends RuntimeException{

    public NoParkingSlotAvailableException(String message) {
        super(message);
    }
}
