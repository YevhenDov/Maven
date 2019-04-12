package com.factory;

public class CarMercedes implements Car {
    private static CarMercedes instance = null;

    private CarMercedes() {
    }

    public static CarMercedes getInstance() {
        if (instance == null) {
            instance = new CarMercedes();
        }
        return instance;
    }

    public void buildCar() {
        System.out.println("Car Mercedes is building...");
    }
}
