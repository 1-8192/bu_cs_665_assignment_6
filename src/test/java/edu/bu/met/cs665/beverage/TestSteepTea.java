/**
 * Name: ALESSANDRO ALLEGRANZI
 * Course: CS-665 Software Designs & Patterns
 * Date: 02/08/2024
 * File Name: TestSteepTea.java
 * Description: The test class for SteepTea.
 */
package edu.bu.met.cs665.beverage;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

/**
 * Suite of tests for SteepTea.
 */
public class TestSteepTea {

  /**
   * Testing the String output from the brewBeverage method.
   */
  @Test
  public void testBrewBeverage() {
    SteepTea steepTea = new SteepTea();

    // Testing with 2 different types. Simple method, so just testing that string is
    // interpolated.
    String result = steepTea.brewBeverage("Black Tea");
    assertEquals("Steeping your Black Tea. Patience is golden.", result);

    result = steepTea.brewBeverage("Yellow Tea");
    assertEquals("Steeping your Yellow Tea. Patience is golden.", result);

  }
}
