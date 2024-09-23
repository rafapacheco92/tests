package com.example;

public class ContaCorrente {
  private String name;
  private double balance;

  public ContaCorrente(String name, double balance) {
    this.name = name;
    this.balance = balance;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public double getBalance() {
    return balance;
  }

  public void setBalance(double balance) {
    this.balance = balance;
  }

  public void deposit(double valor) {
    if (valor > 0) {
      this.balance += valor;
    }
  }

  public boolean saque(double valor) {
    if (valor > 0 && valor <= this.balance) {
      this.balance -= valor;
      return true;
    }
    return false;
  }
}
