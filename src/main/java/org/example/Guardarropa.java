package org.example;
import java.util.List;
import java.util.ArrayList;
import java.util.Random;
import java.util.stream.Collectors;
import com.google.common.collect.Sets;
import java.util.HashSet;
import java.util.stream.Collectors;


public class Guardarropa {
  List<Prenda> prendasSuperiores;
  List<Prenda> prendasInferiores;
  List<Prenda> calzados;

  Prenda obtenerPrendaAleatoria(List<Prenda> listaPrendas){
    Random random = new Random();
    int indiceAleatorio = random.nextInt(listaPrendas.size());
    return listaPrendas.get(indiceAleatorio);
  }

//  Atuendo generarSugerencia(){
//    Prenda parteSuperior = obtenerPrendaAleatoria(prendasSuperiores);
//    Prenda parteInferior = obtenerPrendaAleatoria(prendasInferiores);
//    Prenda calzado = obtenerPrendaAleatoria(calzados);
//    return new Atuendo (parteSuperior, parteInferior, calzado);
//  } ;// el problema es q solo nos da una sola sugerencia y necesito varias

  List<Atuendo> generarSugerencias() {
    return Sets.cartesianProduct(
            new HashSet<>(prendasSuperiores),
            new HashSet<>(prendasInferiores),
            new HashSet<>(calzados)
        )
        .stream()
        .map(prenda -> new Atuendo(prenda.get(0), prenda.get(1), prenda.get(2)))
        .collect(Collectors.toList());
  }

  List<Atuendo> filtrarPorFormalidad(Formalidad formalidad, List<Atuendo> atuendos) {
    return atuendos.stream()
        .filter(atuendo -> atuendo.parteSuperior.formalidad == formalidad
            && atuendo.parteInferior.formalidad == formalidad
            && atuendo.calzado.formalidad == formalidad)
        .collect(Collectors.toList());
  }

}
