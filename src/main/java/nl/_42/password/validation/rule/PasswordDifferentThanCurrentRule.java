package nl._42.password.validation.rule;

import java.util.Optional;

import lombok.extern.slf4j.Slf4j;
import nl._42.password.validation.CredentialRetriever;
import nl._42.password.validation.PasswordValidationErrorCodes;
import nl._42.password.validation.PasswordValidationFailedException;
import nl._42.password.validation.ValidationRule;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@ConditionalOnProperty("password.different-than-current-enabled")
public class PasswordDifferentThanCurrentRule implements ValidationRule {

    private final PasswordEncoder passwordEncoder;
    private final CredentialRetriever credentialRetriever;

    public PasswordDifferentThanCurrentRule(PasswordEncoder passwordEncoder, CredentialRetriever credentialRetriever) {
        this.passwordEncoder = passwordEncoder;
        this.credentialRetriever = credentialRetriever;
    }

    @Override
    public void validate(String password, Authentication authentication) {
        Optional<String> credentials = credentialRetriever.getCredentials(authentication);
        if (credentials.isEmpty()) {
            log.warn("Credentials could not be obtained. PasswordDifferentThanCurrentRule is skipped.");
            return;
        }

        if (passwordEncoder.matches(password, credentials.get())) {
            throw new PasswordValidationFailedException(PasswordValidationErrorCodes.MATCHES_CURRENT);
        }
    }
}
