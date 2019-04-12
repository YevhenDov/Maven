package com.factory;

public class CarRenaultFactory implements CarFactory{

    public Car getCar() {
        return new CarRenault(true);
    }
}
