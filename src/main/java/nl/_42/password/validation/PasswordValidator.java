package nl._42.password.validation;

import lombok.AllArgsConstructor;
import org.springframework.security.core.Authentication;

import java.util.List;

@AllArgsConstructor
public class PasswordValidator {

    private final List<ValidationRule> rules;

    public void validate(String password, Authentication authentication) {
        rules.forEach(rule -> rule.validate(password, authentication));
    }

}
