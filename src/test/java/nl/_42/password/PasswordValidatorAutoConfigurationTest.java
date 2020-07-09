package nl._42.password;

import nl._42.password.validation.PasswordValidator;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class PasswordValidatorAutoConfigurationTest {

    @Autowired
    private PasswordValidator validator;

    @Test
    public void configure_shouldSucceed() {
        Assert.assertNull(validator);
    }

}
