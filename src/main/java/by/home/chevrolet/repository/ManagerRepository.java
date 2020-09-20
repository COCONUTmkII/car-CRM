package by.home.chevrolet.repository;

import by.home.chevrolet.entity.FullName;
import by.home.chevrolet.entity.Manager;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ManagerRepository extends JpaRepository<Manager, Long> {
    Manager findManagerByFullName(FullName fullName);
}
