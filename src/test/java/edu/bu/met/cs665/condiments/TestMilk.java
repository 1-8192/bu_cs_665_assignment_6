/**
 * Name: ALESSANDRO ALLEGRANZI
 * Course: CS-665 Software Designs & Patterns
 * Date: 02/08/2024
 * File Name: TestMilk.java
 * Description: The test class for the Milk condiment.
 */
package edu.bu.met.cs665.condiments;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

/**
 * Super simple test class to test that the milk price is correct.
 */
public class TestMilk {

  /*
   * Only one thing to test in the class.
   */
  @Test
  public void testGetPrice() {
    Milk milk = new Milk();
    // assertEquals with a double is deprecated since double math is tricky. Adding in a delta as per:
    // https://stackoverflow.com/questions/5939788/junit-assertequalsdouble-expected-double-actual-double-epsilon
    assertEquals(0.50, milk.getPrice(), 0.01);
  }
}
