package org.example;

import java.util.zip.ZipEntry;
//Como usuarie de QuéMePongo, quiero especificar qué trama tiene la tela de una prenda (lisa, rayada, con lunares, a cuadros o un estampado).
//Como usuarie de QuéMePongo, quiero crear una prenda especificando primero de qué tipo es.
//Como usuarie de QuéMePongo, quiero crear una prenda especificando en segundo lugar los aspectos relacionados a su material (colores, material, trama, etc) para evitar elegir materiales inconsistentes con el tipo de prenda. materiales inconcistentes con el tipo de prenda?????
//Como usuarie de QuéMePongo, quiero poder no indicar ninguna trama para una tela, y que por defecto ésta sea lisa.
//Como usuarie de QuéMePongo, quiero poder guardar una prenda solamente si esta es válida.
public class Prenda {
  TipoPrenda tipoDePrenda; //pantalon, pollera, zapatos etc
  Color colorPrincipal;
  Color colorSecundario;
  Material tipoDeMaterial;
  Trama trama;
  Formalidad formalidad;
  Integer temperaturaMinima;
  Integer temperaturaMaxima;

//  enum Formalidad {
//    FORMAL("FORMAL"), INFORMAL("INFORMAL"), NEUTRO("NEUTRO");
//    String nombre;
//
//    Formalidad(String nombre) {
//      this.nombre = nombre;
//    }
//  }


  public enum TipoPrenda {

    ZAPATOS(Categoria.CALZADO, "zapato"),
    POLLERA(Categoria.PARTE_INFERIOR, "pollera"),
    CAMISA(Categoria.PARTE_SUPERIOR, "camisa"),
    PANTALON(Categoria.PARTE_INFERIOR, "pantalon"),
    ZAPATILLAS(Categoria.CALZADO, "zapatilla"),
    CAMISETA(Categoria.PARTE_SUPERIOR, "camiseta" );

    Categoria categoria;
    String nombre;

    TipoPrenda(Categoria categoria, String nombre) {
      this.categoria = categoria;
      this.nombre = nombre;
    }

    public Categoria getCategoria() {
      return categoria;
    }
  }

  public enum Categoria {
    PARTE_SUPERIOR("PARTE_SUPERIOR"), PARTE_INFERIOR("PARTE_INFERIOR"), CALZADO("CALZADO"), ACCESORIO("ACCESORIO");

    String nombre;

    Categoria(String nombre) {
      this.nombre = nombre;
    }
  }

  public enum Material {
    ALGODON("ALGODON"), POLIESTER("POLIESTER"), LANA("LANA"), CUERO("CUERO");

    String nombre;

    Material(String nombre) {
      this.nombre = nombre;
    }
  }

  public void validarPrenda() {
    if (tipoDePrenda == null) {
      throw new PrendaInvalidaException("no se especificó el tipo de prenda");
    }
    if (colorPrincipal == null) {
      throw new PrendaInvalidaException("no se especificó el color de prenda");
    }
    if (tipoDeMaterial == null) {
      throw new PrendaInvalidaException("no se especificó el tipo de material");
    }
  }

  public class PrendaInvalidaException extends RuntimeException {
    public PrendaInvalidaException(String message) {
      super("la prenda es invalida porque " + message);
    }
  }

  public enum Trama {
    LISA("LISA"), RAYADA("RAYADA"), ACUADROS("ACUADROS"), CONLUNARES("CONLUNARES"), ESTAMPADO("ESTAMPADO");

    String nombreTrama;

    Trama(String nombre) {
      this.nombreTrama = nombre;
    }
  }

  public boolean esAcordeATemperatura(Integer temperatura) {
    if (temperatura == null) {
      return true; // Si no se especifica temperatura, se considera acorde
    }
    return temperatura >= temperaturaMinima && temperatura <= temperaturaMaxima;
  }

  public Prenda(TipoPrenda tipoDePrenda, Color colorPrincipal, Color colorSecundario, Material tipoDeMaterial, Trama trama, Formalidad formalidad, Integer temperaturaMinima, Integer temperaturaMaxima) {
      this.tipoDePrenda = tipoDePrenda;
      this.colorPrincipal = colorPrincipal;
      this.colorSecundario = colorSecundario;
      this.tipoDeMaterial = tipoDeMaterial;
      this.trama = trama;
      this.formalidad = formalidad;
      this.temperaturaMinima = temperaturaMinima;
      this.temperaturaMaxima = temperaturaMaxima;

  }

  public TipoPrenda getTipo() {
    return tipoDePrenda;
  }
  public Color getColorPrincipal() {
    return colorPrincipal;
  }
  public Color getColorSecundario() {
    return colorSecundario;
  }
  public String getNombre() {
    return tipoDePrenda.nombre;
  }
  public String getMaterial() {
    return tipoDeMaterial.nombre;
  }
  public Trama getTrama() {
    return trama;
  }
  public Formalidad getFormalidad() {
    return formalidad;
  }
  public Integer getTemperaturaMinima() {
    return temperaturaMinima;
  }
  public Integer getTemperaturaMaxima() {
    return temperaturaMaxima;
  }
}
