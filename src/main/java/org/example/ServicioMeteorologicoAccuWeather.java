package org.example;

import java.util.*;

public class ServicioMeteorologicoAccuWeather implements ServicioMeteorologico { //condicionClimaticaAccuWeather podria llamarse
  AccuWeatherAPI apiClima = new AccuWeatherAPI();
  // Constructor

  List<Map<String, Object>> condicionesClimaticasApi(String ciudad){
    return apiClima.getWeather(ciudad);
  }

  public EstadoClima obtenerEstadoClima(String ciudad){
    List<Map<String, Object>> condicionesApi = condicionesClimaticasApi(ciudad);//traduccion a mi dominio

    Map<String, Object> temperaturaMap = (Map<String, Object>) condicionesApi.get(0).get("Temperature");
    Integer temperatura = (Integer) temperaturaMap.get("Value");
    String unidad = (String) temperaturaMap.get("Unit");
    if ("F".equals(unidad)) {
      // Suponiendo que la unidad es Celsius si no es F
      temperatura = temperatura * 5/9;
    }
    Integer humedad = (Integer) condicionesApi.get(0).get("Humidity");
    return new EstadoClima(temperatura, humedad);
  }


}
