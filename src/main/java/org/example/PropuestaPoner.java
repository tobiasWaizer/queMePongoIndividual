package org.example;

public class PropuestaPoner implements PropuestaModificacion{ //ConcreteCommandPoner de propuestaModificacion
  public Prenda prenda;

  @Override
  public void aplicarEn(Guardarropa guardarropa) {
    guardarropa.poner(prenda);
  }

  public void deshacer(Guardarropa guardarropa) {
    guardarropa.sacar(prenda);
  }
}
