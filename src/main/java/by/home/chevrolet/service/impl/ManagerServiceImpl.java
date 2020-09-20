package by.home.chevrolet.service.impl;

import by.home.chevrolet.entity.FullName;
import by.home.chevrolet.entity.Manager;
import by.home.chevrolet.repository.ManagerRepository;
import by.home.chevrolet.service.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ManagerServiceImpl implements ManagerService {

    @Autowired
    ManagerRepository managerRepository;

    @Override
    public Manager addManager(Manager manager) {
        return managerRepository.saveAndFlush(manager);
    }

    @Override
    public void delete(Long id) {
        managerRepository.deleteById(id);
    }

    @Override
    public Manager getByName(FullName name) {
        return managerRepository.findManagerByFullName(name);
    }

    @Override
    public Manager editCar(Manager manager) {
        return null;
    }

    @Override
    public List<Manager> getAll() {
        return null;
    }
}
