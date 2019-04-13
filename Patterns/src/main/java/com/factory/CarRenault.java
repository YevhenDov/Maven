package com.factory;

public class CarRenault implements Car {
    private boolean isOn;

    public CarRenault(boolean isOn) {
        this.isOn = isOn;
        conveyorOn();
    }

    private void conveyorOn() {
        System.out.println("Conveyor is on...");
    }

    @Override
    public void buildCar() {
        System.out.println("Car Renault is building...");
    }
}
