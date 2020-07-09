package nl._42.password.validation.rule;

import nl._42.password.validation.PasswordProperties;
import nl._42.password.validation.PasswordValidationErrorCodes;
import nl._42.password.validation.PasswordValidationFailedException;
import nl._42.password.validation.ValidationRule;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

@Component
@ConditionalOnProperty("password.minimum-length-enabled")
public class PasswordLengthRule implements ValidationRule {

    private final PasswordProperties passwordProperties;

    public PasswordLengthRule(PasswordProperties passwordProperties) {
        this.passwordProperties = passwordProperties;
    }

    @Override
    public void validate(String password, Authentication authentication) {
        if (!password.matches("^.{" + passwordProperties.getMinimumLength() + ",100}$")) {
            throw new PasswordValidationFailedException(PasswordValidationErrorCodes.NOT_LONG_ENOUGH);
        }
    }
}
