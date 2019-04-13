package com.factory;

public class CarLexus implements Car {
    private String engineType;
    private String bodyType;

    public static class Builder {
        private CarLexus carLexus;

        public Builder() {
            carLexus = new CarLexus();
        }

        public Builder setEngineType(String engineType) {
            carLexus.engineType = engineType;
            return this;
        }

        public Builder setBodyType(String bodyType) {
            carLexus.bodyType = bodyType;
            return this;
        }

        public CarLexus build() {
            return carLexus;
        }

    }

    @Override
    public void buildCar() {
        System.out.println("Car Lexus is building...");
    }
}
