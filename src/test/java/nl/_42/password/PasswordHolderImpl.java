package nl._42.password;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import nl._42.password.validation.PasswordHolder;

@AllArgsConstructor
@Getter
@NoArgsConstructor
@Setter
public class PasswordHolderImpl implements PasswordHolder {
    private String password;
}
