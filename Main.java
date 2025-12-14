package seyni.sn;

import java.sql.Connection;
import seyni.sn.config.factory.database.DatabaseFactory;
import seyni.sn.config.factory.services.ServicesFactory;
import seyni.sn.services.*;
import seyni.sn.view.ressourcesCreation;
import seyni.sn.entity.*;
//import seyni.sn.config.factory.database.EntityManager;
import seyni.sn.config.database.Database;

public class Main {
    public static void main(String[] args) {
        CommandeServices commandeServices = (CommandeServices) ServicesFactory.createServices(entityName.COMMANDE);
        Commande commande = ressourcesCreation.createCommande();
        if(commandeServices.insert(commande) > 0){
            System.out.println("Commande créée avec succès !");
        } else {
            System.out.println("Échec de la création de la commande.");
        }
    }
}
