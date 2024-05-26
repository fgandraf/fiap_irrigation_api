package br.com.fiap.irrigationapi.modules.users.repositories;

import br.com.fiap.irrigationapi.modules.users.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    UserDetails findByEmail(String email);

    Optional<User> findById(Long id);

}
