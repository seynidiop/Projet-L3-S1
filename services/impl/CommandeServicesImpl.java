package seyni.sn.services.impl;
import seyni.sn.repository.CommandeRepository;
import seyni.sn.services.CommandeServices;
import seyni.sn.entity.Commande;
import java.util.List;
import java.util.Optional;
public class CommandeServicesImpl implements CommandeServices {

    private static CommandeServicesImpl instance;
    private final CommandeRepository repository;

    private CommandeServicesImpl(CommandeRepository repository) {
        this.repository = repository;
    }

    public static CommandeServicesImpl getInstance(CommandeRepository repository) {
        if (instance == null) {
            instance = new CommandeServicesImpl(repository);
        }
        return instance;
    }
    @Override
    public int insert(Commande commande) {
        return repository.insert(commande);
    }

    @Override
    public Optional<Commande> findById(int id) {
        return repository.selectById(id);
    }

    @Override
    public List<Commande> findAll() {
        return repository.selectAll();
    }
}