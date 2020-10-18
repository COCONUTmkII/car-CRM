package by.home.chevrolet.service;


import org.springframework.security.core.Authentication;

public interface JwtProvider {
    String generateToken(Authentication authentication);
    boolean validateToken(String token);
}
