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
        ClientServices clientServices=(ClientServices)ServicesFactory.createServices(entityName.CLIENT);
        Client client=ressourcesCreation.createClient();
        if(clientServices.createClient(client)){
            System.out.println("Client a ete cree avec succes!");
        }else{
            System.out.println("Echec de la creation du menu.");
        }
        System.out.println(clientServices.selectAll());
        

    }
}
