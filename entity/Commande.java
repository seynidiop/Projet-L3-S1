package seyni.sn.entity;


import java.util.Date;

import lombok.*;


@Getter @Setter @NoArgsConstructor @AllArgsConstructor @ToString

public class Commande{
    private int id;
    
    private Client client;

    private Menu menu;

    private Complement complement;

    private Burger burger;

    private Date dateCommande=new Date();

    private String statut =StatusCommande.EnCours.name();

    private String modePaiement;

    private int  zoneId;

    private Double montantTotal;

    private boolean archived = false;
}