package nl._42.password.rule;

import static org.junit.jupiter.api.Assertions.assertThrows;

import nl._42.password.validation.rule.PasswordLengthRule;
import nl._42.password.validation.PasswordProperties;
import nl._42.password.validation.PasswordValidationFailedException;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class PasswordLengthRuleTest {

    private static PasswordProperties passwordProperties;

    @BeforeAll
    static void setUp() {
        passwordProperties = new PasswordProperties();
        passwordProperties.setMinimumLength(10);
    }

    @Test
    void validate_shouldSucceed_onEqualLength() {
        new PasswordLengthRule(passwordProperties).validate("0123456789", null);
    }

    @Test
    void validate_shouldSucceed_onGreaterLength() {
        new PasswordLengthRule(passwordProperties).validate("01234567890123456789", null);
    }

    @Test
    void validate_shouldThrow_onSmallerLength() {
        PasswordLengthRule passwordLengthRule = new PasswordLengthRule(passwordProperties);
        assertThrows(PasswordValidationFailedException.class, () -> passwordLengthRule.validate("012345678", null));
    }

}
