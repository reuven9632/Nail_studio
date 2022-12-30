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

    public int setConfirmedToken(String token){
        return tokenRepository.updateConfirmedAt(token, LocalDateTime.now());
    }
}
