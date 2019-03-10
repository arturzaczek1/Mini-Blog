package pl.arturzaczek.exercise34.form;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Setter
@Getter
public class PostNewForm {

    @NotBlank
    @Size(min = 5, max = 200, message = "post title can not be empty")
    String title;
    @NotBlank
    @Size(min = 5, max = 5000, message = "post postBody has to contain at least 5 characters maximum 5000")
    String content;
}
