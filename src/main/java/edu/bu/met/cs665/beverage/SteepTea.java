/**
 * Name: ALESSANDRO ALLEGRANZI
 * Course: CS-665 Software Designs & Patterns
 * Date: 02/08/2024
 * File Name: SteepTea.java
 * Description: Class representing a brew method for steeping tea.
 */

package edu.bu.met.cs665.beverage;

/**
 * Class to represent steeping tea.
 */
public class SteepTea implements BrewMethod {

  /**
   * Prints out an informative message about how the tea is being brewed.
   *
   * @return message string.
   */
  public String brewBeverage(String teaType) {
    return "Steeping your " + teaType + ". Patience is golden.";
  }
}
