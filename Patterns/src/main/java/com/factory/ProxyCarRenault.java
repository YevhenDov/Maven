package com.factory;

public class ProxyCarRenault implements Car {
    private boolean isOn;
    private CarRenault carRenault;

    public ProxyCarRenault(boolean turnOn) {
        this.isOn = turnOn;
    }

    @Override
    public void buildCar() {
        if (carRenault == null) {
            carRenault = new CarRenault(isOn);
        }
        carRenault.buildCar();
    }
}
