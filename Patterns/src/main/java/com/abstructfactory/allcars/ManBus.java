package com.abstructfactory.allcars;

import com.abstructfactory.Bus;

public class ManBus implements Bus {
    @Override
    public void move() {
        System.out.println("The bus took the route...");
    }
}
