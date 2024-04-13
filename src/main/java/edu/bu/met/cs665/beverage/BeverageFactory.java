/**
 * Name: ALESSANDRO ALLEGRANZI
 * Course: CS-665 Software Designs & Patterns
 * Date: 04/18/2024
 * File Name: BeverageFactory.java
 * Description: Beverage Factory concrete class.
 */
package edu.bu.met.cs665.beverage;

/**
 * Beverage Factory concrete class.

 */
public class BeverageFactory implements BeverageFactoryInterface {

  /**
   * Creates a beverage based on the type.
   * @param type
   * @return Beverage
   * @throws IllegalArgumentException
   */
  @Override
  public Beverage createBeverage(String type) throws IllegalArgumentException {
    switch (type.toLowerCase()) {
      case "black tea":
        return new BlackTea();
      case "green tea":
        return new GreenTea();
      case "yellow tea":
        return new YellowTea();
      case "americano":
        return new Americano();
      case "espresso":
        return new Espresso();
      case "latte macchiato":
        return new LatteMacchiato();
      default:
        throw new IllegalArgumentException("Invalid beverage type: " + type);
    }
  }
}
