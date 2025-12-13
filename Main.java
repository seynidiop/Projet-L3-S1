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
        MenuServices menuServices=(MenuServices)ServicesFactory.createServices(entityName.MENU);
        Menu menu=ressourcesCreation.createMenu();
        if(menuServices.insert(menu)){
            System.out.println("Menu a ete cree avec succes!");
        }else{
            System.out.println("Echec de la creation du menu.");
        }
        System.out.println(menuServices.selectAll());
        

    }
}
