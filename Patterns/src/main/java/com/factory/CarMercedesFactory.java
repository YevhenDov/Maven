package com.factory;

public class CarMercedesFactory implements CarFactory {
    public Car getCar() {
        return CarMercedes.getInstance();
    }
}
