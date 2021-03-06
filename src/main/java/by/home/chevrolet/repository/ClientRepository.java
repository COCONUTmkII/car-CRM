package by.home.chevrolet.repository;

import by.home.chevrolet.entity.Client;
import by.home.chevrolet.entity.FullName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {
    Client getClientByFullName(FullName fullName);
}
