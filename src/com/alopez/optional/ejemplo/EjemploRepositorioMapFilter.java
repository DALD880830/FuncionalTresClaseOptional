package com.alopez.optional.ejemplo;

import com.alopez.optional.ejemplo.models.Computador;
import com.alopez.optional.ejemplo.models.Fabricante;
import com.alopez.optional.ejemplo.repositorio.ComputadorRepositorio;
import com.alopez.optional.ejemplo.repositorio.Repositorio;

public class EjemploRepositorioMapFilter {

    public static void main(String[] args) {

        Repositorio<Computador> repositorio = new ComputadorRepositorio();

/*      ANTES DE OPTIONAL EN EL get DE FABRICANTE Y PROCESADOR
        Fabricante f = repositorio.filtrar("asus rog")
                .map(Computador::getProcesador) //Obtenemos el procesador, Esto es igual a c -> c.getProcesador()
                .map(p-> p.getFabricante())
                .filter(fab -> "intel".equalsIgnoreCase(fab.getNombre())) //Con filter filtramos el nombre, si es diferente del que pasamos retorna false
                .orElseThrow(); //Si no encuentra el fabricante, lanza una excepcion
        //orElse devuelve el objeto, si no se encuentra, devuelve un objeto por defecto
*/
        Fabricante f = repositorio.filtrar("asus rog")
                .flatMap(Computador::getProcesador) //Obtenemos el procesador, Esto es igual a c -> c.getProcesador()
                .flatMap(p-> p.getFabricante())
                .filter(fab -> "intel".equalsIgnoreCase(fab.getNombre())) //Con filter filtramos el nombre, si es diferente del que pasamos retorna false
                .orElseThrow(); //Si no encuentra el fabricante, lanza una excepcion
        //orElse devuelve el objeto, si no se encuentra, devuelve un objeto por defecto

        System.out.println(f.getNombre()); //De una computador, convertimos a un procesador y convertimos a un fabricante


    }

}
