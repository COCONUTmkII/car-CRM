package by.home.chevrolet.service;

import by.home.chevrolet.entity.RefreshToken;

public interface RefreshTokenService {
    RefreshToken generateRefreshToken();
    void validateRefreshToken(String token);
    void deleteRefreshToken(String token);
}
