package by.home.chevrolet.repository;

import by.home.chevrolet.entity.ClientType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientTypeRepository extends JpaRepository<ClientType, Long> {
    ClientType getClientTypeByClientDescription(String description);
}
