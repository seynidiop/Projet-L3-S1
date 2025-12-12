package seyni.sn.view;

import java.util.Scanner;

import seyni.sn.entity.Burger;
import seyni.sn.entity.entityName;

public class ressourcesCreation {
     private static Scanner scanner = new Scanner(System.in);
    private ressourcesCreation(){
    }
    public static int menu(){
        System.out.println("MENU");
        System.out.println("1. Ajouter un produit");
        System.out.println("2. Voir liste d\'une ressource");
        System.out.println("3. Quitter");
        System.out.println("Faites votre choix: ");
        int choix = scanner.nextInt();
        scanner.nextLine();
        return choix;
    }
    public static entityName selectEntity() {
    
    int choix;

    do {
        System.out.println("Choisissez une ressource :");
        for (int i = 0; i < entityName.values().length; i++) {
            System.out.println((i + 1) + ". " + entityName.values()[i]);
        }

        System.out.print("Votre choix : ");

        while (!scanner.hasNextInt()) {
            System.out.println("Entrée invalide. Entrez un numéro.");
            scanner.next();  
        }

        choix = scanner.nextInt();

        if (choix < 1 || choix > entityName.values().length) {
            System.out.println("Numéro hors plage. Réessayez.\n");
        }

    } while (choix < 1 || choix > entityName.values().length);

    return entityName.values()[choix - 1];
}
public static Burger createBurger(){
    Burger burger = new Burger();
    System.out.println("Entrez le nom du burger : ");
    burger.setName(scanner.nextLine());
    System.out.println("Entrez le prix du burger : ");
    burger.setPrice(scanner.nextDouble());
    scanner.nextLine();
    System.out.println("Entrez la description du burger : ");
    burger.setDescription(scanner.nextLine());
    System.out.println("Entrez le chemin de l'image du burger : ");
    burger.setImagepath(scanner.nextLine());
    return burger;
}




}
