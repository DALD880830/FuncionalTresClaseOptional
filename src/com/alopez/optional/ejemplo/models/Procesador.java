package com.alopez.optional.ejemplo.models;

import java.util.Optional;

public class Procesador {

    private String nombre;
    private Fabricante fabricante;

    //Constructor con nombre y fabricante
    public Procesador(String nombre, Fabricante fabricante) {
        this.nombre = nombre;
        this.fabricante = fabricante;
    }

    //Getter and Setter de nombre
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    //Getter abd Setter de Fabricante
    public Optional<Fabricante> getFabricante() {
        return Optional.ofNullable(fabricante);
    }
    public void setFabricante(Fabricante fabricante) {
        this.fabricante = fabricante;
    }
}
