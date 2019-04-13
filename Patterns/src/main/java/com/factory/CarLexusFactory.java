package com.factory;

public class CarLexusFactory implements CarFactory {

    @Override
    public Car getCar() {
        return new CarLexus();
    }
}
