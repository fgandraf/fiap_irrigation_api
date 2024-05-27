package br.com.fiap.irrigationapi.modules.users.services;

import br.com.fiap.irrigationapi.exceptions.NotFoundException;
import br.com.fiap.irrigationapi.modules.users.dtos.UserOutput;
import br.com.fiap.irrigationapi.modules.users.dtos.UserRegisterInput;
import br.com.fiap.irrigationapi.modules.users.models.User;
import br.com.fiap.irrigationapi.modules.users.models.UserRole;
import br.com.fiap.irrigationapi.modules.users.repositories.UserRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private UserRepository repository;

    public UserOutput save(UserRegisterInput registerInput) {
        var user = new User();
        BeanUtils.copyProperties(registerInput, user);
        user.setActive(false);
        user.setRole(UserRole.USER);
        user.setPassword(new BCryptPasswordEncoder().encode(registerInput.password()));

        return new UserOutput(repository.save(user));
    }

    public UserOutput update(User user) {
        var passwd = user.getPassword();
        user.setPassword(new BCryptPasswordEncoder().encode(passwd));
        return new UserOutput(repository.save(user));
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return repository.findByEmail(username);
    }

    public User activate(Long id) {
        Optional<User> user = repository.findById(id);
        if (user.isPresent()) {
            user.get().setActive(true);
            return repository.save(user.get());
        } else {
            throw new NotFoundException("User", id);
        }
    }

    public User deactivate(Long id) {
        Optional<User> user = repository.findById(id);
        if (user.isPresent()) {
            user.get().setActive(false);
            return repository.save(user.get());
        } else {
            throw new NotFoundException("User", id);
        }
    }

    public User findById(Long id) {
        Optional<User> user = repository.findById(id);
        if (user.isPresent()) {
            return user.get();
        } else {
            throw new NotFoundException("User", id);
        }
    }

    public User findByEmail(String email) {
        var userDetail = repository.findByEmail(email);
        if (userDetail != null) {
            var user = new User();
            BeanUtils.copyProperties(userDetail, user);
            return user;
        } else {
            throw new NotFoundException("User", email);
        }
    }

    public User upgradePermission(Long id) {
        Optional<User> user = repository.findById(id);
        if (user.isPresent()) {
            user.get().setRole(UserRole.ADMIN);
            return repository.save(user.get());
        } else {
            throw new NotFoundException("User", id);
        }
    }

    public User downgradePermission(Long id) {
        Optional<User> user = repository.findById(id);
        if (user.isPresent()) {
            user.get().setRole(UserRole.USER);
            return repository.save(user.get());
        } else {
            throw new NotFoundException("User", id);
        }
    }

    public Page<UserOutput> getAll(Pageable page) {

        return repository
                .findAll(page)
                .map(UserOutput::new);
    }

}
