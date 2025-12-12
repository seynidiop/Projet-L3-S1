package seyni.sn.entity;


import java.sql.Date;

import lombok.*;


@Getter @Setter @NoArgsConstructor @AllArgsConstructor @ToString

public class Commande{
    private int id;
    
    private Client client;

    private Menu menu;

    private Complement complement;

    private Burger burger;

    private Date dateCommande;

    private StatusCommande statut;

    private typePayement modePaiement;

    private int  zoneId;

    private int montantTotal;

    private boolean archived = false;
}