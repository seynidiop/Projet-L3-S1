package seyni.sn.services;

import java.util.List;
import java.util.Optional;

import seyni.sn.entity.Complement;

public interface ComplementServices {
    public boolean createComplement(Complement complement);
    Optional<Complement> getByName(String name);
    List<Complement> selectAll();
}
