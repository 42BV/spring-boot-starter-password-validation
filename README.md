# Spring Boot Starter Password Validation

TODO

Configuration:

```yaml
password:
  different-than-current-enabled
  minimum-length-enabled
  not-used-in-past-enabled
  strength-enabled
  minimum-length
  strength-regex
```

### password.different-than-current-enabled
Default: `false`  
Enables the validation where the password is not allowed to be the password the user is currently using.

### password.minimum-length-enabled
Default: `false`  
Enables the minimum length check. See also property: password.minimum-length.

### password.not-used-in-past-enabled
Default: `false`  
Enables the validation where the password is not allowed to have been used in the past by the same user.  
Requires you to provide a bean of `OldPasswordRepository` as a means to retrieve the old passwords.

### password.strength-enabled
Default: `false`  
Enables the strength check. Meaning the password must be valida according to a specific regex expression. See also property: password.strength-regex.

### password.minimum-length
Default: `8`  
Only used when password.minimum-length-enabled is turned on. Defines the minimum length of passwords; shorter passwords will be denied.


### password.strength-regex
Default: `^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=.,?!])(?=\S+$).*$`  
Only used when password.strength-enabled is turned on. Defines the regex for the strength check. The default checks for at least one capital letter, one lower case letter, one number and one special character.