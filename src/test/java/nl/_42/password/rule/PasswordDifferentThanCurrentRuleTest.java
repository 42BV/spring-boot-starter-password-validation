package nl._42.password.rule;

import static org.junit.jupiter.api.Assertions.assertThrows;

import nl._42.password.validation.PasswordValidationFailedException;
import nl._42.password.validation.rule.PasswordDifferentThanCurrentRule;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

class PasswordDifferentThanCurrentRuleTest {

    private static final String password = "Password01!";
    private PasswordEncoder passwordEncoder;
    private Authentication authenticationToken;

    @BeforeEach
    void setUp() {
        passwordEncoder = new BCryptPasswordEncoder();
        authenticationToken = new UsernamePasswordAuthenticationToken(1, passwordEncoder.encode(password), null);
    }

    @Test
    void validate_shouldSucceed() {
        new PasswordDifferentThanCurrentRule(passwordEncoder).validate("NewPassword02@", authenticationToken);
    }

    @Test
    void validate_shouldThrow_onMatchingPasswords() {
        PasswordDifferentThanCurrentRule rule = new PasswordDifferentThanCurrentRule(passwordEncoder);
        assertThrows(PasswordValidationFailedException.class, () -> rule.validate(password, authenticationToken));
    }
}
