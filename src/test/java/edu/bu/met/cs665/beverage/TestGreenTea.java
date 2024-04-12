/**
 * Name: ALESSANDRO ALLEGRANZI
 * Course: CS-665 Software Designs & Patterns
 * Date: 02/08/2024
 * File Name: TestGreenTea.java
 * Description: The test class for Americano coffee.
 */
package edu.bu.met.cs665.beverage;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

/**
 * testing the Green tea class. Only testing this tea class, since testing the others
 * would be a lot of redundancy. And yes, that's a design red flag, but there's a deadline :-)
 */
public class TestGreenTea {

  /**
   * Testing the toString override method.
   */
  @Test
  public void testToString() {
    GreenTea greenTea = new GreenTea();
    assertEquals("Green Tea", greenTea.toString());
  }

  /**
   * Testing the String output from the brewBeverage method.
   */
  @Test
  public void testBrewBeverage() {
    GreenTea greenTea = new GreenTea();
    assertEquals("Steeping your Green Tea. Patience is golden.", greenTea.getBrewMessage());
  }

  /**
   * Testing the price output for Green tea.
   */
  @Test
  public void testGetPrice() {
    GreenTea greenTea = new GreenTea();
    // assertEquals with a double is deprecated since double math is tricky. Adding in a delta as per:
    // https://stackoverflow.com/questions/5939788/junit-assertequalsdouble-expected-double-actual-double-epsilon
    assertEquals(2.0, greenTea.getPrice(), 0.01);
  }
}
