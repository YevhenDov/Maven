package com.prototype;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@AllArgsConstructor
@ToString
public class Car implements Cloneable {
    private int id;
    private String model;
    private String bodyType;


    @Override
    public Car clone() {
        Car clone = new Car(id, model, bodyType);
        return clone;
    }
}
