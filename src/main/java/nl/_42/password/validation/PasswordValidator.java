package nl._42.password.validation;

import java.util.List;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class PasswordValidator {

    private final List<ValidationRule> rules;

    public void validate(String password, PasswordHolder passwordHolder) {
        rules.forEach(rule -> rule.validate(password, passwordHolder));
    }

}
