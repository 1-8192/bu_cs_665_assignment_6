/**
 * Name: ALESSANDRO ALLEGRANZI
 * Course: CS-665 Software Designs & Patterns
 * Date: 04/18/2024
 * File Name: CondimentFactory.java
 * Description: Condiment Factory concrete class.
 */
package edu.bu.met.cs665.condiments;

/**
 * Concrete Factory class for creating condiments.
 */
public class CondimentFactory implements CondimentFactoryInterface {

  /**
   * Creates a condiment object based on the type of condiment requested.
   *
   * @param type the type of condiment to create.
   * @return the condiment object.
   * @throws IllegalArgumentException if the type is not valid.
   */
  public Condiment createCondiment(String type) throws IllegalArgumentException{
    if (type.equals("milk")) {
      return new Milk();
    } else if (type.equals("sugar")) {
      return new Sugar();
    } else {
      throw new IllegalArgumentException("Invalid condiment type: " + type);
    }
  }
}
