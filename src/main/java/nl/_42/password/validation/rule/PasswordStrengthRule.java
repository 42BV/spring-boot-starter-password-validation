package nl._42.password.validation.rule;

import nl._42.password.validation.PasswordProperties;
import nl._42.password.validation.PasswordValidationErrorCodes;
import nl._42.password.validation.PasswordValidationFailedException;
import nl._42.password.validation.ValidationRule;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

@Component
@ConditionalOnProperty("password.strength-enabled")
public class PasswordStrengthRule implements ValidationRule {

    private final PasswordProperties passwordProperties;

    public PasswordStrengthRule(PasswordProperties passwordProperties) {
        this.passwordProperties = passwordProperties;
    }

    @Override
    public void validate(String password, Authentication authentication) {
        if (!password.matches(passwordProperties.getStrengthRegex())) {
            throw new PasswordValidationFailedException(PasswordValidationErrorCodes.NOT_STRONG_ENOUGH);
        }
    }
}
