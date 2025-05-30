package org.example;

public enum Formalidad {
  FORMAL("FORMAL"), INFORMAL("INFORMAL"), NEUTRO("NEUTRO");
  String nombre;

  Formalidad(String nombre) {
    this.nombre = nombre;
  }
}