package com.abstructfactory.allcars;

import com.abstructfactory.Car;

public class VolvoCar implements Car {
    @Override
    public void move() {
        System.out.println("The car is moving...");
    }
}
