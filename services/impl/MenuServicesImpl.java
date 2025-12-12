package seyni.sn.services.impl;
import seyni.sn.repository.MenuRepository;
import seyni.sn.services.MenuServices;
public class MenuServicesImpl implements MenuServices {

    private static MenuServicesImpl instance;
    private final MenuRepository repository;

    private MenuServicesImpl(MenuRepository repository) {
        this.repository = repository;
    }

    public static MenuServicesImpl getInstance(MenuRepository repository) {
        if (instance == null) {
            instance = new MenuServicesImpl(repository);
        }
        return instance;
    }
}
