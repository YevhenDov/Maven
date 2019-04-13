package com.prototype;

public class CopyCar {
    public static void main(String[] args) {
        Car car = new Car(1, "Volvo", "Sedan");
        CarFactory carFactory = new CarFactory(car);
        Car clonedCar = carFactory.cloneCar();

        System.out.println(car);
        System.out.println(clonedCar);
    }
}
