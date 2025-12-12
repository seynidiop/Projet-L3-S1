package seyni.sn.entity;


import lombok.*;


@Getter @Setter @NoArgsConstructor @AllArgsConstructor @ToString
public class Menu {
    private int id;

    private String nom;

    private String description;

    private String imagePath;

    private Double price;

    private Burger burger;

    private Complement complement;

    private boolean archived = false;
        
}
