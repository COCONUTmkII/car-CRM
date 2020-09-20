package by.home.chevrolet.service.impl;

import by.home.chevrolet.entity.ClientType;
import by.home.chevrolet.repository.ClientTypeRepository;
import by.home.chevrolet.service.ClientTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ClientTypeServiceImpl implements ClientTypeService {

    @Autowired
    ClientTypeRepository clientTypeService;

    @Override
    public ClientType addClientType(ClientType clientType) {
        return null;
    }

    @Override
    public void delete(Long id) {
        clientTypeService.deleteById(id);
    }

    @Override
    public ClientType getByDescription(String name) {
        return clientTypeService.getClientTypeByClientDescription(name);
    }

    @Override
    public ClientType editClientType(ClientType clientType) {
        return clientTypeService.saveAndFlush(clientType);
    }

    @Override
    public List<ClientType> getAll() {
        return clientTypeService.findAll();
    }
}
