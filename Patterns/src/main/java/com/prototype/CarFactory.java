package com.prototype;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CarFactory {
    Car car;

    Car cloneCar() {
        return (Car) car.clone();
    }
}
