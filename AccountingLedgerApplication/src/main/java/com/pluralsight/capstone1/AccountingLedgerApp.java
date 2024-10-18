package com.pluralsight.capstone1;

import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import static com.pluralsight.capstone1.Ledger.*;

public class AccountingLedgerApp {
    public static void main(String[] args) {
        homeScreen();
    }

    public static void homeScreen() {
        Scanner scanner = new Scanner(System.in);

        // Prints out the Home Screen and options to choose from
        System.out.println("                 HOME   ");
        System.out.println("Please choose an option from the following: ");
        System.out.println("D) Add Deposit");
        System.out.println("P) Make Payment");
        System.out.println("L) Ledger");
        System.out.println("X) Exit\n");
        String options = scanner.nextLine();

        // Used a switch statement to give user different options to choose from in the Home Screen
        switch (options) {
            // If user enters D they will be directed to make a deposit
            case "D":
                deposit();
                break;
            // If user enters P they will be prompted to make a payment
            case "P":
                payment(); //takes user to payment method after being chosen
                break;
            // If user enters L they will be directed to Ledger Screen
            case "L":
                System.out.println("                LEDGER MENU");
                displayLedger();
                break;
            // If user enters X they will exit and close the program
            case "X":
                System.out.println("X) Exit: ");
                scanner.close();
                // If user enters an option that isn't one of the cases they will be directed back to make a valid entry
            default:
                System.out.println("Not a valid entry");
                homeScreen();
        }
    }
    // Deposit method that asks user for their deposit information
    public static void deposit() {
        // Creates scanner object to get user input
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please enter deposit details below: ");
        System.out.println("Please enter a description");
        String description = scanner.nextLine(); //reads next line
        System.out.println("Please enter a vendor");
        String vendor = scanner.nextLine();
        System.out.println("Please enter an amount");
        String amount = scanner.nextLine();

        // creates instance for the current date
        LocalDate date = LocalDate.now();
        // creates instance for the current time
        LocalTime time = LocalTime.now();
        // date time formatter is used to format time the way we specifically want
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        String timeFormatted = time.format(formatter);
        String transactionsFile = "transactions.csv";

        // Buffered writer is used to write to transactions csv file
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(transactionsFile, true))) {
            writer.write(date + "|" + timeFormatted + "|" + description + "|" + vendor + "|" + amount);
            writer.newLine();
            System.out.println("Your deposit has been accepted.");
        } catch (IOException e) {
            System.out.println("Error");
        }
        scanner.close();
    }
    // method that prompts user to enter their payment information
    public static void payment() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please enter payment details below: ");
        System.out.println("Please enter a description");
        String description = scanner.nextLine();
        System.out.println("Please enter a vendor");
        String vendor = scanner.nextLine();
        System.out.println("Please enter an amount");
        String amountInput = scanner.nextLine();
        double amount = -Double.parseDouble(amountInput);

        LocalDate date = LocalDate.now();
        LocalTime time = LocalTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        String timeFormatted = time.format(formatter);
        String transactionsFile = "transactions.csv";

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(transactionsFile, true))) {
            writer.write(date + "|" + timeFormatted + "|" + description + "|" + vendor + "|" + amount);
            writer.newLine();
            System.out.println("Your payment has been accepted.");

        } catch (IOException e) {
            System.out.println("Error");
        }
        scanner.close();
    }
}










