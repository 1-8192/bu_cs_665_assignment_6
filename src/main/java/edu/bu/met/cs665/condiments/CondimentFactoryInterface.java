package edu.bu.met.cs665.condiments;

public interface CondimentFactoryInterface {
  public Condiment createCondiment(String type) throws IllegalArgumentException;
}
