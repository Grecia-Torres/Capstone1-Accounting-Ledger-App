package com.pluralsight.capstone1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import static com.pluralsight.capstone1.AccountingLedgerApp.homeScreen;
import static com.pluralsight.capstone1.Reports.displayReports;

public class Ledger {
    public static void displayLedger() {
        //function of this try statement is used to wrap around code that may throw an exception
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Please choose an option from the options below:");
            System.out.println("A) All");
            System.out.println("D) Deposits");
            System.out.println("P) Payments");
            System.out.println("R) Reports");
            System.out.println("H) Home");
            String ledgerOptions = scanner.nextLine();

            // Used a switch statement to give user different options to choose from in the Ledger Screen
            switch (ledgerOptions) {
                // If user enters A all the entries from transactions csv file will output
                case "A":
                    System.out.println("You chose option A ");
                    System.out.println("Below are ALL the transactions that have been made:\n");
                    allLedgerEntries();
                    break;
                    // If user enters D then only the deposits from csv file will output
                case "D":
                    System.out.println("D) Deposits: ");
                    depositEntries();
                    break;
                    // If user enters P only payments will output
                case "P":
                    System.out.println("P) Payments: ");
                    paymentEntries();
                    break;
                    // If user enters R then the Reports Screen will appear
                case "R":
                    System.out.println("              REPORTS");
                    displayReports();
                    break;
                    // If user enters H then user will be directed to Home Screen
                case "H":
                    System.out.println("You are being directed back to the HOME SCREEN");
                    homeScreen();
                    break;
                    // User entered an entry that wasn't valid and will be asked to pick valid option
                default:
                    System.out.println("Not a valid entry");
                    displayLedger();
            }
            // catch statement is used to handles the exception thrown in previous try block
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    // This method reads from transaction file and outputs all entries
    public static void allLedgerEntries() {
        try {
            FileReader fileReader = new FileReader("transactions.csv");

            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String allEntries;

            while ((allEntries = bufferedReader.readLine()) != null) {
                System.out.println(allEntries);
            }
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    // reads from transactions csv file but only prints deposits
    public static void depositEntries() {
        // This array list stores the column/rows of the csv file
        ArrayList<String[]> depositList = new ArrayList<>();
        String line;

        try {
            // reads transaction csv file
            FileReader fileReader = new FileReader("transactions.csv");
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            bufferedReader.readLine();
            // reads each line of transactions csv file
            while ((line = bufferedReader.readLine()) != null) {
                // splits the entries by |
                String[] entries = line.split("\\|");
                depositList.add(entries);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (String[] amountEntry : depositList) {
            // If the amount entry is in one of the four columns the code will execute
            if (amountEntry.length > 4) {

                try {
                    // looks and reads column 4
                    double amount = Double.parseDouble(amountEntry[4]);
                    // if the amount is greater than 0 (positive number) it will print
                    if (amount > 0) {
                        System.out.println(amount);
                    }

                } catch (NumberFormatException e) {
                    System.out.println("error");
                }
            }
        }
    }
    // this method reads from csv file and prints only the payments
    public static void paymentEntries() {
        ArrayList<String[]> paymentList = new ArrayList<>();
        String line;

        try {
            FileReader fileReader = new FileReader("transactions.csv");
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            bufferedReader.readLine();
            {

            }
            while ((line = bufferedReader.readLine()) != null) {

                String[] entries = line.split("\\|");

                paymentList.add(entries);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (String[] amountEntry : paymentList) {
            try {
                double amount = Double.parseDouble(amountEntry[4]);
                // if entry amount is less than 0 (negative number) it will print
                if (amount < 0) {
                    System.out.println(amount);
                }

            } catch (NumberFormatException e) {
                System.out.println("error");
            }
        }
    }
}









