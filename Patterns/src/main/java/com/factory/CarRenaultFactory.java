package com.factory;

public class CarRenaultFactory implements CarFactory {

    @Override
    public Car getCar() {
        return new CarRenault(true);
    }
}
