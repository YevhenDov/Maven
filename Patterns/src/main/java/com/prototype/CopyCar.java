package com.prototype;

public class CopyCar {
    public static void main(String[] args) {
        Car car = new Car(1, "Volvo", "Sedan");
        CarFactory carFactory = new CarFactory(car);
        Car copiedCar = carFactory.copyCar();

        System.out.println(car);
        System.out.println(copiedCar);
    }
}
