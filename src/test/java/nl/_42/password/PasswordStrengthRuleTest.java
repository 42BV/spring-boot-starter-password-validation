package nl._42.password;

import static org.junit.jupiter.api.Assertions.assertThrows;

import nl._42.password.validation.PasswordStrengthRule;
import nl._42.password.validation.PasswordValidationFailedException;

import org.junit.jupiter.api.Test;

class PasswordStrengthRuleTest {

    @Test
    void validate_shouldSucceed_withStrongPassword() {
        new PasswordStrengthRule().validate("1aA#", null);
    }

    @Test
    void validate_shouldThrow_whenMissingCapitalLetter() {
        PasswordStrengthRule passwordStrengthRule = new PasswordStrengthRule();
        assertThrows(PasswordValidationFailedException.class, () -> passwordStrengthRule.validate("1a#", null));
    }

    @Test
    void validate_shouldThrow_whenMissingLowerCaseLetter() {
        PasswordStrengthRule passwordStrengthRule = new PasswordStrengthRule();
        assertThrows(PasswordValidationFailedException.class, () -> passwordStrengthRule.validate("1A#", null));
    }

    @Test
    void validate_shouldThrow_whenMissingNumber() {
        PasswordStrengthRule passwordStrengthRule = new PasswordStrengthRule();
        assertThrows(PasswordValidationFailedException.class, () -> passwordStrengthRule.validate("aA#", null));
    }

    @Test
    void validate_shouldThrow_whenMissingSpecialCharacter() {
        PasswordStrengthRule passwordStrengthRule = new PasswordStrengthRule();
        assertThrows(PasswordValidationFailedException.class, () -> passwordStrengthRule.validate("1aA", null));

    }
}
