package nl._42.password.validation;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

@Component
@ConditionalOnProperty("password.strength-enabled")
public class PasswordStrengthRule implements ValidationRule {
    @Override
    public void validate(String password, Authentication authentication) {
        if (!password.matches("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=.,?!])(?=\\S+$).*$")) {
            throw new PasswordValidationFailedException(PasswordValidationErrorCodes.NOT_STRONG_ENOUGH);
        }
    }
}
