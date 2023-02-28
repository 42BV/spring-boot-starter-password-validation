package nl._42.password;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import nl._42.password.validation.PasswordHolder;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PasswordHolderImpl implements PasswordHolder {
    private String password;

}
