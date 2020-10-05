package by.home.chevrolet.exception;

public class FailedEmailSendException extends RuntimeException{
    public FailedEmailSendException(String message) {
        super(message);
    }
}
