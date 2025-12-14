package seyni.sn.repository;
import seyni.sn.entity.Commande;
import java.util.List;
public interface CommandeRepository {
    int insert(Commande commande);
    List<Commande> selectAll();
    java.util.Optional<Commande> selectById(int id);
}
