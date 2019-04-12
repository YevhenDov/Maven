package com.abstructfactory.allcars;

import com.abstructfactory.Bus;
import com.abstructfactory.Car;
import com.abstructfactory.GetAllCars;
import com.abstructfactory.Truck;

public class CarsFactory implements GetAllCars {
    @Override
    public Car getCar() {
        return new VolvoCar();
    }

    @Override
    public Bus getBus() {
        return new ManBus();
    }

    @Override
    public Truck getTruck() {
        return new ScaniaTruck();
    }
}
