package com.prototype;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Car implements Copyable {
    private int id;
    private String model;
    private String bodyType;


    @Override
    public Object copy() {
        Car copy = new Car(id, model, bodyType);
        return copy;
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
