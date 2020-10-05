package by.home.chevrolet.controller;

import by.home.chevrolet.entity.FullName;
import by.home.chevrolet.entity.Manager;
import by.home.chevrolet.service.impl.AuthServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthorizationController {

    @Autowired
    AuthServiceImpl authService;

    @GetMapping("/login")
    public String openIndexPage() {
        return "login";
    }

    @GetMapping("/registration")
    public String openRegistrationPage() {
        return "registration";
    }

    @GetMapping("/")
    public String openMainPage() {
        return "main";
    }

    @PostMapping("/signup")
    public ResponseEntity<String> signup(@RequestBody Manager manager, FullName fullName) {
        authService.signUp(manager, fullName);
        return new ResponseEntity<>("Manager Registration Successful", HttpStatus.OK);
    }
}