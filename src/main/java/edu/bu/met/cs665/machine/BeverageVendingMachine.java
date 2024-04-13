/**
 * Name: ALESSANDRO ALLEGRANZI
 * Course: CS-665 Software Designs & Patterns
 * Date: 02/08/2024
 * File Name: BeverageVendingMachine.java
 * Description: Clas representing a beverage vending machine.
 */

package edu.bu.met.cs665.machine;

import edu.bu.met.cs665.FullyAutomatedBeverageMachineConstants;
import edu.bu.met.cs665.beverage.*;
import edu.bu.met.cs665.condiments.*;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Class representing a beverage vending machine.
 */
public class BeverageVendingMachine implements VendingMachine {
  /**
   * The Beverage.
   */
  protected Beverage selectedBeverage;

  /**
   * Selected Condiments.
   */
  protected ArrayList<Condiment> condiments = new ArrayList<>();

  /**
   * Scanner instance used to record user input.
   */
  protected Scanner inputScanner = new Scanner(System.in);

  /**
   * NEW FOR ASSIGNMENT 6. Changed to use a factory method. Takes an order
   * from a customer for a beverage.
   */
  public void registerOrder() {
    String order = "";
    boolean success = true;
    BeverageFactory beverageFactory = new BeverageFactory();
    do {
      System.out.println(FullyAutomatedBeverageMachineConstants.OPTIONS);
      order = inputScanner.nextLine();
      try {
        // For assignment 6  have replaced a long switch statement with a factory method.
        selectedBeverage = beverageFactory.createBeverage(order.toLowerCase());
      } catch (IllegalArgumentException e) {
        System.out.println(e.getMessage());
        success = false;
      }
    } while (!success);

    System.out.println("Thank you. You have selected " + selectedBeverage.toString());
  }

  /**
   * Prepares the beverage order by adding condiments if necessary.
   */
  public void prepareOrder() {
    int milkCount = 0;
    int sugarCount = 0;

    System.out.println(FullyAutomatedBeverageMachineConstants.CONDIMENT_ASK);
    String input = inputScanner.nextLine();

    if (!input.equalsIgnoreCase("no")) {
      System.out.println(FullyAutomatedBeverageMachineConstants.MILK_QUANTITY);
      milkCount = Integer.valueOf(inputScanner.nextLine());
      // If the customer asks for more than 3 milks, we print an informative message and only add 3.
      if (milkCount > 3) {
        System.out.println(FullyAutomatedBeverageMachineConstants.TOO_MUCH_MILK);
      }
      addCondiments("milk", milkCount);

      // If the customer asks for more than 3 sugars, we print an informative
      // message and only add 3.
      System.out.println(FullyAutomatedBeverageMachineConstants.SUGAR_QUANTITY);
      sugarCount = Integer.valueOf(inputScanner.nextLine());
      if (sugarCount > 3) {
        System.out.println(FullyAutomatedBeverageMachineConstants.TOO_MUCH_SUGAR);
      }
      addCondiments("sugar", sugarCount);

    }

    System.out.println(selectedBeverage.getBrewMessage());
    if (milkCount > 0) {
      System.out.println("Adding in " + Math.min(milkCount, 3) + " milks.");
    }
    if (sugarCount > 0) {
      System.out.println("Adding in " + Math.min(sugarCount, 3) + " sugars.");
    }
  }

  /**
   * Calculates the total for the order including condiments. Returns 0.00 as the price
   * if we encunter an error.
   *
   * @return the total price for the order.
   */
  public double calculateOrderTotal() {
    try {
      // Using a stream here as it's less verbose than a loop.
      return Double.sum(selectedBeverage.getPrice(), condiments.stream()
                  .mapToDouble(Condiment::getPrice).sum());
    } catch (Exception e) {
      System.out.println(FullyAutomatedBeverageMachineConstants.CALCULATION_ERROR);
      return 0.00;
    }
  }

  /**
   * Altered for Assignmnet 6. Adds condiments to the list of condiments.
   * 6 max condiments, 3 max each of milk and sugar.
   */
  public void addCondiments(String type, int amount) {
    // Checking if we already have the max 6 condiments allowed.
    if (condiments.size() == 6) {
      return;
    }

    int limit = Math.min(amount, 3);
    CondimentFactoryInterface condimentFactory = new CondimentFactory();
    // New code for Assignment 6. Using the CondimentFactory to create condiments rather
    // than using conditional logic.
    for (int i =0; i < limit; i++) {
      try {
        condiments.add(condimentFactory.createCondiment(type));
      } catch (IllegalArgumentException e) {
        System.out.println(e.getMessage());
      }
    }
  }
}
