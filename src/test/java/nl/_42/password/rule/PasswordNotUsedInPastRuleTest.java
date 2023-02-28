package nl._42.password.rule;

import nl._42.password.validation.PasswordValidationFailedException;
import nl._42.password.validation.rule.PasswordNotUsedInPastRule;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Collections;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertThrows;

class PasswordNotUsedInPastRuleTest {

    private PasswordEncoder passwordEncoder;

    @BeforeEach
    void setUp() {
        passwordEncoder = new BCryptPasswordEncoder();
    }

    @Test
    void validate_shouldSucceed_whenNoMatchingOldPasswords() {
        Set<String> oldPasswords = Set.of(passwordEncoder.encode("NotIt"), passwordEncoder.encode("AlsoNotIt"));
        new PasswordNotUsedInPastRule(passwordEncoder, authentication -> oldPasswords)
                .validate("NewPassword", null);
    }

    @Test
    void validate_shouldSucceed_whenNoOldPasswords() {
        Set<String> oldPasswords = Collections.emptySet();
        new PasswordNotUsedInPastRule(passwordEncoder, authentication -> oldPasswords)
                .validate("NewPassword", null);
    }

    @Test
    void validate_shouldThrow_whenMatchingOldPassword() {
        Set<String> oldPasswords = Set.of(passwordEncoder.encode("NotIt"), passwordEncoder.encode("Password"));
        PasswordNotUsedInPastRule rule = new PasswordNotUsedInPastRule(passwordEncoder, authentication -> oldPasswords);

        assertThrows(PasswordValidationFailedException.class, () -> rule.validate("Password", null));
    }

}
