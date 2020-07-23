package nl._42.password.validation;

public interface ValidationRule {

    void validate(String password, PasswordHolder passwordHolder);

}
