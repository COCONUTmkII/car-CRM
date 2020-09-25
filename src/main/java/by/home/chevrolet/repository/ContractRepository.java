package by.home.chevrolet.repository;

import by.home.chevrolet.entity.Contract;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.time.LocalDate;

@Repository
public interface ContractRepository extends JpaRepository<Contract, Long> {
    Contract getContractByContractDate(LocalDate date);
}
