package seyni.sn.repository;
import java.util.List;
import java.util.Optional;
import seyni.sn.entity.Zone;
public interface ZoneRepository {
    int insert(Zone zone);
    List<Zone> selectAll();
    Optional<Zone> selectById(int id);
    Optional<Zone> selectByName(String name);
}
