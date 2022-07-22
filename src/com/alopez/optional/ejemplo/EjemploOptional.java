package com.alopez.optional.ejemplo;

import java.util.Optional;

public class EjemploOptional {

    public static void main(String[] args) {

        String nombre = "Alejandro";

        Optional<String> opt = Optional.of(nombre); //Hay 3 Optional, empty - crea un optional vacio, of - crea un optional
        //a partir de una referencia - no acepta nulos, ofNullable - acepta nulos

        System.out.println(opt);
        System.out.println(opt.isPresent()); //isPresent es para saber si está presente o no y retorna un booleano

        if (opt.isPresent()) {
            System.out.println("opt.get() = " + opt.get()); //Con get obtenemos el valor
        }

        System.out.println(opt.isEmpty());

        opt.ifPresent(valor ->{
            System.out.println("Hola " + valor);
        });

        nombre = null;
        opt = Optional.ofNullable(nombre);
        System.out.println(opt);
        System.out.println("opt.isPresent() = " + opt.isPresent());
        System.out.println(opt.isEmpty());

        //Esta forma es mas funcional, con expresiones lambda y más limpio
        opt.ifPresentOrElse(valor -> System.out.println("Hola " + valor), () -> {
                System.out.println("Esta vacio");
        });

        if (opt.isPresent()) {
            System.out.println("opt.get() = " + opt.get()); //Con get obtenemos el valor
        }else{
            System.out.println("No esta presente");
        }

        Optional<String> optEmpty = Optional.empty();
        System.out.println(optEmpty);
        System.out.println(optEmpty.isPresent());

    }

}
