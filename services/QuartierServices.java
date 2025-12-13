package seyni.sn.services;
import java.util.List;
import java.util.Optional;
import seyni.sn.entity.Quartier;
public interface QuartierServices {
    int insert(Quartier quartier);
    List<Quartier> selectAll();
    Optional<Quartier> selectById(int id);
    Optional<Quartier> selectByName(String name);
}
