/**
 * Name: ALESSANDRO ALLEGRANZI
 * Course: CS-665 Software Designs & Patterns
 * Date: 02/08/2024
 * File Name: LatteMacchiato.java
 * Description: Class representing a Latte Macchiato coffee.
 */

package edu.bu.met.cs665.beverage;

/**
 * A class representing a Latte Macchiato coffee. It is a longer pull and weaker than espresso
 * and includes milk. It extends the coffee Beverage superclass, which implementes the
 * Beverage Interface.
 */
public class LatteMacchiato extends Beverage {
  /*
   * Public constructor for the class. Instantiating the brewMethod class and type.
   */
  public LatteMacchiato() {
    type = "Latte Macchiato";
    brewMethod = new PullCoffee();
  }

  /**
   * Overriding the class' toString method to print something more readable.
   *
   * @return the string value of the class name.
   */
  @Override
  public String toString() {
    return type;
  }
}
