package seyni.sn.services.impl;
import seyni.sn.repository.BurgerRepository;
import seyni.sn.services.BurgerServices;
import seyni.sn.entity.Burger;
import java.util.List;
import java.util.Optional;
public class BurgerServicesImpl implements BurgerServices {

    private static BurgerServicesImpl instance;
    private final BurgerRepository burgerRepository;

    private BurgerServicesImpl(BurgerRepository burgerRepository) {
        this.burgerRepository = burgerRepository;
    }

    public static BurgerServicesImpl getInstance(BurgerRepository burgerRepository) {
        if (instance == null) {
            instance = new BurgerServicesImpl(burgerRepository);
        }
        return instance;
    }
    @Override
    public boolean createBurger(Burger burger) {
        return this.burgerRepository.insert(burger)!=0;
    }
    @Override
    
    public Optional<Burger> getByName(String name) {
        return this.burgerRepository.selectByName(name);
    }
    @Override
    public List<Burger> selectAll() {
        return burgerRepository.selectAll();
    }
}


