package br.com.fiap.irrigationapi.config.secutity;

import br.com.fiap.irrigationapi.model.User;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Service
public class TokenService {

    @Value("${jwtprivatekey}")
    private String privateKey;


    public String createToken(User user) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(privateKey);
            return JWT
                    .create()
                    .withIssuer("irrigationapi")
                    .withSubject(user.getEmail())
                    .withExpiresAt(
                            LocalDateTime.now().plusHours(2).toInstant(ZoneOffset.of("-03:00"))
                    )
                    .sign(algorithm);
        } catch (JWTCreationException error){
            throw new RuntimeException(error);
        }
    }

    public String validateToken(String token) {
        try{
            Algorithm algorithm = Algorithm.HMAC256(privateKey);
            return JWT.require(algorithm)
                    .withIssuer("irrigationapi")
                    .build()
                    .verify(token)
                    .getSubject();

        } catch (JWTVerificationException error){
            return "";
        }
    }

}
