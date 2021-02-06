package com.example.preguntados;

public class Puntos {

    private String nom;
    private String punt;

    public Puntos(String nom,String punt){

        this.setNom(nom);
        this.setPunt(punt);


    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPunt() {
        return punt;
    }

    public void setPunt(String punt) {
        this.punt = punt;
    }
}
