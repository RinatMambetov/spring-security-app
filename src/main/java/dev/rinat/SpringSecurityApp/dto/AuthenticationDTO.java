package dev.rinat.SpringSecurityApp.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AuthenticationDTO {

    @NotEmpty(message = "Username cannot be empty")
    @Size(min = 2, max = 100, message = "Username must be between 2 and 100 characters")
    private String username;

    private String password;

}
