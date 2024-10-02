package br.com.fiap.irrigationapi.modules.users.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record UserRegisterInput(
        Long id,

        @NotBlank(message = "User name is required!")
        String name,

        @NotBlank(message = "Email is required!")
        @Email(message = "Invalid email address!")
        String email,

        @NotBlank(message = "Password is required!")
        @Size(min = 6, max = 20, message = "Password must be between 6 -20  characters")
        String password
) {
}