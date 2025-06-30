package org.example;

import java.util.List;

public class Usuario {
  Guardarropa guardarropa;
  ServicioMeteorologicoAccuWeather proveedorClima;

  EstadoClima estadoActual(String ciudad){
    return proveedorClima.obtenerEstadoClima(ciudad);
  }

  List<Atuendo> filtrarPorTemperaturaActual(){
    return guardarropa.filtrarPorTemperatura(proveedorClima.obtenerEstadoClima("Buenos Aires, Argentina").getTemperatura(), guardarropa.generarSugerencias());
  }

  //el usuario va a ser quien solicite las acciones, donde comienza el flujo, entonces es el INVOKER
  void sugerirModificacion(Guardarropa guardarropa, PropuestaModificacion propuestaModificacion){
    guardarropa.propuestas.add(propuestaModificacion);
  }

  void rechazarPropuesta(PropuestaModificacion propuesta) {
    if (guardarropa.propuestas.contains(propuesta)) {
      guardarropa.propuestas.remove(propuesta); // quizas seria util que la propuesta tuviera un campo que indique si fue aceptada o rechazada
    } else {
      throw new IllegalArgumentException("La propuesta no se encuentra en la lista de propuestas de modificaciones del guardarropa");
    }
  }

  void aceptarPropuesta(PropuestaModificacion propuesta) {
    if (guardarropa.propuestas.contains(propuesta)) {
      propuesta.aplicarEn(guardarropa); //quizas seria util que la propuesta tuviera un campo que se llame aceptada o rechazada.
    } else {
      throw new IllegalArgumentException("La propuesta no se encuentra en la lista de propuestas de modificaciones del guardarropa");
    }
  }

  List<PropuestaModificacion> verPropuestas() {
    return guardarropa.propuestas;
  }

  void desHacerPropuesta(PropuestaModificacion propuesta) {
    if (guardarropa.propuestas.contains(propuesta)) {
      propuesta.deshacer(guardarropa);
    } else {
      throw new IllegalArgumentException("La propuesta no se encuentra en la lista de propuestas de modificaciones del guardarropa");
    }
  }
}
