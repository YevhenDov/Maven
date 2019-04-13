package com.factory;

public class CreateCar {
    private static final String MERCEDES = "Mercedes";
    private static final String LEXUS = "Lexus";
    private static final String RENAULT = "Renault";

    public static CarFactory createCarByModel(String model) {
        if (MERCEDES.equalsIgnoreCase(model)) {
            return new CarMercedesFactory();
        } else if (LEXUS.equalsIgnoreCase(model)) {
            return new CarLexusFactory();
        } else if (RENAULT.equalsIgnoreCase(model)) {
            return new CarRenaultFactory();
        } else {
            throw new RuntimeException(model + " id unknown model.");
        }
    }
}
