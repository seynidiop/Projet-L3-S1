package seyni.sn.services.impl;
import seyni.sn.services.QuartierServices;
import seyni.sn.repository.QuartierRepository;

public class QuartierServicesImpl implements QuartierServices {

    private static QuartierServicesImpl instance;
    private final QuartierRepository repository;

    private QuartierServicesImpl(QuartierRepository repository) {
        this.repository = repository;
    }

    public static QuartierServicesImpl getInstance(QuartierRepository repository) {
        if (instance == null) {
            instance = new QuartierServicesImpl(repository);
        }
        return instance;
    }
}
