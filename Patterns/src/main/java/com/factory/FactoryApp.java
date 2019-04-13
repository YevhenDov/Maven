package com.factory;

public class FactoryApp {
    public static void main(String[] args) {
        CarFactory carFactory = CreateCar.createCarByModel("Renault");
        Car car = carFactory.getCar();
        car.buildCar();
    }
}
