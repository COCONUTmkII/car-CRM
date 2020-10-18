package by.home.chevrolet.model;

import java.time.Instant;

public record AuthenticationResponse(String authenticationToken, String nickname,
                                     String refreshToken, Instant expiresAt) {
    public String getAuthenticationToken() {
        return authenticationToken;
    }
    public String getNickname() {
        return nickname;
    }
    public String getRefreshToken() {return refreshToken;}
    public Instant getExpiresAt() { return expiresAt;}
}
