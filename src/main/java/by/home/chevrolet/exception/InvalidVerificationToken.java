package by.home.chevrolet.exception;

public class InvalidVerificationToken extends RuntimeException{
    public InvalidVerificationToken(String message) {
        super(message);
    }
}
