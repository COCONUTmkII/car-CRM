package by.home.chevrolet.service;

import by.home.chevrolet.entity.ClientType;
import java.util.List;

public interface ClientTypeService {
    ClientType addClientType(ClientType clientType);
    void delete(Long id);
    ClientType getByDescription(String name);
    ClientType editClientType(ClientType clientType);
    List<ClientType> getAll();
}
