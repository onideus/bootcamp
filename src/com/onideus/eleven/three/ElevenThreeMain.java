package com.onideus.eleven.three;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.NumberFormat;

public class ElevenThreeMain {
    private BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    NumberFormat currencyFormat = NumberFormat.getCurrencyInstance();

    private double[][] sales = {
            {1540.0, 2010.0, 2450.0, 1845.0},
            {1130.0, 1168.0, 1847.0, 1491.0},
            {1580.0, 2305.0, 2710.0, 1284.0},
            {1105.0, 4102.0, 2391.0, 1576.0}
    };


    public ElevenThreeMain() {
    }

    public void run() throws IOException {
        String input = "-1";

        while(!input.equals("0")) {
            System.out.println(String.format("0 - Exit Assignment\n" +
                    "1 - %s", "Run Sales Report"));

            input = reader.readLine();

            switch(input) {
                case "1":
                    salesReport();
                    break;
                case "0":
                    break;
                default:
                    System.out.println("Input not recognized, please try again");
                    break;
            }

        }

        System.out.println("Exiting Assignment");
    }

    private void salesReport() {
        System.out.println("The Sales Report application \n");

        printFullSales();

        System.out.println("Sales by region:");
        for(int i = 0; i < sales.length; i++) {
            System.out.println(String.format("Region %s: %s", i + 1, currencyFormat.format(getSalesByRegion(i + 1))));
        }

        System.out.print("\n");

        System.out.println("Sales by quarter:");
        for(int i = 0; i < sales[0].length; i++) {
            System.out.println(String.format("Q%s: %s", i + 1, currencyFormat.format(getSalesByQuarter(i + 1))));
        }

        System.out.print("\n");

        System.out.println(String.format("Total sales: %s\n", currencyFormat.format(getTotalSales())));
    }

    private void printFullSales() {
        System.out.println("Region\t\tQ1\t\t\tQ2\t\t\tQ3\t\t\tQ4");
        for(int i = 0; i < sales.length; i++) {
            System.out.print(String.format("%d\t\t\t", i + 1));
            for(int j = 0; j < sales[i].length; j++) {
                System.out.print(String.format("%s\t", currencyFormat.format(sales[i][j])));
            }
            System.out.print("\n");
        }
    }

    private double getSalesByRegion(int region) {
        region = region - 1; // To make the method human usable, we'll pass the region number, but know that the index of that region is actually region # minus 1

        double salesForRegion = 0;

        for(int i = 0; i < sales[region].length; i++) {
            salesForRegion += sales[region][i];
        }

        return salesForRegion;
    }

    private double getSalesByQuarter(int quarter) {
        quarter = quarter - 1; // Again, this is just to make it human usable

        double salesForQuarter = 0;

        for(int i = 0; i < sales.length; i++) {
            salesForQuarter += sales[i][quarter];
        }

        return salesForQuarter;
    }

    // since we have the ability to get the total from all four quarters, let's use it!
    private double getTotalSales() {
        double totalSales = 0;

        for(int i = 1; i < 5; i++) {
            totalSales += getSalesByQuarter(i);
        }

        return totalSales;
    }
}
