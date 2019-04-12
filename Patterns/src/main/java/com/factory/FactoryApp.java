package com.factory;

public class FactoryApp {
    public static void main(String[] args) {
        CarFactory carFactory = createCarByModel("Renault");
        Car car = carFactory.getCar();
        car.buildCar();
    }

    private static CarFactory createCarByModel(String model) {
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
