package br.com.fiap.irrigationapi.controller;

import br.com.fiap.irrigationapi.config.secutity.TokenService;
import br.com.fiap.irrigationapi.dto.LoginInput;
import br.com.fiap.irrigationapi.dto.LoginOutput;
import br.com.fiap.irrigationapi.model.User;
import br.com.fiap.irrigationapi.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService service;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenService tokenService;

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody @Valid LoginInput loginInput) {

        var usernamePassword = new UsernamePasswordAuthenticationToken(
                loginInput.email(),
                loginInput.password()
        );

        var auth = authenticationManager.authenticate(usernamePassword);
        var user = (User)auth.getPrincipal();

        if (!user.getActive())
            return ResponseEntity.ok("Unauthorized");

        var token = tokenService.createToken(user);
        return ResponseEntity.ok(new LoginOutput(token));
    }

}
