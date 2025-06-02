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
}
