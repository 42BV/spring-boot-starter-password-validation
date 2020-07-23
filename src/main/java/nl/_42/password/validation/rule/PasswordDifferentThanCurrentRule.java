package nl._42.password.validation.rule;

import lombok.extern.slf4j.Slf4j;
import nl._42.password.validation.PasswordHolder;
import nl._42.password.validation.PasswordValidationErrorCodes;
import nl._42.password.validation.PasswordValidationFailedException;
import nl._42.password.validation.ValidationRule;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@ConditionalOnProperty("password.different-than-current-enabled")
public class PasswordDifferentThanCurrentRule implements ValidationRule {

    private final PasswordEncoder passwordEncoder;

    public PasswordDifferentThanCurrentRule(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void validate(String password, PasswordHolder passwordHolder) {

        if (passwordEncoder.matches(password, passwordHolder.getPassword())) {
            throw new PasswordValidationFailedException(PasswordValidationErrorCodes.MATCHES_CURRENT);
        }
    }
}
