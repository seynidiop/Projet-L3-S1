package seyni.sn.services.impl;

import seyni.sn.repository.ZoneRepository;
import seyni.sn.services.ZoneServices;
public class ZoneServicesImpl implements ZoneServices {

    private static ZoneServicesImpl instance;
    private final ZoneRepository repository;

    private ZoneServicesImpl(ZoneRepository repository) {
        this.repository = repository;
    }

    public static ZoneServicesImpl getInstance(ZoneRepository repository) {
        if (instance == null) {
            instance = new ZoneServicesImpl(repository);
        }
        return instance;
    }
}
