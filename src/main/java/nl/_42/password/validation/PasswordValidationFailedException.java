package nl._42.password.validation;

public class PasswordValidationFailedException extends RuntimeException {
    public PasswordValidationFailedException(String message) {
        super(message);
    }
}
