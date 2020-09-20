package by.home.chevrolet.service;

import by.home.chevrolet.entity.Contract;

import java.time.LocalDate;
import java.util.List;

public interface ContractService {
    Contract addContract(Contract contract);
    void delete(Long id);
    Contract getByContractDate(LocalDate name);
    Contract editContract(Contract contract);
    List<Contract> getAll();
}
