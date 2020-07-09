package nl._42.password.validation.rule;

import nl._42.password.validation.PasswordValidationErrorCodes;
import nl._42.password.validation.PasswordValidationFailedException;
import nl._42.password.validation.ValidationRule;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@ConditionalOnProperty("password.different-than-current-enabled")
public class PasswordDifferentThanCurrentRule implements ValidationRule {

    private final PasswordEncoder passwordEncoder;

    public PasswordDifferentThanCurrentRule(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void validate(String password, Authentication authentication) {
        if (passwordEncoder.matches(password, authentication.getCredentials().toString())) {
            throw new PasswordValidationFailedException(PasswordValidationErrorCodes.MATCHES_CURRENT);
        }
    }
}
