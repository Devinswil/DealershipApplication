package com.pluralsight;


import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class DealershipFileManager {

    private static final String FILE_NAME = "dealership.csv";


    public Dealership getDealership() {
        Dealership dealership = null;
        List<Vehicle> vehicles = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;


            if ((line = reader.readLine()) != null) {
                String[] dealershipParts = line.split("\\|");
                if (dealershipParts.length == 3) {
                    String dealershipName = dealershipParts[0];
                    String dealershipAddress = dealershipParts[1];
                    String dealershipPhone = dealershipParts[2];

                    dealership = new Dealership(dealershipName,dealershipAddress,dealershipPhone);
                }
            }

            while ((line = reader.readLine()) != null) {
                String[] vehicleParts = line.split("\\|");
                if (vehicleParts.length == 8) {
                    int vin = Integer.parseInt(vehicleParts[0]);
                    int year = Integer.parseInt(vehicleParts[1]);
                    String make = vehicleParts[2];
                    String model = vehicleParts[3];
                    String vehicleType = vehicleParts[4];
                    String color = vehicleParts[5];
                    int odometer = Integer.parseInt(vehicleParts[6]);
                    double price = Double.parseDouble(vehicleParts[7]);


                    Vehicle vehicle = new Vehicle(vin, year, make, model, vehicleType, color, odometer, price);
                    vehicles.add(vehicle);
                }
            }

            for (Vehicle vehicle : vehicles) {
                dealership.addVehicle(vehicle);


            }

        } catch (Exception e) {
            System.err.println("This file does not exist!");
            e.printStackTrace();
        }


        return dealership;
    }

    public void saveDealership(){}

}

