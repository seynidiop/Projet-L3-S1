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
       ZoneServices zoneServices=(ZoneServices) ServicesFactory.createServices(entityName.ZONE);
       QuartierServices quartierServices=(QuartierServices) ServicesFactory.createServices(entityName.QUARTIER);
       Quartier quartier = ressourcesCreation.createQuartier();
       if(quartierServices.insert(quartier)>0){
        System.out.println("Quartier ajouté avec succès !");
       } else {
        System.out.println("Échec de l'ajout du quartier.");
       }
    }
}
