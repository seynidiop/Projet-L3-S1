package seyni.sn.repository;

import java.util.List;
import java.util.Optional;

import seyni.sn.entity.Complement;

public interface ComplementRepository {
    List<Complement> selectAll();
    Optional<Complement> selectByName(String name);
    int insert(Complement complement);
}
