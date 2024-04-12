/**
 * Name: ALESSANDRO ALLEGRANZI
 * Course: CS-665 Software Designs & Patterns
 * Date: 02/08/2024
 * File Name: Beverage.java
 * Description: The beverage abstract class to be extended by different types of coffee and tea.
 */

package edu.bu.met.cs665.beverage;

/**
 * Main Abstract super class for coffee drinks.
 */
public abstract class Beverage {

  /**
   * The BrewMethod implementation.
   */
  protected BrewMethod brewMethod;

  /**
   * The type of beverage, e.g - "espresso"
   */
  protected String type = "";

  /**
   * Price for a coffee drink.
   */
  private double price = 2.00;

  /**
   * Gets the price for the drink.
   *
   * @return the price of the coffee drink.
   */
  public double getPrice() {
    return price;
  }

  /**
   * Gets the brew message for the drink.
   *
   * @return the brew message string.
   */
  public String getBrewMessage() {
    return brewMethod.brewBeverage(type);
  }
}
