package com.pluralsight;


import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;

public class DealershipFileManager {

    private static final String FILE_NAME = "dealership.csv";
    private static ArrayList<Vehicle>vehicle =new ArrayList<Vehicle>();c
    public static void loadVehicleInventory(){
        try {
            BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME));
            String line;
            while ((line = reader.readLine()) != null) {

                String[] dealershipParts = line.split("\\|");
                if (dealershipParts.length == 3) {




                }
            }


        } catch (Exception e) {
            System.err.println("This file does not exist!");;
        }

    }

}
