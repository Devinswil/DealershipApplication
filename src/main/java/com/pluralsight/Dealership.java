package com.pluralsight;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Dealership {

    private String name;
    private String Address;
    private String phone;

    private ArrayList<Vehicle> inventory;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Dealership(String name, String address, String phone) {
        this.name = name;
        Address = address;
        this.phone = phone;
        this.inventory = new ArrayList<>();
    }

    public List<Vehicle> getVehiclesByPrice(int min, int max) {
        List<Vehicle> matchingResult = new ArrayList<>();
        for (Vehicle vehicle : inventory) {
            double price = vehicle.getPrice();
            if (price >= min && price <= max) {

                matchingResult.add(vehicle);
            }

        }

        return matchingResult;
    }

    public List<Vehicle> getVehiclesByMakeModel(String make, String model) {
        List<Vehicle> matchingResult = new ArrayList<>();
        for (Vehicle vehicle : inventory) {
            if (vehicle.getMake().equalsIgnoreCase(make) && vehicle.getModel().equalsIgnoreCase(model)) {
                matchingResult.add(vehicle);

            }
        }
        return matchingResult;
    }

    public List<Vehicle> getVehiclesByYear(int min, int max) {
        List<Vehicle> matchingResult = new ArrayList<>();
        for (Vehicle vehicle : inventory) {
            if (vehicle.getYear() >= min && vehicle.getYear() <= max) {
                matchingResult.add(vehicle);


            }
        }
            return matchingResult;
        }

        public List<Vehicle> getVehiclesByColor (String color){
            List<Vehicle> matchingResult = new ArrayList<>();
            for (Vehicle vehicle : inventory) {
                if (vehicle.getColor().equalsIgnoreCase(color)) {
                    matchingResult.add(vehicle);

                }
            }
            return matchingResult;
        }

        public List<Vehicle> getVehiclesByMileage ( double min, double max){
            List<Vehicle> matchingResult = new ArrayList<>();
            for (Vehicle vehicle : inventory) {
                if (vehicle.getOdometer()>=min && vehicle.getOdometer()<=max){
                    matchingResult.add(vehicle);
                }


            }
            return matchingResult;
        }

        public List<Vehicle> getVehiclesByType (String vehicleType){
            List<Vehicle> matchingResult = new ArrayList<>();
            for (Vehicle vehicle : inventory) {
                if(vehicle.getVehicleType().equalsIgnoreCase(vehicleType)){
                    matchingResult.add(vehicle);
                }
            }
            return matchingResult;
        }

        public List<Vehicle> getAllVehicles () {

            return inventory;
        }

        public void addVehicle (Vehicle vehicle){
            inventory.add(vehicle);


        }


        public void removeVehicle (Vehicle vehicle){
        inventory.remove(vehicle);

        }

        @Override
        public String toString () {
            return name + '\'' +
                    ", Address='" + Address + '\'' +
                    ", phone='" + phone;
        }
    }
