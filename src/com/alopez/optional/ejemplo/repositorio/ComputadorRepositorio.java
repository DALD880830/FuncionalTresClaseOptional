package com.alopez.optional.ejemplo.repositorio;

import com.alopez.optional.ejemplo.models.Computador;
import com.alopez.optional.ejemplo.models.Fabricante;
import com.alopez.optional.ejemplo.models.Procesador;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ComputadorRepositorio implements Repositorio<Computador>{

    private List<Computador> dataSource = new ArrayList<>();

    public ComputadorRepositorio() {
        dataSource = new ArrayList<>(); //Creacion de un arrayList
        Procesador proc = new Procesador("I9-9880H", new Fabricante("Intel"));
        Computador asus = new Computador("Asus ROG", "Strix G512");
        asus.setProcesador(proc);
//        dataSource.add(new Computador("Asus ROG", "Strix G512")); //Adherimos objetos al arrayList
        dataSource.add(asus);
        dataSource.add(new Computador("MacBook Pro", "MVVK2CI"));
    }

    @Override
//    public Computador filtrar(String nombre) {
    public Optional<Computador> filtrar(String nombre) {
        return dataSource.stream().filter(c -> c.getNombre().toLowerCase().contains(nombre.toLowerCase())) //Cambiamos por expresiones lambda
                .findFirst(); //findFirst() decvuelve un Optional - el primer elemento que encuentra o un optional vacío

        /*
        for (Computador c : dataSource){
            if (c.getNombre().equalsIgnoreCase(nombre)){
//                return c;
                return Optional.of(c); //Cambiamos a que debe retornar un Optional.of
            }
        }
        return Optional.empty(); //Cambiamos a que debe retornar un Optional.of
//        return null;*/
    }
}
