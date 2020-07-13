package nl._42.password.validation;

import java.util.Optional;

import org.springframework.security.core.Authentication;

public interface CredentialRetriever {
    Optional<String> getCredentials(Authentication authentication);
}
