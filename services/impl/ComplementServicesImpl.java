package seyni.sn.services.impl;
import seyni.sn.repository.ComplementRepository;
import seyni.sn.services.ComplementServices;
public class ComplementServicesImpl implements ComplementServices {

    private static ComplementServicesImpl instance;
    private final ComplementRepository repository;

    private ComplementServicesImpl(ComplementRepository repository) {
        this.repository = repository;
    }

    public static ComplementServicesImpl getInstance(ComplementRepository repository) {
        if (instance == null) {
            instance = new ComplementServicesImpl(repository);
        }
        return instance;
    }
}
