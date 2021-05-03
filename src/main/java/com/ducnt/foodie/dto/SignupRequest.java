package com.ducnt.foodie.dto;

import lombok.*;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Set;

@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class SignupRequest {

    @Email(message = "Invalid email")
    private String email;

    @NotBlank(message = "Password can't be blank")
    @Size(min = 6, message = "Password min length is 6")
    private String password;

    @NotBlank(message = "First name can't be blank")
    private String firstName;

    @NotBlank(message = "Last name can't be blank")
    private String lastName;

    private Set<String> roles;

}
