package seyni.sn;

import java.sql.Connection;

import seyni.sn.config.factory.database.DatabaseFactory;
import seyni.sn.config.factory.services.ServicesFactory;
import seyni.sn.services.BurgerServices;
import seyni.sn.view.ressourcesCreation;
import seyni.sn.entity.*;
//import seyni.sn.config.factory.database.EntityManager;
import seyni.sn.config.database.Database;

public class Main {
    public static void main(String[] args) {
        BurgerServices burgerServices=(BurgerServices)ServicesFactory.createServices(entityName.BURGER);
        Burger burger=ressourcesCreation.createBurger();
        if(burgerServices.createBurger(burger)){
            System.out.println("Burger a ete cree avec succes!");
        }else{
            System.out.println("Echec de la creation du burger."); 
        }
        System.out.println(burgerServices.selectAll());

    }
}
