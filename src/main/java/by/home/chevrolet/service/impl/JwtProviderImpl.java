package by.home.chevrolet.service.impl;

import by.home.chevrolet.exception.ChevroletException;
import by.home.chevrolet.exception.KeyStoreLoadException;
import by.home.chevrolet.model.JwtManager;
import by.home.chevrolet.service.JwtProvider;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.io.InputStream;
import java.security.*;
import java.security.cert.CertificateException;
import java.time.Instant;
import java.util.Date;

import static io.jsonwebtoken.Jwts.parser;

@Service
public class JwtProviderImpl implements JwtProvider {

    private KeyStore keyStore;
    @Value("${jwt.expiration.time}")
    private Long jwtExpirationTimeInMillis;


    @Override
    public String generateToken(Authentication authentication) {
        JwtManager principal = (JwtManager) authentication.getPrincipal();
        return Jwts.builder()
                .setSubject(principal.nickname())
                .signWith(getPrivateKey())
                .setExpiration(Date.from(Instant.now().plusMillis(jwtExpirationTimeInMillis)))
                .compact();
    }

    @Override
    public boolean validateToken(String jwt) {
        parser().setSigningKey(getPublicKey()).parseClaimsJws(jwt);
        return true;
    }

    @Override
    public String generateTokenByNickname(String nickname) {
        return Jwts.builder()
                .setSubject(nickname)
                .setIssuedAt(Date.from(Instant.now()))
                .signWith(getPrivateKey())
                .setExpiration(Date.from(Instant.now().plusMillis(jwtExpirationTimeInMillis)))
                .compact();
    }

    @PostConstruct
    public void init() {
        try {
            keyStore = KeyStore.getInstance("JKS");
            InputStream resourceAsStream = getClass().getResourceAsStream("/chevrolet.jks");
            keyStore.load(resourceAsStream, "secret".toCharArray());
        } catch (KeyStoreException | CertificateException | NoSuchAlgorithmException | IOException exception) {
            throw new KeyStoreLoadException("Exception occurred while loading keystore");
        }
    }

    public String getNicknameFromJwt(String token) {
        Claims claims = parser()
                .setSigningKey(getPublicKey())
                .parseClaimsJws(token)
                .getBody();
        return claims.getSubject();
    }

    private PrivateKey getPrivateKey() {
        try {
            return (PrivateKey) keyStore.getKey("springblog", "secret".toCharArray());
        } catch (KeyStoreException | NoSuchAlgorithmException | UnrecoverableKeyException e) {
            throw new ChevroletException("Exception occurred while retrieving public key from keystore");
        }
    }

    private PublicKey getPublicKey() {
        try {
            return keyStore.getCertificate("springblog").getPublicKey();
        } catch (KeyStoreException e) {
            throw new ChevroletException("exception occurred while retrieving public key from keystore");
        }
    }

    public Long getJwtExpirationTimeInMillis() {
        return jwtExpirationTimeInMillis;
    }

}
