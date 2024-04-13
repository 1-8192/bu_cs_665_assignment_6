package edu.bu.met.cs665.condiments;

public class CondimentFactory implements CondimentFactoryInterface {

  /**
   * Creates a condiment object based on the type of condiment requested.
   *
   * @param type the type of condiment to create.
   * @return the condiment object.
   */
  public Condiment createCondiment(String type) {
    if (type.equals("milk")) {
      return new Milk();
    } else if (type.equals("sugar")) {
      return new Sugar();
    } else {
      throw new IllegalArgumentException("Invalid condiment type: " + type);
    }
  }
}
