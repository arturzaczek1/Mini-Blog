package pl.arturzaczek.exercise34.form;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Setter
@Getter
@ToString(exclude = "password")
public class UserRegisterForm {
    @NotBlank (message = "example: exmplemail@gmail.com")
    @Email (message = "example: exmplemail@gmail.com")
    private String email;
    @NotBlank(message = "field can not be empty")
    private String firstName;
    @NotBlank (message = "field can not be empty")
    private String lastName;
    @Pattern(regexp = "^.{4,8}$", message = "password should contain at least 4 characters, maximum 8")
    private String password;
}
