package com.example.pullmoch.modele;

import java.io.Serializable;
import java.util.ArrayList;

public class Pull implements Serializable {

    private String titre;
    private String description;
    private String image;
    private double tarif;

    public Pull(String titre, String description, double tarif, String image) {
        this.titre = titre;
        this.description = description;
        this.tarif = tarif;
        this.image = image;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public double getTarif() {
        return tarif;
    }

    public void setTarif(int tarif) {
        this.tarif = tarif;
    }
}

