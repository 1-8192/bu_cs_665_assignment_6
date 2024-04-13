/**
 * Name: ALESSANDRO ALLEGRANZI
 * Course: CS-665 Software Designs & Patterns
 * Date: 04/18/2024
 * File Name: BeverageFactoryInterface.java
 * Description: Beverage Factory interface.
 */
package edu.bu.met.cs665.beverage;

/**
 * Interface for beverage factories.
 */
public interface BeverageFactoryInterface {
  /**
   *
   * @param type
   * @return Beverage
   * @throws IllegalArgumentException
   */
  Beverage createBeverage(String type) throws IllegalArgumentException;
}
