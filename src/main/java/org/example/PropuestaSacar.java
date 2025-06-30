package org.example;

public class PropuestaSacar implements PropuestaModificacion{ //ConcreteCommandSacar de propuestaModificacion
  public Prenda prenda;

  @Override
  public void aplicarEn(Guardarropa guardarropa) {
    guardarropa.sacar(prenda);
  }

  public void deshacer(Guardarropa guardarropa) {
    guardarropa.poner(prenda);
  }
}
