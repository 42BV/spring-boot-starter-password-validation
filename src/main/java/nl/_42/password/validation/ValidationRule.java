package nl._42.password.validation;

import org.springframework.security.core.Authentication;

public interface ValidationRule {

    void validate(String password, Authentication authentication);

}
