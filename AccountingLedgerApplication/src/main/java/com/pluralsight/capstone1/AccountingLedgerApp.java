package com.pluralsight.capstone1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.Scanner;

public class AccountingLedgerApp {
    public static void main(String[] args) {
        homeScreen();
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
                    System.out.println("L) Ledger: ");
                    break;
                case "X":
                    System.out.println("X) Exit: ");
                    scanner.close();
                    return;
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
