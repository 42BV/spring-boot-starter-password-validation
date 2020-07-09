package nl._42.password.validation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class PasswordValidatorAutoConfiguration {

    @Autowired(required = false)
    private List<ValidationRule> rules = new ArrayList<>();

    @Bean
    public PasswordValidator passwordValidator() {
        return new PasswordValidator(rules);
    }

}
