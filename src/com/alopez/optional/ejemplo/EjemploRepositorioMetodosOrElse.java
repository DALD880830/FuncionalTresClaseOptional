package com.alopez.optional.ejemplo;

import com.alopez.optional.ejemplo.models.Computador;
import com.alopez.optional.ejemplo.repositorio.ComputadorRepositorio;
import com.alopez.optional.ejemplo.repositorio.Repositorio;

import java.util.Optional;

public class EjemploRepositorioMetodosOrElse {

    public static void main(String[] args) {

        Repositorio<Computador> repositorio = new ComputadorRepositorio();

        Computador pc = repositorio.filtrar("asus rog").orElse(new Computador("HP Omen", "LA0001"));
        //orElse devuelve el objeto, si no se encuentra, devuelve un objeto por defecto

        System.out.println(pc);

        pc = repositorio.filtrar("macboook").orElseGet(() ->{
            return new Computador("Lenovo", "Ideapad");
        }); //orElseGet() se le pasa una expresion lambda que retorna un objeto
        System.out.println(pc);

        pc = repositorio.filtrar("macboook").orElseGet(EjemploRepositorioMetodosOrElse::valorDefecto);
        System.out.println(pc);

    }

    public static Computador valorDefecto(){ //Metodo para dar un valor por defecto y no usar el orElseGet
        System.out.println("Obteniendo valor por defecto");
        return new Computador("Sony", "S005"); //El metodo retorna un objeto nuevo
    }

}
