package com.prototype;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CarFactory {
    Car car;

    public Car getCar() {
        return car.clone();
    }
}
