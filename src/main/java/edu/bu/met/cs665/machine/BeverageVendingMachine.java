/**
 * Name: ALESSANDRO ALLEGRANZI
 * Course: CS-665 Software Designs & Patterns
 * Date: 02/08/2024
 * File Name: BeverageVendingMachine.java
 * Description: Clas representing a beverage vending machine.
 */

package edu.bu.met.cs665.machine;

import edu.bu.met.cs665.FullyAutomatedBeverageMachineConstants;
import edu.bu.met.cs665.beverage.Americano;
import edu.bu.met.cs665.beverage.Beverage;
import edu.bu.met.cs665.beverage.BlackTea;
import edu.bu.met.cs665.beverage.Espresso;
import edu.bu.met.cs665.beverage.GreenTea;
import edu.bu.met.cs665.beverage.LatteMacchiato;
import edu.bu.met.cs665.beverage.YellowTea;
import edu.bu.met.cs665.condiments.Condiment;
import edu.bu.met.cs665.condiments.Milk;
import edu.bu.met.cs665.condiments.Sugar;
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
   * Takes an order from a customer for a beverage.
   */
  public void registerOrder() {
    String order = "";

    do {
      System.out.println(FullyAutomatedBeverageMachineConstants.COFFEE_OR_TEA);
      order = inputScanner.nextLine();
    } while (!order.equalsIgnoreCase("Coffee") && !order.equalsIgnoreCase("Tea"));

    // Setting up switch statements based on user input to set the right kind of
    // beverage as the beverage variable.
    if (order.equalsIgnoreCase("tea")) {
      System.out.println(FullyAutomatedBeverageMachineConstants.TEA_OPTIONS);
      String teaChoice = inputScanner.nextLine();

      switch (teaChoice.toLowerCase()) {
        case "black tea":
          selectedBeverage = new BlackTea();
          break;
        case "green tea":
          selectedBeverage = new GreenTea();
          break;
        case "yellow tea":
          selectedBeverage = new YellowTea();
          break;
        default:
          System.out.println(FullyAutomatedBeverageMachineConstants.TEA_ERROR);
          selectedBeverage = new BlackTea();
          break;
      }
    } else if (order.equalsIgnoreCase("coffee")) {
      System.out.println(FullyAutomatedBeverageMachineConstants.COFFEE_OPTIONS);
      String coffeeChoice = inputScanner.nextLine();

      switch (coffeeChoice.toLowerCase()) {
        case "americano":
          selectedBeverage = new Americano();
          break;
        case "espresso":
          selectedBeverage = new Espresso();
          break;
        case "latte macchiato":
          selectedBeverage = new LatteMacchiato();
          break;
        default:
          System.out.println(FullyAutomatedBeverageMachineConstants.COFFEE_ERROR);
          selectedBeverage = new Espresso();
          break;
      }
    }

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
   * Adds condiments to the list of condiments. 6 max condiments, 3 max each of milk and sugar.
   */
  public void addCondiments(String type, int amount) {
    // Checking if we already have the max 6 condiments allowed.
    if (condiments.size() == 6) {
      return;
    }

    int limit = Math.min(amount, 3);
    if (type.equalsIgnoreCase("milk")) {
      for (int i = 0; i < limit; i++) {
        condiments.add(new Milk());
      }
    } else if (type.equalsIgnoreCase("sugar")) {
      for (int i = 0; i < limit; i++) {
        condiments.add(new Sugar());
      }
    }
  }
}
