package seyni.sn.services.impl;
import seyni.sn.repository.ClientRepository;
import seyni.sn.services.ClientServices;
public class ClientServicesImpl implements ClientServices {

    private static ClientServicesImpl instance;
    private final ClientRepository repository;

    private ClientServicesImpl(ClientRepository repository) {
        this.repository = repository;
    }

    public static ClientServicesImpl getInstance(ClientRepository repository) {
        if (instance == null) {
            instance = new ClientServicesImpl(repository);
        }
        return instance;
    }
}
