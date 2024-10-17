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
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Please choose an option from the options below:");
            System.out.println("A) All");
            System.out.println("D) Deposits");
            System.out.println("P) Payments");
            System.out.println("R) Reports");
            System.out.println("H) Home");
            String ledgerOptions = scanner.nextLine();

            switch (ledgerOptions) {
                case "A":
                    System.out.println("You chose option A ");
                    System.out.println("Below are ALL the transactions that have been made:\n");
                    allLedgerEntries();
                    break;
                case "D":
                    System.out.println("D) Deposits: ");
                    depositEntries();
                    break;
                case "P":
                    System.out.println("P) Payments: ");
                    paymentEntries();
                    break;
                case "R":
                    System.out.println("R) Reports: ");
                    displayReports();
                    break;
                case "H":
                    System.out.println("You are being directed back to the HOME SCREEN");
                    homeScreen();
                    break;
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

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

    public static void depositEntries() {
        ArrayList<String[]> depositList = new ArrayList<>();
        String line;

        try {
            FileReader fileReader = new FileReader("transactions.csv");
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            bufferedReader.readLine();
            while ((line = bufferedReader.readLine()) != null) {
                String[] entries = line.split("\\|");
                depositList.add(entries);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (String[] amountEntry : depositList) {

            if (amountEntry.length > 4) {

                try {
                    double amount = Double.parseDouble(amountEntry[4]);
                    if (amount > 0) {
                        System.out.println(amount);
                    }

                } catch (NumberFormatException e) {
                    System.out.println("error");
                }
            }
        }
    }

    public static void paymentEntries() {
        ArrayList<String[]> paymentList = new ArrayList<>();
        String line;

        try {
            FileReader fileReader = new FileReader("transactions.csv");
            BufferedReader bufferedReader = new BufferedReader(fileReader);
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
                if (amount < 0) {
                    System.out.println(amount);
                }

            } catch (NumberFormatException e) {
                System.out.println("error");
            }
        }
        }
    }









