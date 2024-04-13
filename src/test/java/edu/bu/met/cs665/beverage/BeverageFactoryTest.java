package edu.bu.met.cs665.beverage;

import org.junit.Test;

import static org.junit.Assert.*;

public class BeverageFactoryTest {

  private final BeverageFactoryInterface beverageFactory = new BeverageFactory();

  @Test
  public void testCreateBlackTea() {
    Beverage beverage = beverageFactory.createBeverage("black tea");
    assertTrue(beverage instanceof BlackTea);
  }

  @Test
  public void testCreateGreenTea() {
    Beverage beverage = beverageFactory.createBeverage("green tea");
    assertTrue(beverage instanceof GreenTea);
  }

  @Test
  public void testCreateYellowTea() {
    Beverage beverage = beverageFactory.createBeverage("yellow tea");
    assertTrue(beverage instanceof YellowTea);
  }

  @Test
  public void testCreateAmericano() {
    Beverage beverage = beverageFactory.createBeverage("americano");
    assertTrue(beverage instanceof Americano);
  }

  @Test
  public void testCreateEspresso() {
    Beverage beverage = beverageFactory.createBeverage("espresso");
    assertTrue(beverage instanceof Espresso);
  }

  @Test
  public void testCreateLatteMacchiato() {
    Beverage beverage = beverageFactory.createBeverage("latte macchiato");
    assertTrue(beverage instanceof LatteMacchiato);
  }

  @Test
  public void testCreateInvalidBeverage() {
    assertThrows(IllegalArgumentException.class, () -> beverageFactory.createBeverage("invalid beverage"));
  }
}
