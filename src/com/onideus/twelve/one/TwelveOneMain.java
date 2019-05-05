package com.onideus.twelve.one;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class TwelveOneMain {
    private BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public TwelveOneMain() {

    }

    public void run() throws IOException {
        String input = "-1";

        while(!input.equals("0")) {
            System.out.println(String.format("0 - Exit Assignment\n" +
                    "1 - %s", "Run Prime Number Prompt"));

            input = reader.readLine();

            switch(input) {
                case "1":
                    runPrimePrompt();
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

    private void runPrimePrompt() throws IOException {
        String input = "";
        int numInput;

        System.out.println("Prime Number Checker");

        while(!input.equalsIgnoreCase("n")) {
            System.out.print("\nPlease enter an integer between 1 and 5000: ");

            input = reader.readLine();

            try {
                numInput = Integer.parseInt(input);

                if(numInput >= 1 && numInput <= 5000) {
                    PrimeNumber primeNumber = checkPrimeNumber(numInput);

                    if(primeNumber.isPrimeNumber()) {
                        System.out.print(String.format("%d is a prime number.", numInput));
                    } else {
                        System.out.println(String.format("%d is NOT a prime number.", numInput));
                        System.out.print(String.format("It has %d factors: ", primeNumber.getFactorList().size()));
                        for(Integer integer : primeNumber.getFactorList()) {
                            System.out.print(String.format("%d ", integer));
                        }
                    }
                } else {
                    System.out.println("Please only supply an integer between 1 and 5000");
                }
            } catch (NumberFormatException nfe) {
                System.out.println("Please only supply an integer between 1 and 5000");
            }

            boolean decisionMade = false;

            System.out.print("\n");

            while(!decisionMade) {
                System.out.print("\nTry again? (y/n): ");
                input = reader.readLine();

                if(input.equalsIgnoreCase("y") || input.equalsIgnoreCase("n")) {
                    decisionMade = true;
                }
            }
        }

        System.out.println("Bye!");
    }

    private PrimeNumber checkPrimeNumber(int numInput) {
        PrimeNumber primeNumber = new PrimeNumber();
        List<Integer> factors = new ArrayList<>();

        for(int i = 1; i <= numInput; i++) {
            if(numInput % i == 0) {
                factors.add(i);
            }
        }

        primeNumber.setPrimeNumber(factors.size() == 2);
        primeNumber.setFactorList(factors);

        return primeNumber;
    }
}
