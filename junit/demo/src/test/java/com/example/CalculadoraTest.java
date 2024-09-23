package com.example;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class CalculadoraTest {
  @Test
  public void testSoma() {
    Calculadora calc = new Calculadora();
    int resultado = calc.soma(2, 3);
    assertEquals(5, resultado);
  }

  @Test
  public void testSubtracao() {
    Calculadora calc = new Calculadora();
    int resultado = calc.sub(3, 1);
    assertEquals(2, resultado);
  }

  @Test
  public void testMult() {
    Calculadora calc = new Calculadora();
    int resultado = calc.mult(3, 2);
    assertEquals(6, resultado);
  }

  @Test
  public void testDiv() {
    Calculadora calc = new Calculadora();
    int resultado = calc.div(4, 2);
    assertEquals(2, resultado);
  }
}
