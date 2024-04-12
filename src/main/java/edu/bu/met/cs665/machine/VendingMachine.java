/**
 * Name: ALESSANDRO ALLEGRANZI
 * Course: CS-665 Software Designs & Patterns
 * Date: 02/08/2024
 * File Name: VendingMachine.java
 * Description: Interface for a vending machine.
 */

package edu.bu.met.cs665.machine;

/**
 * Interface for vending machines. Could be food or beverage vending machines.
 */
public interface VendingMachine {
  /**
   * Takes an order from a customer.
   */
  void registerOrder();

  /**
   * Calculates the order total by adding in selections.
   *
   * @return the total for the order.
   */
  double calculateOrderTotal();

  /**
   * Prepares the order for the client.
   */
  void prepareOrder();
}
