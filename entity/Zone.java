package seyni.sn.entity;


import java.util.List;

import lombok.*;


@Getter @Setter @NoArgsConstructor @AllArgsConstructor @ToString
public class Zone {

    private int id;

    private String nom;

    private int prixLivraison;

    private List<Quartier> quartiers;
    
}
