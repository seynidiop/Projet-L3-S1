package seyni.sn.services;

import java.util.List;
import java.util.Optional;

import seyni.sn.entity.Burger;

public interface BurgerServices {
    public boolean createBurger(Burger burger);
    Optional<Burger> getById(int id);
    List<Burger> selectAll();
    Optional<Burger> getByName(String name);
    
}
