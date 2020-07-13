package nl._42.password.validation;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
public class PasswordValidatorAutoConfiguration {

    @Autowired(required = false)
    private List<ValidationRule> rules = new ArrayList<>();

    @Bean
    public PasswordValidator passwordValidator() {
        return new PasswordValidator(rules);
    }

    @Bean
    @ConditionalOnMissingBean
    public CredentialRetriever credentialRetriever() {
        return authentication -> Optional.ofNullable(authentication.getCredentials()).map(Object::toString);
    }

}
