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
                    processGetByColorRequest();
                    break;
                case "5":
                    processGetByMileageRequest();
                    break;
                case "6":
                    processGetByVehicleTypeRequest();
                    break;
                case "7":
                    processGetAllVehiclesRequest();
                    break;
                case "8":
                    addVehicleRequest();
                    break;
                case "9":
                    removeVehicleRequest();
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

        List<Vehicle> vehicles= dealership.getVehiclesByPrice(min,max);
        displayVehicles(vehicles);


    }

    public void processGetByMakeModelRequest(Scanner scanner) {
        System.out.println("Make of Vehicle?");
        String make = scanner.nextLine();
        System.out.println("Model of vehicle?");
        String model = scanner.nextLine();

        List<Vehicle> vehicles= dealership.getVehiclesByMakeModel(make,model);
        displayVehicles(vehicles);

    }

    public void processGetByYearRequest(Scanner scanner) {
        System.out.println("Minimum year?");
       int minYear= Integer.parseInt(scanner.nextLine());
        System.out.println("Max year?");
        int maxYear = Integer.parseInt(scanner.nextLine());

        List<Vehicle> vehicles= dealership.getVehiclesByPrice(minYear,maxYear);
        displayVehicles(vehicles);
    }

    public void processGetByColorRequest() {
    }

    public void processGetByMileageRequest() {
    }

    public void processGetByVehicleTypeRequest() {


    }

    public void processGetAllVehiclesRequest() {
        List<Vehicle> allVehicles= dealership.getAllVehicles();
        displayVehicles(allVehicles);
    }

    public void addVehicleRequest() {
    }

    public void removeVehicleRequest() {
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
