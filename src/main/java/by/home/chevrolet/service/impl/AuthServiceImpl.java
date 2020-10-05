package by.home.chevrolet.service.impl;

import by.home.chevrolet.entity.FullName;
import by.home.chevrolet.entity.Manager;
import by.home.chevrolet.entity.VerificationToken;
import by.home.chevrolet.model.NotificationEmail;
import by.home.chevrolet.repository.ManagerRepository;
import by.home.chevrolet.repository.VerificationTokenRepository;
import by.home.chevrolet.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
public class AuthServiceImpl implements AuthService {

    @Autowired
    PasswordEncoder passwordEncoder;
    @Autowired
    ManagerRepository managerRepository;
    @Autowired
    VerificationTokenRepository verificationTokenRepository;
    @Autowired
    EmailServiceImpl emailService;

    @Transactional
    @Override
    public void signUp(Manager manager, FullName fullName) {
        manager.setFullName(fullName);
        manager.setPassword(passwordEncoder.encode(manager.getPassword()));
        manager.setEnabled(false);
        managerRepository.saveAndFlush(manager);
        String token = generateVerificationToken(manager);
        emailService.sendMail(new NotificationEmail("Please, activate your CRM account",
                manager.getEmail(),
                """
                       Thank you for signing up! Please click to the link below to activate your account
                       http://localhost:8080/api/auth/accountVerification
                       """ + token
                ));
    }

    public String generateVerificationToken(Manager manager) {
        String token = UUID.randomUUID().toString();
        VerificationToken verificationToken = new VerificationToken();
        verificationToken.setToken(token);
        verificationToken.setManager(manager);
        verificationTokenRepository.saveAndFlush(verificationToken);
        return token;
    }
}
