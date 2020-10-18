package by.home.chevrolet.service.impl;

import by.home.chevrolet.entity.FullName;
import by.home.chevrolet.entity.Manager;
import by.home.chevrolet.entity.VerificationToken;
import by.home.chevrolet.exception.InvalidVerificationToken;
import by.home.chevrolet.exception.ManagerNotFoundException;
import by.home.chevrolet.model.AuthenticationResponse;
import by.home.chevrolet.model.LoginRequest;
import by.home.chevrolet.model.NotificationEmail;
import by.home.chevrolet.repository.ManagerRepository;
import by.home.chevrolet.repository.VerificationTokenRepository;
import by.home.chevrolet.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.Optional;
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
    @Autowired
    AuthenticationManager authenticationManager;
    @Autowired
    JwtProviderImpl jwtProvider;

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
                       http://localhost:8080/auth/accountVerification/""" + token
                ));
    }

    @Override
    public void verifyAccount(String token) {
        Optional<VerificationToken> verificationToken = verificationTokenRepository.findByToken(token);
        verificationToken.orElseThrow(() -> new InvalidVerificationToken("Verification token is invalid"));
        fetchUserAndEnable(verificationToken.get());
    }

    @Transactional
    @Override
    public void fetchUserAndEnable(VerificationToken verificationToken) {
        String managerNickname = verificationToken.getManager().getNickname();
        Manager manager = managerRepository.findByNickname(managerNickname)
                .orElseThrow(() -> new ManagerNotFoundException("Manager is not found with name" + managerNickname));
        manager.setEnabled(true);
        manager.setVerificationToken(verificationToken);
        managerRepository.saveAndFlush(manager);
    }

    @Override
    public AuthenticationResponse login(LoginRequest loginRequest) {
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getNickname(),
                loginRequest.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String token = jwtProvider.generateToken(authentication);
        return new AuthenticationResponse(token, loginRequest.getNickname());
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
