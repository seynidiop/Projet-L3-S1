package seyni.sn.services.impl;
import seyni.sn.repository.LivraisonRepository;
import seyni.sn.services.LivraisonServices;
public class LivraisonServicesImpl implements LivraisonServices {

    private static LivraisonServicesImpl instance;
    private final LivraisonRepository repository;

    private LivraisonServicesImpl(LivraisonRepository repository) {
        this.repository = repository;
    }

    public static LivraisonServicesImpl getInstance(LivraisonRepository repository) {
        if (instance == null) {
            instance = new LivraisonServicesImpl(repository);
        }
        return instance;
    }
}
