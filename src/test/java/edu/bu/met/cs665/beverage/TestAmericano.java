/**
 * Name: ALESSANDRO ALLEGRANZI
 * Course: CS-665 Software Designs & Patterns
 * Date: 02/08/2024
 * File Name: TestAmericano.java
 * Description: The test class for Americano coffee.
 */
package edu.bu.met.cs665.beverage;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

/**
 * testing the Americano coffee class. Only testing this coffee class, since testing the others
 * would be a lot of redundancy. And yes, that's a design red flag, but there's a deadline :-)
 */
public class TestAmericano {

  /**
   * Testing the toString override method.
   */
  @Test
  public void testToString() {
    Americano americano = new Americano();
    assertEquals("Americano", americano.toString());
  }

  /**
   * Testing the String output from the brewBeverage method.
   */
  @Test
  public void testBrewBeverage() {
    Americano americano = new Americano();
    assertEquals("Pulling your Americano coffee. Enjoy the aroma", americano.getBrewMessage());
  }

  /**
   * Testing the price output for Americano coffee.
   */
  @Test
  public void testGetPrice() {
    Americano americano = new Americano();
    // assertEquals with a double is deprecated since double math is tricky. Adding in a delta as per:
    // https://stackoverflow.com/questions/5939788/junit-assertequalsdouble-expected-double-actual-double-epsilon
    assertEquals(2.0, americano.getPrice(), 0.01);
  }
}
