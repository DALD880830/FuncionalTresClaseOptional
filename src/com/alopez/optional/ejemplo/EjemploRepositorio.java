package com.alopez.optional.ejemplo;

import com.alopez.optional.ejemplo.models.Computador;
import com.alopez.optional.ejemplo.repositorio.ComputadorRepositorio;
import com.alopez.optional.ejemplo.repositorio.Repositorio;

import java.util.Optional;

public class EjemploRepositorio {

    public static void main(String[] args) {

        Repositorio<Computador> repositorio = new ComputadorRepositorio();

//        Computador pc = repositorio.filtrar("asus rog"); //Creamos el objeto si en el repositorio estpa el nombre que se filtra
        Optional<Computador> pc = repositorio.filtrar("asus rog");

        //Cambiamos a programación funcional
        if (pc.isPresent()){ //Si pc está presente
            System.out.println(pc.get());
        }else{ //De lo contrario
            System.out.println("No se encontró");
        }
/*
        if (pc != null){ //Si pc es diferente de null
            System.out.println(pc.getNombre());
        }else{ //De lo contratio
            System.out.println("No se encontró");
        }
*/

        //Tambien puede ser utilizando Java 8 o superior con expresiones lambda
        repositorio.filtrar("asus rog").ifPresentOrElse(System.out::println,
                ()-> System.out.println("No está presente"));



    }

}
