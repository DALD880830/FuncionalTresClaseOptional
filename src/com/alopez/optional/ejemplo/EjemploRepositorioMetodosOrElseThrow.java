package com.alopez.optional.ejemplo;

import com.alopez.optional.ejemplo.models.Computador;
import com.alopez.optional.ejemplo.repositorio.ComputadorRepositorio;
import com.alopez.optional.ejemplo.repositorio.Repositorio;

import java.util.Optional;

public class EjemploRepositorioMetodosOrElseThrow {

    public static void main(String[] args) {

        Repositorio<Computador> repositorio = new ComputadorRepositorio();

        Computador pc = repositorio.filtrar("asus rog").orElseThrow(IllegalStateException::new);
        //orElseThrow, si no existe lanza una excepción
        System.out.println(pc);

        String archivo = "documento.pdf"; //String con un nombre
        String extension = Optional.ofNullable(archivo) //Usamos Optional
                .filter(a -> a.contains(".")) //a de archivo, si a contiene .
                .map(a -> a.substring(archivo.lastIndexOf(".") + 1)) //obtenemos la extension despues del .
                .orElseThrow(); //Si no contiene el . manda la excepcion
        System.out.println(extension);

    }


}
