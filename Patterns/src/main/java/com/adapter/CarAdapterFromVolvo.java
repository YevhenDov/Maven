package com.adapter;

public class CarAdapterFromVolvo extends Volvo implements Car {

    @Override
    public void move() {
        volvoMove();
    }
}
