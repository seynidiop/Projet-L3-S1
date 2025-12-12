package seyni.sn.entity;


import lombok.*;


@Getter @Setter @NoArgsConstructor @AllArgsConstructor @ToString

public class Commande{
    private int id;
    

    private String dateCommande;

    private StatusCommande statut;

    private String modePaiement;

    private int  zoneId;

    private int montantTotal;

    private boolean archived = false;
}