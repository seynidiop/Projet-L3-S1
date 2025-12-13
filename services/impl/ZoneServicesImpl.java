package seyni.sn.services.impl;

import seyni.sn.repository.ZoneRepository;
import seyni.sn.services.ZoneServices;
import seyni.sn.entity.Zone;
import java.util.List;
import java.util.Optional;

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
    @Override
    public int insert(Zone zone) {
        return repository.insert(zone);
    }
    @Override
    public List<Zone> selectAll() {
        return repository.selectAll();
    }
    @Override
    public Optional<Zone> selectById(int id) {
        return repository.selectById(id);
    }
    @Override
    public Optional<Zone> selectByName(String name) {
        return repository.selectByName(name);
    }
}