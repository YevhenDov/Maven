package com.factory;

public class CarLexusFactory implements CarFactory {
    public Car getCar() {
        return new CarLexus();
    }
}
