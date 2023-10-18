package com.example.carfactory;

import java.time.LocalDateTime;

public class Car extends CarCreator {
    private String brand, model;
    private LocalDateTime productionStarted, manufacturedAt;

    private int engineCapacity;

    private BODY_TYPE body;

    private FUEL fuel;

    private INTERIOR interior;

    private String productionStage = "Produkcja nadwozia...";

    public Car(String brand, String model, int engineCapacity, BODY_TYPE body, FUEL fuel, INTERIOR interior) {
        this.brand = brand;
        this.model = model;
        this.engineCapacity = engineCapacity;
        this.body = body;
        this.fuel = fuel;
        this.interior = interior;

        productionStarted = LocalDateTime.now();
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public LocalDateTime getProductionStarted() {
        return productionStarted;
    }

    public void setProductionStarted(LocalDateTime productionStarted) {
        this.productionStarted = productionStarted;
    }

    public LocalDateTime getManufacturedAt() {
        return manufacturedAt;
    }

    public void setManufacturedAt(LocalDateTime manufacturedAt) {
        this.manufacturedAt = manufacturedAt;
    }

    public int getEngineCapacity() {
        return engineCapacity;
    }

    public void setEngineCapacity(int engineCapacity) {
        this.engineCapacity = engineCapacity;
    }

    public BODY_TYPE getBody() {
        return body;
    }

    public void setBody(BODY_TYPE body) {
        this.body = body;
    }

    public FUEL getFuel() {
        return fuel;
    }

    public void setFuel(FUEL fuel) {
        this.fuel = fuel;
    }

    public INTERIOR getInterior() {
        return interior;
    }

    public void setInterior(INTERIOR interior) {
        this.interior = interior;
    }

    @Override
    public String toString() {
        return "Car{" +
                "brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", productionStarted=" + productionStarted +
                ", manufacturedAt=" + manufacturedAt +
                ", engineCapacity=" + engineCapacity +
                ", body=" + body +
                ", fuel=" + fuel +
                ", interior=" + interior +
                '}';
    }

    public String getProductionStage() {
        return productionStage;
    }

    public void setProductionStage(String productionStage) {
        this.productionStage = productionStage;
    }
}
