package by.home.chevrolet.controller;

import by.home.chevrolet.entity.FullName;
import by.home.chevrolet.entity.Manager;
import by.home.chevrolet.service.impl.ManagerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class ManagerController {

    @Autowired
    ManagerServiceImpl managerService;

    @GetMapping("/manager")
    public ResponseEntity<List<Manager>> getAllManager() {
        return new ResponseEntity<>(managerService.getAll(), HttpStatus.OK);
    }

    @PutMapping("/manager")
    public ResponseEntity<Manager> addManager(@RequestBody Manager manager) {
        return new ResponseEntity<>(managerService.addManager(manager), HttpStatus.OK);
    }

    @PutMapping("/manager")
    public ResponseEntity<Manager> editManager(@RequestBody Manager manager) {
        return new ResponseEntity<>(managerService.editManager(manager), HttpStatus.OK);
    }

    @GetMapping("/manager")
    public ResponseEntity<Manager> getManagerByFullName(@RequestBody FullName fullName) {
        return new ResponseEntity<>(managerService.getByName(fullName), HttpStatus.OK);
    }

    @DeleteMapping("/manager{id}")
    public void delete(@PathVariable Long id) {
        managerService.delete(id);
    }


}
