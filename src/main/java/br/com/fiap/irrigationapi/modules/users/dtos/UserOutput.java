package br.com.fiap.irrigationapi.modules.users.dtos;

import br.com.fiap.irrigationapi.modules.users.User;
import br.com.fiap.irrigationapi.modules.users.enums.UserRole;

public record UserOutput(
        Long id,
        String name,
        String email,
        UserRole role
) {
    public UserOutput(User user) {
        this(
                user.getId(),
                user.getName(),
                user.getEmail(),
                user.getRole()
        );
    }
}