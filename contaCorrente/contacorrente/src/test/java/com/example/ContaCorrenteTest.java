package com.example;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ContaCorrenteTest {

  private ContaCorrente maria;
  private ContaCorrente jose;

  @BeforeEach
  public void setUp() {
    maria = new ContaCorrente("Maria", 200.0);
    jose = new ContaCorrente("Jose", 100.0);
  }

  @Test
  public void testContasCriadas() {
    assertNotNull(jose);
    assertNotNull(maria);
  }

  @Test
  public void testSaldoDiferente() {
    assertNotEquals(maria.getBalance(), jose.getBalance());
  }

  @Test
  public void testSaqueMaria() {
    maria.saque(100);
    assertEquals(maria.getBalance(), jose.getBalance());
  }

  @Test
  public void testDepositoJose() {
    jose.deposit(50);
    assertEquals(jose.getBalance(), maria.getBalance() - 50);
  }

  @Test
  public void testSaqueAcimaSaldo() {
    assertFalse(maria.saque(300));
  }

  @Test
  public void testSaqueDisponivel() {
    assertTrue(maria.saque(50));
  }
}
