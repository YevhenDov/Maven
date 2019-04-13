package com.prototype;

public class CopyCar {
    public static void main(String[] args) {
        Car car = new Car(1, "Volvo", "Sedan");
        CarFactory carFactory = new CarFactory(car);
        Car car1 = carFactory.getCar();

        System.out.println(car + ", Car hashCode: " + car.hashCode());
        System.out.println(car1 + ", Car hashCode: " + car1.hashCode());
    }
}
