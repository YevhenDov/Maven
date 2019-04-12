package com.abstructfactory.allcars;

import com.abstructfactory.Truck;

public class ScaniaTruck implements Truck {
    @Override
    public void load() {
        System.out.println("The truck is loading...");
    }
}
