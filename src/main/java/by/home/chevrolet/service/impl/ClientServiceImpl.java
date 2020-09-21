package by.home.chevrolet.service.impl;

import by.home.chevrolet.entity.Client;
import by.home.chevrolet.entity.FullName;
import by.home.chevrolet.repository.ClientRepository;
import by.home.chevrolet.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ClientServiceImpl implements ClientService {

    @Autowired
    ClientRepository clientRepository;

    @Override
    public Client addClient(Client client) {
        return clientRepository.saveAndFlush(client);
    }

    @Override
    public void delete(Long id) {
        clientRepository.deleteById(id);
    }

    @Override
    public Client getByFullName(FullName name) {
        return clientRepository.getClientByFullName(name);
    }

    @Override
    public Client editClient(Client client) {
        return clientRepository.saveAndFlush(client);
    }

    @Override
    public List<Client> getAll() {
        return clientRepository.findAll();
    }
}
