/**
 * Name: ALESSANDRO ALLEGRANZI
 * Course: CS-665 Software Designs & Patterns
 * Date: 04/18/2024
 * File Name: CondimentFactoryInterface.java
 * Description: Condiment Factory interface.
 */
package edu.bu.met.cs665.condiments;

/**
 * Interface for condiment factories.
 */
public interface CondimentFactoryInterface {
  /**
   * Creates a condiment based on the type.
   * @param type
   * @return Condiment
   * @throws IllegalArgumentException
   */
  public Condiment createCondiment(String type) throws IllegalArgumentException;
}
