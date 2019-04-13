package com.factory;

public class CarMercedesFactory implements CarFactory {

    @Override
    public Car getCar() {
        return CarMercedes.getInstance();
    }
}
