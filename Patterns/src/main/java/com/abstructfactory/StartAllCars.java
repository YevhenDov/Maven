package com.abstructfactory;

import com.abstructfactory.allcars.CarsFactory;

public class StartAllCars {
    public static void main(String[] args) {
        GetAllCars getAllCars = new CarsFactory();

        Car car = getAllCars.getCar();
        Bus bus = getAllCars.getBus();
        Truck truck = getAllCars.getTruck();

        car.move();
        bus.move();
        truck.load();
    }
}
