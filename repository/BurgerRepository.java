package seyni.sn.repository;

import java.util.List;
import java.util.Optional;

import seyni.sn.entity.Burger;

public interface BurgerRepository {
    List<Burger> selectAll();
    Optional<Burger> selectByName(String name);
    int insert(Burger burger);
}
