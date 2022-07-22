package com.alopez.optional.ejemplo.models;

public class Fabricante {

    private String nombre;

    //Constructor
    public Fabricante(String nombre) {
        this.nombre = nombre;
    }

    //Getter and Setter de nombre
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
