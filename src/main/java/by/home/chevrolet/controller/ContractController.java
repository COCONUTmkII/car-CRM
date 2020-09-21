package by.home.chevrolet.controller;

import by.home.chevrolet.entity.Contract;
import by.home.chevrolet.service.impl.ContractServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDate;
import java.util.List;

@RestController
public class ContractController {

    @Autowired
    ContractServiceImpl contractService;

    @GetMapping("/contract")
    public ResponseEntity<List<Contract>> getAllContract() {
        return new ResponseEntity<>(contractService.getAll(), HttpStatus.OK);
    }

    @PostMapping("/contract")
    public ResponseEntity<Contract> addContract(@RequestBody Contract contract) {
        return new ResponseEntity<>(contractService.addContract(contract), HttpStatus.OK);
    }

    @DeleteMapping("/contract{id}")
    public void delete(Long id) {
        contractService.delete(id);
    }

    @PutMapping("/contract")
    public ResponseEntity<Contract> editContract(@RequestBody Contract contract) {
        return new ResponseEntity<>(contractService.editContract(contract), HttpStatus.OK);
    }

    @GetMapping("/contract")
    public ResponseEntity<Contract> getContractByDate(@RequestBody LocalDate date) {
        return new ResponseEntity<>(contractService.getByContractDate(date), HttpStatus.OK);
    }


}
