package br.com.fiap.irrigationapi.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record LoginInput(

        @NotBlank(message = "User name is required!")
        @Email(message = "Invalid email address!")
        String email,

        @NotBlank(message = "Password is required!")
        @Size(min = 6, max = 20, message = "Password must be between 6 -20  characters")
        String password
) {
}
