/**
 * Name: ALESSANDRO ALLEGRANZI
 * Course: CS-665 Software Designs & Patterns
 * Date: 02/08/2024
 * File Name: Condiment.java
 * Description: Condiment class interface.
 */

package edu.bu.met.cs665.condiments;

/**
 * Interface for condiment classes like milk and sugar.
 */
public interface Condiment {
  /**
   * Grabs the price for the condiment.
   *
   * @return the price for the condiment.
   */
  double getPrice();
}
