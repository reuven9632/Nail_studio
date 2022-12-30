<<<<<<< HEAD
package com.example.Nail_studio.token;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@AllArgsConstructor
@Service
public class TokenService {

    private final TokenRepository tokenRepository;

    public void saveToken(Token token){
        tokenRepository.save(token);
    }

    public Optional<Token> getToken(String token){
        return tokenRepository.findByToken(token);
    }

    public int updateConfirmedToken(String token){
        return tokenRepository.setConfirmedAt(token, LocalDateTime.now());
    }
=======
package com.example.Nail_studio.token;public class TokenService {
>>>>>>> f68fbc5 (create token -> ..., changes on registration and specialist)
}
