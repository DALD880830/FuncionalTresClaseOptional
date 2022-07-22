package com.alopez.optional.ejemplo.repositorio;

import com.alopez.optional.ejemplo.models.Computador;

import java.util.Optional;

public interface Repositorio <T>{

//    Computador filtrar(String nombre);
        Optional<Computador> filtrar(String nombre); //Cambiamos a programación funcional, poniendo un Optional

}
