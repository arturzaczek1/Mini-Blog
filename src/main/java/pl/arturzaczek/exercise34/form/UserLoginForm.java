package pl.arturzaczek.exercise34.form;


import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Setter
@Getter
public class UserLoginForm {
    @NotBlank (message = "field can not be empty ")
    private String email;
    @NotBlank (message = "field can not be empty")
    private String password;
}
