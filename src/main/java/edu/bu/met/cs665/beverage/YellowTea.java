/**
 * Name: ALESSANDRO ALLEGRANZI
 * Course: CS-665 Software Designs & Patterns
 * Date: 02/08/2024
 * File Name: YellowTea.java
 * Description: Class representing a yellow tea.
 */

package edu.bu.met.cs665.beverage;

/**
 * A class representing Yellow Tea. It is a great tea.
 * It extends the Tea Beverage superclass, which implementes the Beverage Interface.
 */
public class YellowTea extends Beverage {
  /*
   * Public constructor for the class. Instantiating the brewMethod class and type.
   */
  public YellowTea() {
    type = "Yellow Tea";
    brewMethod = new SteepTea();
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

