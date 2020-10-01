package by.home.chevrolet.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AuthorizationController {

    @GetMapping("/login")
    public String openIndexPage() {
        return "login";
    }

    @GetMapping("/registration")
    public String openRegistrationPage() {
        return "registration";
    }
}
