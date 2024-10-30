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
                    processGetByPriceRequest();
                    break;
                case "2":
                    processGetByMakeModelRequest();
                    break;
                case "3":
                    processGetByYearRequest();
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

    public void processGetByPriceRequest() {
    }

    public void processGetByMakeModelRequest() {
    }

    public void processGetByYearRequest() {
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
