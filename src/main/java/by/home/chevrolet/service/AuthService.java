package by.home.chevrolet.service;

import by.home.chevrolet.entity.FullName;
import by.home.chevrolet.entity.Manager;
import by.home.chevrolet.entity.VerificationToken;

public interface AuthService {
    void signUp(Manager manager, FullName fullName);
    void verifyAccount(String token);
    void fetchUserAndEnable(VerificationToken token);
}
