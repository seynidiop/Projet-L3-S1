package seyni.sn.services;

import java.util.List;
import java.util.Optional;

import seyni.sn.entity.Burger;

public interface BurgerServices {
    public boolean createBurger(Burger burger);
    Optional<Burger> getByName(String name);
    List<Burger> selectAll();
}
