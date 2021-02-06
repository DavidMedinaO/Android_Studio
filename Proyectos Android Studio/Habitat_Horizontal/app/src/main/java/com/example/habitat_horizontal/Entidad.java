package com.example.habitat_horizontal;

import java.io.Serializable;

public class Entidad implements Serializable {
    private int imgFoto;
    private String contenido;
    private String disponibilidad;

    public Entidad(int imgFoto, String contenido, String disponibilidad){
        this.imgFoto = imgFoto;
        this.contenido = contenido;
        this.disponibilidad = disponibilidad;


    }

    public int getImgFoto() {
        return imgFoto;
    }

    public String getContenido() {
        return contenido;
    }

    public String getDisponibilidad() {
        return disponibilidad;
    }
}
