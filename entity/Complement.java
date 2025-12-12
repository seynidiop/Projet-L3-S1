package seyni.sn.entity;


import lombok.*;


@Getter @Setter @NoArgsConstructor @AllArgsConstructor @ToString
public class Complement {

    private int id;

    private String name;

    private int price;

    private String imagePath;

    private boolean archived = false;
}
