# Spring Boot Starter Password Validation

This library makes validating new passwords easy.  

Steps necessary to make this library work in your application:
- Configure the validations you want. See the available configurations below.
- Make your user (or equivalent) class implement the interface `PasswordHolder`. This provides the validators a way to retrieve the current (encoded) password. This is required for certain validators.
- Autowire the `PasswordValidator` bean in your application. Use the `PasswordValidator.validate(newPassword, passwordHolder)` method to validate new passwords. An exception of type `PasswordValidationFailedException` is thrown when a validation fails. No exception? Your new password is valid for use.
- If desired: you can add new validation rules by implementing the `ValidationRule` interface.

# Configuration:

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
Type: `boolean`  
Enables the validation where the password is not allowed to be the password the user is currently using.

### password.minimum-length-enabled
Default: `false`  
Type: `boolean`  
Enables the minimum length check. See also property: password.minimum-length.

### password.not-used-in-past-enabled
Default: `false`  
Type: `boolean`  
Enables the validation where the password is not allowed to have been used in the past by the same user.  
Requires you to provide a bean of `OldPasswordRepository` as a means to retrieve the old passwords.

### password.strength-enabled
Default: `false`  
Type: `boolean`  
Enables the strength check. Meaning the password must be valid according to a specific regex expression. See also property: password.strength-regex.

### password.minimum-length
Default: `8`  
Type: `int`  
Only used when password.minimum-length-enabled is turned on. Defines the minimum length of passwords; shorter passwords will be denied.


### password.strength-regex
Default: `^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=.,?!])(?=\S+$).*$`  
Type: `String`  
Only used when password.strength-enabled is turned on. Defines the regex for the strength check. The default checks for at least one capital letter, one lower case letter, one number and one special character.