package by.home.chevrolet.service.impl;

import by.home.chevrolet.entity.Contract;
import by.home.chevrolet.repository.ContractRepository;
import by.home.chevrolet.service.ContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class ContractServiceImpl implements ContractService {

    @Autowired
    ContractRepository contractRepository;

    @Override
    public Contract addContract(Contract contract) {
        return contractRepository.saveAndFlush(contract);
    }

    @Override
    public void delete(Long id) {
        contractRepository.deleteById(id);
    }

    @Override
    public Contract getByContractDate(LocalDate date) {
        return contractRepository.getContractByContractDate(date);
    }

    @Override
    public Contract editContract(Contract contract) {
        return contractRepository.saveAndFlush(contract);
    }

    @Override
    public List<Contract> getAll() {
        return contractRepository.findAll();
    }
}
