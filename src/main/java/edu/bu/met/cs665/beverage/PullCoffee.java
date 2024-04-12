/**
 * Name: ALESSANDRO ALLEGRANZI
 * Course: CS-665 Software Designs & Patterns
 * Date: 02/08/2024
 * File Name: PullCoffee.java
 * Description: Class representing a brew method for making cofee.
 */

package edu.bu.met.cs665.beverage;

/**
 * Pull Coffee represents the brewing method for coffee.
 */
public class PullCoffee implements BrewMethod {

  /**
   * Prints out an informative message about how the coffee is being brewed.
   *
   * @return message string.
   */
  public String brewBeverage(String coffeeType) {
    return "Pulling your " + coffeeType + " coffee. Enjoy the aroma";
  }
}
