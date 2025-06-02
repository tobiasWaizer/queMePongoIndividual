package org.example;

public class EstadoClima {
  Integer temperatura;
  Integer humedad;

  public EstadoClima(Integer temperatura, Integer humedad) {
    this.temperatura = temperatura;
    this.humedad = humedad;
  }

  public Integer getTemperatura() {
    return temperatura;
  }
  public Integer getHumedad() {
    return humedad;
  }
}
