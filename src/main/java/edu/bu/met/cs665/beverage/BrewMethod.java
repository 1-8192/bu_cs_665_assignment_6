/**
 * Name: ALESSANDRO ALLEGRANZI
 * Course: CS-665 Software Designs & Patterns
 * Date: 02/08/2024
 * File Name: BrewMethod.java
 * Description: BrewMethod interface. Used as part of the Strategy design pattern for beverage
 * construciton.
 */

package edu.bu.met.cs665.beverage;

/**
 * Interface class for different brewing methods for beverage types.
 */
public interface BrewMethod {
  /**
   * Basic method used by class that implement the interface. Prints out a drink specific
   * brew message.
   *
   * @param type the type of beverage.
   * @return message string.
   */
  String brewBeverage(String type);
}
