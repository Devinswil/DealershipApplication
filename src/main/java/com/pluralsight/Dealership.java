package com.pluralsight;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Dealership {

    private String name;
    private String Address;
    private String phone;

    private ArrayList<Vehicle> inventory;


    public Dealership(String name, String address, String phone) {
        this.name = name;
        Address = address;
        this.phone = phone;
        this.inventory = new ArrayList<>();
    }

    public List<Vehicle> getVehiclesByPrice(double min, double max) {
        return getVehiclesByPrice(min, max);
    }

    public List<Vehicle> getVehiclesByMakeModel(String make, String model) {
        return getVehiclesByMakeModel(make, model);
    }

    public List<Vehicle> getVehiclesByYear(double min, double max) {
        return getVehiclesByYear(min, max);
    }

    public List<Vehicle> getVehiclesByColor(String color) {
        return getVehiclesByColor(color);
    }

    public List<Vehicle> getVehiclesByMileage(double min, double max) {
        return getVehiclesByMileage(min, max);
    }

    public List<Vehicle> getVehiclesByType(String vehicleType) {
        return getVehiclesByType(vehicleType);
    }

    public List<Vehicle> getAllVehicles() {
        return getAllVehicles();
    }

    public void addVehicle(Vehicle vehicle) {
        inventory.add(vehicle);


        }


    public void removeVehicle(Vehicle vehicle) {

    }

    @Override
    public String toString() {
        return name + '\'' +
                ", Address='" + Address + '\'' +
                ", phone='" + phone;
    }
}
