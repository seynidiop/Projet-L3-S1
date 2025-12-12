package seyni.sn.view;

import java.util.Scanner;

import seyni.sn.config.database.Database;
import seyni.sn.config.factory.services.ServicesFactory;
import seyni.sn.entity.Burger;
import seyni.sn.entity.entityName;
import seyni.sn.entity.nomComplement;
import seyni.sn.entity.Complement;
import seyni.sn.repository.BurgerRepository;
import seyni.sn.repository.Impl.*;
import seyni.sn.services.BurgerServices;

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
        BurgerServices burgerServices=(BurgerServices)ServicesFactory.createServices(entityName.BURGER);
        do {
            burger.setName(saisieChaine("Entrez le nom du burger : "));
            if(burgerServices.getByName(burger.getName()).isPresent()){
                System.out.println("Un burger avec ce nom existe deja. Veuillez en choisir un autre.");
            }

        } while (burgerServices.getByName(burger.getName()).isPresent());

        burger.setPrice(saisiePrix("Entrez le prix du burger : "));
        scanner.nextLine();
        System.out.println("Entrez la description du burger : ");
        burger.setDescription(scanner.nextLine());
        System.out.println("Entrez le chemin de l'image du burger : ");
        burger.setImagepath(scanner.nextLine());
        return burger;
    }

    public static Complement createComplement(){
        Complement complement = new Complement();
        complement.setName(selectComplement().toString());
        complement.setPrice(saisiePrix("Entrez le prix du complement : "));
        complement.setImagepath(saisieChaine("Entrez le chemin de l'image du complement : "));
        return complement;
    }
    public static String saisieChaine(String message) {
        String nom;
        while (true) {
            System.out.print(message);
            nom = scanner.nextLine().trim();

            if (nom.isEmpty()) {
                System.out.println("Le nom ne peut pas être vide.");
                continue;
            }

            if (nom.length() < 3) {
                System.out.println("Le nom doit contenir au moins 3 caractères.");
                continue;
            }
            return nom;
        }
    }
    public static double saisiePrix(String message) {
        double price;
        while (true) {
            System.out.print(message);
            if (scanner.hasNextDouble()) {
                price = scanner.nextDouble();
                scanner.nextLine(); 
                if (price < 0) {
                    System.out.println("Le prix ne peut pas être négatif.");
                    continue;
                }
                return price;
            } else {
                System.out.println("Veuillez entrer un nombre valide pour le prix.");
                scanner.next(); 
            }
        }
    }
    public static nomComplement selectComplement() {
        int choix;

        do {
            System.out.println("Choisissez un complément :");
            for (int i = 0; i < nomComplement.values().length; i++) {
                System.out.println((i + 1) + ". " + nomComplement.values()[i]);
            }

            System.out.print("Votre choix : ");

            while (!scanner.hasNextInt()) {
                System.out.println("Entrée invalide. Entrez un numéro.");
                scanner.next();  
            }

            choix = scanner.nextInt();

            if (choix < 1 || choix > nomComplement.values().length) {
                System.out.println("Numéro hors plage. Réessayez.\n");
            }

        } while (choix < 1 || choix > nomComplement.values().length);

        return nomComplement.values()[choix - 1];
    }

}