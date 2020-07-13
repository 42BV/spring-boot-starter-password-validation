package nl._42.password.validation;

public class PasswordValidationErrorCodes {
    public static final String NOT_LONG_ENOUGH = "NOT_LONG_ENOUGH";
    public static final String NOT_STRONG_ENOUGH = "NOT_STRONG_ENOUGH";
    public static final String MATCHES_CURRENT = "MATCHES_CURRENT";
    public static final String USED_IN_PAST = "USED_IN_PAST";

    private PasswordValidationErrorCodes() {
    }
}
