package seyni.sn.services.impl;
import seyni.sn.repository.ComplementRepository;
import seyni.sn.services.ComplementServices;
import seyni.sn.entity.Complement;
import java.util.List;
import java.util.Optional;
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
    @Override
    public boolean createComplement(Complement complement) {
        int result = repository.insert(complement);
        return result > 0;
    }
    @Override
    public Optional<Complement> getByName(String name) {
        return repository.selectByName(name);
    }
    @Override
    public List<Complement> selectAll() {
        return repository.selectAll();
    }
}

