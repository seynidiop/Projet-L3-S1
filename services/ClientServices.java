package seyni.sn.services;

import java.util.List;
import java.util.Optional;

import seyni.sn.entity.Client;

public interface ClientServices {
    public boolean createClient(Client client);
    Optional<Client> getById(int id);
    List<Client> selectAll();
    
}
