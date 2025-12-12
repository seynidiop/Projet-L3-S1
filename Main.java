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
        ComplementServices complementServices=(ComplementServices)ServicesFactory.createServices(entityName.COMPLEMENT);
        Complement complement=ressourcesCreation.createComplement();
        if(complementServices.createComplement(complement)){
            System.out.println("Complement a ete cree avec succes!");
        }else{
            System.out.println("Echec de la creation du complement.");
        }
        System.out.println(complementServices.selectAll());

    }
}
