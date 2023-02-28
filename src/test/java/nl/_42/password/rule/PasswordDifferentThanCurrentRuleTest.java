package nl._42.password.rule;

import nl._42.password.PasswordHolderImpl;
import nl._42.password.validation.PasswordHolder;
import nl._42.password.validation.PasswordValidationFailedException;
import nl._42.password.validation.rule.PasswordDifferentThanCurrentRule;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import static org.junit.jupiter.api.Assertions.assertThrows;

class PasswordDifferentThanCurrentRuleTest {

    private static final String password = "Password01!";
    private PasswordEncoder passwordEncoder;
    private PasswordHolder passwordHolder;

    @BeforeEach
    void setUp() {
        passwordEncoder = new BCryptPasswordEncoder();
        passwordHolder = new PasswordHolderImpl(passwordEncoder.encode(password));
    }

    @Test
    void validate_shouldSucceed() {
        new PasswordDifferentThanCurrentRule(passwordEncoder).validate("NewPassword02@", passwordHolder);
    }

    @Test
    void validate_shouldThrow_onMatchingPasswords() {
        PasswordDifferentThanCurrentRule rule = new PasswordDifferentThanCurrentRule(passwordEncoder);
        assertThrows(PasswordValidationFailedException.class, () -> rule.validate(password, passwordHolder));
    }

}
