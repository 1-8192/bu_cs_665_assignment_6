/**
 * Name: ALESSANDRO ALLEGRANZI
 * Course: CS-665 Software Designs & Patterns
 * Date: 02/08/2024
 * File Name: TestSugar.java
 * Description: The test class for the Sugar condiment.
 */
package edu.bu.met.cs665.condiments;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

/**
 * Super simple test class to test that the sugar price is correct.
 */
public class TestSugar {

  /*
   * Only one thing to test in the class.
   */
  @Test
  public void testGetPrice() {
    Sugar sugar = new Sugar();
    // assertEquals with a double is deprecated since double math is tricky. Adding in a delta as per:
    // https://stackoverflow.com/questions/5939788/junit-assertequalsdouble-expected-double-actual-double-epsilon
    assertEquals(0.50, sugar.getPrice(), 0.01);
  }
}
