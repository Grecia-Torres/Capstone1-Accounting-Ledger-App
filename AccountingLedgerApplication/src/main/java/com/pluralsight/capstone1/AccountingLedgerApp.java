package com.pluralsight.capstone1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Scanner;

public class AccountingLedgerApp {
    public static void main(String[] args) {
        homeScreen();
        displayLedger();
    }

    public static void homeScreen() {
        try {
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
                    System.out.println("D) Add Deposit: ");
                    break;
                case "P":
                    System.out.println("P) Make Payment(Debit): ");
                    break;
                case "L":
                    System.out.println("L) Ledger:");
                    displayLedger();
                    break;
                case "X":
                    System.out.println("X) Exit: ");
                    scanner.close();
                    return;
            }
        } catch (Exception e) {
            System.out.println("Invalid! Pick one of the options below!");
            return;

        }
    }
        public static void displayLedger() {
            try {
                Scanner scanner = new Scanner(System.in);
                System.out.println("Please choose an option from the options below:");
                System.out.println("A) All(Will display all options");
                System.out.println("D) Deposits");
                System.out.println("P) Payments");
                System.out.println("R) Reports");
                String ledgerOptions = scanner.nextLine();

                switch (ledgerOptions) {
                    case "A":
                        System.out.println("A) All: ");
                        break;
                    case "D":
                        System.out.println("D) Deposits: ");
                        break;
                    case "P":
                        System.out.println("P) Payments: ");
                        break;
                    case "R":
                        System.out.println("R) Reports: ");
                        break;
                }
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

