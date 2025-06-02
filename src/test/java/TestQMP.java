
import org.example.*;
import org.junit.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.List;

import org.example.Formalidad;

public class TestQMP {
  Prenda prenda;
  Prenda camisa;
  Prenda camiseta;
  Prenda pantalon;
  Prenda zapatos;

  @BeforeEach
  void setUp() {
    prenda = new Prenda(
        Prenda.TipoPrenda.CAMISA,
        new Color("001100"),
        new Color("001124"),
        Prenda.Material.POLIESTER,
        Prenda.Trama.LISA,
        Formalidad.FORMAL,
        10,
        30
    );
    camisa = new Prenda(
        Prenda.TipoPrenda.CAMISA,
        new Color("001100"),
        new Color("001124"),
        Prenda.Material.POLIESTER,
        Prenda.Trama.LISA,
        Formalidad.FORMAL,
        10,
        30
    );
    camiseta = new Prenda(
        Prenda.TipoPrenda.CAMISETA,
        new Color("002200"),
        new Color("002224"),
        Prenda.Material.ALGODON,
        Prenda.Trama.RAYADA,
        Formalidad.INFORMAL,
        15,
        25
    );
    pantalon = new Prenda(
        Prenda.TipoPrenda.PANTALON,
        new Color("003300"),
        new Color("003334"),
        Prenda.Material.POLIESTER,
        Prenda.Trama.ACUADROS,
        Formalidad.FORMAL,
        5,
        20
    );
    zapatos = new Prenda(
        Prenda.TipoPrenda.ZAPATOS,
        new Color("004400"),
        new Color("004444"),
        Prenda.Material.CUERO,
        Prenda.Trama.CONLUNARES,
        Formalidad.FORMAL,
        0,
        40
    );
  }

  @Test
  void testearPrenda(){
    Prenda prenda = new Prenda(Prenda.TipoPrenda.CAMISA, new Color("001100"), new Color("001124"), Prenda.Material.POLIESTER, Prenda.Trama.LISA, Formalidad.FORMAL, 10, 30);
    Assertions.assertEquals("camisa", prenda.getNombre());
    Assertions.assertEquals("POLIESTER", prenda.getMaterial());
    Assertions.assertEquals("001100", prenda.getColorPrincipal().codigoDeColor);
    Assertions.assertEquals("001124", prenda.getColorSecundario().codigoDeColor);
    Assertions.assertEquals(Prenda.TipoPrenda.CAMISA, prenda.getTipo());
    Assertions.assertEquals(Prenda.Trama.LISA, prenda.getTrama());
    Assertions.assertEquals(Formalidad.FORMAL, prenda.getFormalidad());
    Assertions.assertEquals(10, prenda.getTemperaturaMinima());
    Assertions.assertEquals(30, prenda.getTemperaturaMaxima());
  }

  @Test
  void testearPrendaConElBefore() {
    Assertions.assertEquals("camisa", prenda.getNombre());
    Assertions.assertEquals("POLIESTER", prenda.getMaterial());
    Assertions.assertEquals("001100", prenda.getColorPrincipal().codigoDeColor);
    Assertions.assertEquals("001124", prenda.getColorSecundario().codigoDeColor);
    Assertions.assertEquals(Prenda.TipoPrenda.CAMISA, prenda.getTipo());
    Assertions.assertEquals(Prenda.Trama.LISA, prenda.getTrama());
    Assertions.assertEquals(Formalidad.FORMAL, prenda.getFormalidad());
    Assertions.assertEquals(10, prenda.getTemperaturaMinima());
    Assertions.assertEquals(30, prenda.getTemperaturaMaxima());
  }

  @Test
  void testearTemperaturaAcorde() {
    Assertions.assertTrue(prenda.esAcordeATemperatura(20));
    Assertions.assertTrue(prenda.esAcordeATemperatura(10));
    Assertions.assertTrue(prenda.esAcordeATemperatura(30));
    Assertions.assertFalse(prenda.esAcordeATemperatura(5));
    Assertions.assertFalse(prenda.esAcordeATemperatura(35));
    Assertions.assertTrue(prenda.esAcordeATemperatura(null)); // Si no se especifica temperatura, se considera acorde
  }

  @Test
  void testGuardarropaGenerarSugerencias() {
    Guardarropa guardarropa = new Guardarropa();
    guardarropa.prendasSuperiores = Arrays.asList(
        new Prenda(Prenda.TipoPrenda.CAMISA, new Color("001100"), new Color("001124"), Prenda.Material.POLIESTER, Prenda.Trama.LISA, Formalidad.FORMAL, 10, 30),
        new Prenda(Prenda.TipoPrenda.CAMISETA, new Color("002200"), new Color("002224"), Prenda.Material.ALGODON, Prenda.Trama.RAYADA, Formalidad.INFORMAL, 15, 25)
    );
    guardarropa.prendasInferiores = Arrays.asList(
        new Prenda(Prenda.TipoPrenda.PANTALON, new Color("003300"), new Color("003334"), Prenda.Material.POLIESTER, Prenda.Trama.ACUADROS, Formalidad.FORMAL, 5, 20)
    );
    guardarropa.calzados = Arrays.asList(
        new Prenda(Prenda.TipoPrenda.ZAPATOS, new Color("004400"), new Color("004444"), Prenda.Material.CUERO, Prenda.Trama.CONLUNARES, Formalidad.FORMAL, 0, 40)
    );

    List<Atuendo> sugerencias = guardarropa.generarSugerencias();
    Assertions.assertFalse(sugerencias.isEmpty());
    Assertions.assertEquals(2 * 1 * 1, sugerencias.size()); // 2 superiores * 1 inferior * 1 calzado
  }
}
