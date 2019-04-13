package com.factory;

public class CreateCar {
    public static CarFactory createCarByModel(String model) {
        if (model.equalsIgnoreCase("Mercedes")) {
            return new CarMercedesFactory();
        } else if (model.equalsIgnoreCase("Lexus")) {
            return new CarLexusFactory();
        } else if (model.equalsIgnoreCase("Renault")) {
            return new CarRenaultFactory();
        } else {
            throw new RuntimeException(model + " id unknown model.");
        }
    }
}
