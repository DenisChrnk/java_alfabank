package homework12.exceptions;

public class InvalidPassengerNameException extends RuntimeException{
    public InvalidPassengerNameException(String message) {
        super(message);
    }
}
