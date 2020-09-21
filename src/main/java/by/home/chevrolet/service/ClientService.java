package by.home.chevrolet.service;

import java.util.List;
import by.home.chevrolet.entity.Client;
import by.home.chevrolet.entity.FullName;

public interface ClientService {
    Client addClient(Client client);
    void delete(Long id);
    Client getByFullName(FullName name);
    Client editClient(Client client);
    List<Client> getAll();
}
