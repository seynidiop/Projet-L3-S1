package seyni.sn.repository;

import java.util.List;
import java.util.Optional;


import seyni.sn.entity.*;

public interface ClientRepository {
    List<Client> selectAll();
    Optional<Client> selectById(int id);
    int insert(Client client);
}
