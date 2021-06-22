package com.piedaholic.class_design.vehicle;

import java.util.Objects;

public abstract class Vehicle {
    private int noOfWheels;
    private String manufacturingCompany;
    private String model;
    private String registrationNumber;

    public Vehicle() {
    }

    public Vehicle(int noOfWheels, String manufacturingCompany, String model, String registrationNumber) {
        this.noOfWheels = noOfWheels;
        this.manufacturingCompany = manufacturingCompany;
        this.model = model;
        this.registrationNumber = registrationNumber;
    }

    public int getNoOfWheels() {
        return this.noOfWheels;
    }

    public void setNoOfWheels(int noOfWheels) {
        this.noOfWheels = noOfWheels;
    }

    public String getManufacturingCompany() {
        return this.manufacturingCompany;
    }

    public void setManufacturingCompany(String manufacturingCompany) {
        this.manufacturingCompany = manufacturingCompany;
    }

    public String getModel() {
        return this.model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getRegistrationNumber() {
        return this.registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Vehicle)) {
            return false;
        }
        Vehicle vehicle = (Vehicle) o;
        return noOfWheels == vehicle.noOfWheels && Objects.equals(manufacturingCompany, vehicle.manufacturingCompany)
                && Objects.equals(model, vehicle.model)
                && Objects.equals(registrationNumber, vehicle.registrationNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(noOfWheels, manufacturingCompany, model, registrationNumber);
    }

    @Override
    public String toString() {
        return "{" + " noOfWheels='" + getNoOfWheels() + "'" + ", manufacturingCompany='" + getManufacturingCompany()
                + "'" + ", model='" + getModel() + "'" + ", registrationNumber='" + getRegistrationNumber() + "'" + "}";
    }

}
