package by.home.chevrolet.controller;

import by.home.chevrolet.entity.Client;
import by.home.chevrolet.entity.FullName;
import by.home.chevrolet.service.impl.ClientServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class ClientController {

    @Autowired
    ClientServiceImpl clientService;

    @GetMapping("/client")
    public ResponseEntity<List<Client>> getAllClient() {
        return new ResponseEntity<>(clientService.getAll(), HttpStatus.OK);
    }

    @PostMapping("/client")
    public ResponseEntity<Client> createClient(@RequestBody Client client) {
        return new ResponseEntity<>(clientService.addClient(client), HttpStatus.OK);
    }

/*    @GetMapping("/client")
    public ResponseEntity<Client> getClientByFullName(@RequestBody FullName fullName) {
        return new ResponseEntity<>(clientService.getByFullName(fullName), HttpStatus.OK);
    }*/

    @PutMapping("/client")
    public ResponseEntity<Client> editClient(@RequestBody Client client) {
        return new ResponseEntity<>(clientService.editClient(client), HttpStatus.OK);
    }

    @DeleteMapping("/client{id}")
    public void delete(@PathVariable Long id) {
        clientService.delete(id);
    }

}
