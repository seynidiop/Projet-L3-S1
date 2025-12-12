package seyni.sn.services.impl;
import seyni.sn.repository.CommandeRepository;
import seyni.sn.services.CommandeServices;
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
}
