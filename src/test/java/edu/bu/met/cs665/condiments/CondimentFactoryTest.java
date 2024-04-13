package edu.bu.met.cs665.condiments;

import org.junit.Test;

import static org.junit.Assert.*;

public class CondimentFactoryTest {

  private final CondimentFactory factory = new CondimentFactory();

  @Test
  public void testCreateMilk() {
    Condiment condiment = factory.createCondiment("milk");
    assertTrue(condiment instanceof Milk);
  }

  @Test
  public void testCreateSugar() {
    Condiment condiment = factory.createCondiment("sugar");
    assertTrue(condiment instanceof Sugar);
  }

  @Test
  public void testCreateInvalidCondiment() {
    assertThrows(IllegalArgumentException.class, () -> factory.createCondiment("invalid"));
  }
}