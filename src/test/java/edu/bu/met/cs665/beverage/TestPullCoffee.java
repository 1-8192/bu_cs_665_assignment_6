/**
 * Name: ALESSANDRO ALLEGRANZI
 * Course: CS-665 Software Designs & Patterns
 * Date: 02/08/2024
 * File Name: TestPullCoffee.java
 * Description: The test class for PullCoffee.
 */
package edu.bu.met.cs665.beverage;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

/**
 * Suite of tests for PullCoffee.
 */
public class TestPullCoffee {

  /**
   * Testing the String output from the brewBeverage method.
   */
  @Test
  public void testBrewBeverage() {
    PullCoffee pullCoffee = new PullCoffee();

    // Testing with 2 different types. Simple method, so just testing that string is
    // interpolated.
    String result = pullCoffee.brewBeverage("Espresso");
    assertEquals("Pulling your Espresso coffee. Enjoy the aroma", result);

    result = pullCoffee.brewBeverage("Latte Macchiato");
    assertEquals("Pulling your Latte Macchiato coffee. Enjoy the aroma", result);

  }
}
