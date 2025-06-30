package org.example;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import com.google.common.collect.Sets;
import java.util.HashSet;


public class Guardarropa {
  public List<Prenda> prendasSuperiores;
  public List<Prenda> prendasInferiores;
  public List<Prenda> calzados;
  public List<PropuestaModificacion> propuestas;

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

  public List<Atuendo> generarSugerencias() {
    return Sets.cartesianProduct(
            new HashSet<>(prendasSuperiores),
            new HashSet<>(prendasInferiores),
            new HashSet<>(calzados)
        )
        .stream()
        .map(prenda -> new Atuendo(prenda.get(0), prenda.get(1), prenda.get(2)))
        .collect(Collectors.toList());
  }

  public List<Atuendo> filtrarPorFormalidad(Formalidad formalidad, List<Atuendo> atuendos) {
    return atuendos.stream()
        .filter(atuendo -> atuendo.parteSuperior.formalidad == formalidad
            && atuendo.parteInferior.formalidad == formalidad
            && atuendo.calzado.formalidad == formalidad)
        .collect(Collectors.toList());
  }

  public List<Atuendo> filtrarPorTemperatura(Integer temperatura, List<Atuendo> atuendos) {

    return atuendos.stream()
        .filter(atuendo -> atuendo.parteSuperior.esAcordeATemperatura(temperatura)
            && atuendo.parteInferior.esAcordeATemperatura(temperatura)
            && atuendo.calzado.esAcordeATemperatura(temperatura))
        .collect(Collectors.toList());
  }

  public List<Prenda> separarPrendasSegun(Criterio criterio){
    List<Prenda> prendasQueCumplen = new ArrayList<>();
    List<Prenda> prendasSuperioresQueCumplen = prendasSuperiores.stream().filter(prenda -> criterio.esCumplido(prenda)).collect(Collectors.toList());
    List<Prenda> prendasinferioresQueCumplen = prendasInferiores.stream().filter(prenda -> criterio.esCumplido(prenda)).collect(Collectors.toList());
    List<Prenda> prendasCalzados = calzados.stream().filter(prenda -> criterio.esCumplido(prenda)).collect(Collectors.toList());
    prendasQueCumplen.addAll(prendasSuperioresQueCumplen);
    prendasQueCumplen.addAll(prendasinferioresQueCumplen);
    prendasQueCumplen.addAll(prendasCalzados);
    return prendasQueCumplen;
  }

  //las acciones del patron command las realiza el guardarropas, por lo tanto es el RECEPTOR
  void sacar(Prenda prenda){
    if(prendasSuperiores.contains(prenda))
      prendasSuperiores.remove(prenda);
    else if(prendasInferiores.contains(prenda))
      prendasInferiores.remove(prenda);
    else if(calzados.contains(prenda))
      calzados.remove(prenda);
    else
      throw new IllegalArgumentException("La prenda no se encuentra en el guardarropa");
  }

  void poner(Prenda prenda){
    if(prendasSuperiores.contains(prenda) || prendasInferiores.contains(prenda) || calzados.contains(prenda))
      throw new IllegalArgumentException("La prenda ya encuentra en el guardarropa");
    else agregarPrendaSegunSuTipo(prenda);
  }

  void agregarPrendaSegunSuTipo(Prenda prenda) {
    Prenda.Categoria categoria = prenda.getTipo().getCategoria();
    if (categoria == Prenda.Categoria.PARTE_SUPERIOR) {
      prendasSuperiores.add(prenda);
    } else if (categoria == Prenda.Categoria.PARTE_INFERIOR) {
      prendasInferiores.add(prenda);
    } else if (categoria == Prenda.Categoria.CALZADO) {
      calzados.add(prenda);
    } else {
      throw new IllegalArgumentException("La prenda no es de un tipo válido");
    }
  }



}
