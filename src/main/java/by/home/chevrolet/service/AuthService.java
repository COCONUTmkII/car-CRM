package by.home.chevrolet.service;

import by.home.chevrolet.entity.FullName;
import by.home.chevrolet.entity.Manager;

public interface AuthService {
    void signUp(Manager manager, FullName fullName);
}
