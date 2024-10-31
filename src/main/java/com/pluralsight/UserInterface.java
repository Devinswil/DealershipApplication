package com.pluralsight;

import java.util.List;
import java.util.Scanner;

public class UserInterface {
    private Dealership dealership;

    public UserInterface() {

    }


    public void display() {
        init();
        Scanner scanner = new Scanner(System.in);
        boolean running = true;
        while (running) {
            System.out.println("Welcome to WeRich Exotic Cars");
            System.out.println("Choose an option");
            System.out.println("1) Search within price range.");
            System.out.println("2) Search within make and model");
            System.out.println("3) Search within year range");
            System.out.println("4) Search within certain color");
            System.out.println("5) Search within a certain mileage");
            System.out.println("6) Search within a certain vehicle type");
            System.out.println("7) Search all vehicles");
            System.out.println("8) Add vehicle");
            System.out.println("9) Remove vehicle");
            System.out.println("X) Exit");

            String input = scanner.nextLine().trim();

            switch (input.toLowerCase()) {
                case "1":
                    processGetByPriceRequest(scanner);
                    break;
                case "2":
                    processGetByMakeModelRequest(scanner);
                    break;
                case "3":
                    processGetByYearRequest(scanner);
                    break;
                case "4":
                    processGetByColorRequest(scanner);
                    break;
                case "5":
                    processGetByMileageRequest(scanner);
                    break;
                case "6":
                    processGetByVehicleTypeRequest(scanner);
                    break;
                case "7":
                    processGetAllVehiclesRequest();
                    break;
                case "8":
                    addVehicleRequest(scanner);
                    break;
                case "9":
                    removeVehicleRequest(scanner);
                    break;
                case "X":
                    running = false;
                    break;
                default:
                    System.out.println("Invalid option");
                    break;


            }


        }
        scanner.close();
    }

    public void processGetByPriceRequest(Scanner scanner) {
        System.out.println("Minimum price?");
        int min = Integer.parseInt(scanner.nextLine());
        System.out.println("Maximum price?");
        int max = Integer.parseInt(scanner.nextLine());

        List<Vehicle> vehicles = dealership.getVehiclesByPrice(min, max);
        displayVehicles(vehicles);


    }

    public void processGetByMakeModelRequest(Scanner scanner) {
        System.out.println("Make of Vehicle?");
        String make = scanner.nextLine();
        System.out.println("Model of vehicle?");
        String model = scanner.nextLine();

        List<Vehicle> vehicles = dealership.getVehiclesByMakeModel(make, model);
        displayVehicles(vehicles);

    }

    public void processGetByYearRequest(Scanner scanner) {
        System.out.println("Minimum year?");
        int min = Integer.parseInt(scanner.nextLine());
        System.out.println("Max year?");
        int max = Integer.parseInt(scanner.nextLine());

        List<Vehicle> vehicles = dealership.getVehiclesByYear(min, max);
        displayVehicles(vehicles);
    }

    public void processGetByColorRequest(Scanner scanner) {
        System.out.println("What color are you looking for?");
        String color = scanner.nextLine();

        List<Vehicle> vehicles = dealership.getVehiclesByColor(color);
        displayVehicles(vehicles);

    }

    public void processGetByMileageRequest(Scanner scanner) {
        System.out.println("Minimum Mileage?");
        double min = Double.parseDouble(scanner.nextLine());
        System.out.println("Maximum Mileage?");
        double max = Double.parseDouble(scanner.nextLine());

        List<Vehicle> vehicles = dealership.getVehiclesByMileage(min, max);
        displayVehicles(vehicles);

    }

    public void processGetByVehicleTypeRequest(Scanner scanner) {
        System.out.println("Type of Car?");
        String vehicleType = scanner.nextLine();

        List<Vehicle> vehicles = dealership.getVehiclesByType(vehicleType);
        displayVehicles(vehicles);


    }

    public void processGetAllVehiclesRequest() {
        List<Vehicle> allVehicles = dealership.getAllVehicles();
        displayVehicles(allVehicles);
    }

    public void addVehicleRequest(Scanner scanner) {
        System.out.println("What is the Vin number of the vehicle?");
        int vin = Integer.parseInt(scanner.nextLine());
        System.out.println("What is the year of the vehicle?");
        int year = Integer.parseInt(scanner.nextLine());
        System.out.println("What is the make of the vehicle?");
        String make = scanner.nextLine();
        System.out.println("What is the model of the vehicle?");
        String model = scanner.nextLine();
        System.out.println("What is the type of the vehicle?");
        String vehicleType = scanner.nextLine();
        System.out.println("What is the color of the Vehicle?");
        String color = scanner.nextLine();
        System.out.println("What is the odometer reading?");
        int odometer = Integer.parseInt(scanner.nextLine());
        System.out.println("What is the price of the vehicle");
        double price = Double.parseDouble(scanner.nextLine());
        Vehicle addVehicle = new Vehicle(vin, year, make, model, vehicleType, color, odometer, price);
        dealership.addVehicle(addVehicle);
        DealershipFileManager dealershipFileManager = new DealershipFileManager();
        dealershipFileManager.saveDealership(dealership);
        System.out.println("Vehicle has been added!");

    }

    public void removeVehicleRequest(Scanner scanner) {
        System.out.println("What is the VIN number of the vehicle you would like to remove?");
        int vin = Integer.parseInt(scanner.nextLine());
        Vehicle removeVeh = null;

        for (Vehicle vehicle : dealership.getAllVehicles()) {
            if (vehicle.getVin() == vin) {
                removeVeh = vehicle;
                break;
            }
        }

        if (removeVeh != null) {
            dealership.removeVehicle(removeVeh);
            System.out.println("Vehicle has been removed!");
        } else {
            System.out.println("No vehicle found with VIN: " + vin);
        }

        DealershipFileManager dealershipFileManager = new DealershipFileManager();
        dealershipFileManager.saveDealership(dealership);
    }
    private void init() {
        DealershipFileManager dealershipManager = new DealershipFileManager();
        dealership = dealershipManager.getDealership();


    }

    private void displayVehicles(List<Vehicle> vehicles) {
        for (Vehicle vehicle : vehicles) {
            System.out.println(vehicle);

        }


    }

}
