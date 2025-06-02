package org.example;


public class PrendaBorrador extends Prenda{ //EL BORRADOR ES UN BUILDER, esto me permite que la instanciacion se pueda hacer en momentos diferentes
  

  PrendaBorrador(TipoPrenda tipoDePrenda, Color colorPrincipal, Color colorSecundario, Material tipoDeMaterial, Trama trama, Formalidad formalidad, Integer temperaturaMinima, Integer temperaturaMaxima) {
    super(tipoDePrenda, colorPrincipal, colorSecundario, tipoDeMaterial, trama, formalidad, temperaturaMinima, temperaturaMaxima);
  }

  // Métodos para completar los campos faltantes
  public void setTipoDePrenda(TipoPrenda tipoDePrenda) {
    //validateNotNull(tipoDePrenda);
    this.tipoDePrenda = tipoDePrenda;
  }

  public void setColorPrincipal(Color colorPrincipal) {
    //validateNotNull(tipoDePrenda);
    this.colorPrincipal = colorPrincipal;
  }

  public void setColorSecundario(Color colorSecundario) {
    this.colorSecundario = colorSecundario;
  }

  public void setTipoDeMaterial(Material tipoDeMaterial) {
    //validateNotNull(tipoDePrenda);
    this.tipoDeMaterial = tipoDeMaterial;
  }

  public void setTrama(Trama trama) {
    //validateNotNull(tipoDePrenda);
    if(trama == null){
      trama = Trama.LISA;
    } else {
      this.trama = trama;
    }
  }

  public void setFormalidad(Formalidad formalidad) {
    this.formalidad = formalidad;
  }

  public void setTemperaturaMaxima(Integer temperaturaMaxima) {
    this.temperaturaMinima = temperaturaMaxima;
  }
  public void setTemperaturaMinima(Integer temperaturaMinima) {
    this.temperaturaMaxima = temperaturaMinima;
  }

  // Método para validar si la prenda borrador está completa
  public boolean estaCompleta() {
    return tipoDePrenda != null && colorPrincipal != null && tipoDeMaterial != null && trama != null && formalidad != null && temperaturaMaxima != null;
  }

  // Método para convertir el borrador en una instancia de Prenda
  public Prenda crearPrenda() {
    if (!estaCompleta()) {
      throw new IllegalStateException("La prenda borrador no está completa.");
    }
    return new Prenda(tipoDePrenda, colorPrincipal, colorSecundario, tipoDeMaterial, trama, formalidad,temperaturaMinima ,temperaturaMaxima);
  }
}
