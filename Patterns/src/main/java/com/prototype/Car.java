package com.prototype;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Car implements Cloneable {
    private int id;
    private String model;
    private String bodyType;


    @Override
    public Object clone() {
        Car clone = new Car(id, model, bodyType);
        return clone;
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", model='" + model + '\'' +
                ", bodyType='" + bodyType + '\'' +
                '}';
    }
}
