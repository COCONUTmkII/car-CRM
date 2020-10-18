package by.home.chevrolet.service;

import by.home.chevrolet.entity.FullName;
import by.home.chevrolet.entity.Manager;
import by.home.chevrolet.entity.VerificationToken;
import by.home.chevrolet.model.AuthenticationResponse;
import by.home.chevrolet.model.LoginRequest;

public interface AuthService {
    void signUp(Manager manager, FullName fullName);
    void verifyAccount(String token);
    void fetchUserAndEnable(VerificationToken token);
    AuthenticationResponse login(LoginRequest loginRequest);
}
