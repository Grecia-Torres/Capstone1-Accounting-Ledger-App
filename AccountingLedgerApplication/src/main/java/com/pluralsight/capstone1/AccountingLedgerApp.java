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

        System.out.println("                 HOME   ");
        System.out.println("Please choose an option from the following: ");
        System.out.println("D) Add Deposit");
        System.out.println("P) Make Payment");
        System.out.println("L) Ledger");
        System.out.println("X) Exit\n");
        String options = scanner.nextLine();

        switch (options) {
            case "D":
                deposit();
                break;
            case "P":
                payment();
                break;
            case "L":
                System.out.println("L) Ledger:");
                displayLedger();
                break;
            case "X":
                System.out.println("X) Exit: ");
                scanner.close();
            default:
                System.out.println("Not a valid entry");
                homeScreen();
        }
    }

    public static void deposit() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please enter deposit details below: ");
        System.out.println("Please enter a description");
        String description = scanner.nextLine();
        System.out.println("Please enter a vendor");
        String vendor = scanner.nextLine();
        System.out.println("Please enter an amount");
        String amount = scanner.nextLine();

        LocalDate date = LocalDate.now();
        LocalTime time = LocalTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        String timeFormatted = time.format(formatter);
        String transactionsFile = "transactions.csv";

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(transactionsFile, true))) {
            writer.write(date + "|" + timeFormatted + "|" + description + "|" + vendor + "|" + amount);
            writer.newLine();
            System.out.println("Your deposit has been accepted.");
        } catch (IOException e) {
            System.out.println("Error");
        }
        scanner.close();
    }

    public static void payment() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please enter deposit details below: ");
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










