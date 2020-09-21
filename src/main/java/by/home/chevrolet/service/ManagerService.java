package by.home.chevrolet.service;

import by.home.chevrolet.entity.FullName;
import by.home.chevrolet.entity.Manager;
import java.util.List;

public interface ManagerService {
    Manager addManager(Manager manager);
    void delete(Long id);
    Manager getByName(FullName name);
    Manager editManager(Manager manager);
    List<Manager> getAll();
}
