package nl._42.password.validation;

import lombok.Getter;
import lombok.Setter;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "password")
@Getter
@Setter
public class PasswordProperties {
    /**
     * Only used when minimumLengthEnabled = true.
     */
    private int minimumLength = 8;
}
