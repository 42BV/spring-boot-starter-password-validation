package nl._42.password.validation;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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

}
