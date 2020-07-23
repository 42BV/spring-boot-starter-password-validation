package nl._42.password.validation.rule;

import nl._42.password.validation.OldPasswordRepository;
import nl._42.password.validation.PasswordHolder;
import nl._42.password.validation.PasswordValidationErrorCodes;
import nl._42.password.validation.PasswordValidationFailedException;
import nl._42.password.validation.ValidationRule;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@ConditionalOnProperty("password.not-used-in-past-enabled")
public class PasswordNotUsedInPastRule implements ValidationRule {

    private final PasswordEncoder passwordEncoder;
    private final OldPasswordRepository oldPasswordRepository;

    public PasswordNotUsedInPastRule(PasswordEncoder passwordEncoder, OldPasswordRepository oldPasswordRepository) {
        this.passwordEncoder = passwordEncoder;
        this.oldPasswordRepository = oldPasswordRepository;
    }

    @Override
    public void validate(String password, PasswordHolder passwordHolder) {
        if (oldPasswordRepository.getOldPasswords(passwordHolder)
                .stream()
                .anyMatch(oldPassword -> passwordEncoder.matches(password, oldPassword))) {
            throw new PasswordValidationFailedException(PasswordValidationErrorCodes.USED_IN_PAST);
        }

    }
}
