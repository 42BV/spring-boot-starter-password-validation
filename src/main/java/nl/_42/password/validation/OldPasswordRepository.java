package nl._42.password.validation;

import java.util.Set;

public interface OldPasswordRepository {
    Set<String> getOldPasswords(PasswordHolder passwordHolder);
}
