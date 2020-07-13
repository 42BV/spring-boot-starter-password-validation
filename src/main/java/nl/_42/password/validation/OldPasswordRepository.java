package nl._42.password.validation;

import java.util.Set;

import org.springframework.security.core.Authentication;

public interface OldPasswordRepository {
    Set<String> getOldPasswords(Authentication authentication);
}
