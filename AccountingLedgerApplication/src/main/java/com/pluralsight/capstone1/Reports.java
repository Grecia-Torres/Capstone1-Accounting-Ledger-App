package com.pluralsight.capstone1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Objects;
import java.util.Scanner;
import java.time.LocalDate;

import static com.pluralsight.capstone1.AccountingLedgerApp.homeScreen;

public class Reports {
    public static void displayReports() {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Please choose one of the options below:");
            System.out.println("1) Month to Date");
            System.out.println("2) Previous Month");
            System.out.println("3) Year To Date");
            System.out.println("4) Previous Year");
            System.out.println("5) Search By Vendor");
            System.out.println("0) Back");
            String reportOptions = scanner.nextLine();

            // Used a switch statement to give user different options to choose from in the Report Screen
            switch (reportOptions) {
                // If user enters 0 they will be taken back to Home Screen
                case "0":
                    System.out.println("0) Back");
                    homeScreen();
                    // If user enters 1 only entries from current month will print
                case "1":
                    System.out.println("1) Month to Date");
                    monthToDate();
                    break;
                    // If user enters 2 only entries from previous month will output
                case "2":
                    System.out.println("2) Previous Month");
                    previousMonth();
                    break;
                    // If user enters 3 only entries from current year will print
                case "3":
                    System.out.println("3) Year To Date");
                    yearToDate();
                    break;
                    // If user enters 4 only entries from previous year will output
                case "4":
                    System.out.println("4) Previous Year");
                    previousYear();
                    break;
                    // If user enters 5 they will be asked to enter a vendor name
                case "5":
                    System.out.println("5) Search By Vendor");
                    searchByVendor();
                    break;
                    // User entered an option that wasn't valid and will be asked to pick a valid option
                default:
                    System.out.println("Not a valid entry");
                    displayReports();
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    // This method prints only entries from current month
    public static void monthToDate() throws IOException {
        System.out.println("You've entered month to date");
        String line;

        FileReader fileReader = new FileReader("transactions.csv");
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        bufferedReader.readLine();
        while ((line = bufferedReader.readLine()) != null) {
            String[] entries = line.split("\\|");
            String month = entries[0];
            LocalDate monthDate = LocalDate.parse(month);
            // Gets current month and prints
            if (monthDate.getMonth() == (LocalDate.now().getMonth())) {
                System.out.println(line);
            }
        }


    }
    // This method only prints entries from previous month
    public static void previousMonth() throws IOException {
        System.out.println("You've selected previous month");
        String line;

        FileReader fileReader = new FileReader("transactions.csv");
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        bufferedReader.readLine();
        while ((line = bufferedReader.readLine()) != null) {
            String[] entries = line.split("\\|");
            String previous = entries[0];
            LocalDate previousMo = LocalDate.parse(previous);
            // Gets previous month by subtracting current month
            if (previousMo.getMonth() == (LocalDate.now().minusMonths(1).getMonth())) {
                System.out.println(line);
            }
        }

    }
    // This method only prints entries from current year from csv file
    public static void yearToDate() throws IOException {
        System.out.println("You've entered Year to Date");
        String line;

        FileReader fileReader = new FileReader("transactions.csv");
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        bufferedReader.readLine();
        while ((line = bufferedReader.readLine()) != null) {
            String[] entries = line.split("\\|");
            String year = entries[0];
            LocalDate yearDate = LocalDate.parse(year);
            // Gets current year from csv file
            if (yearDate.getYear() == (LocalDate.now().getYear())) //Maaike helped me fix this line
            {
                System.out.println(line);
            }
        }

    }
    // This method prints entries only from previous year
    public static void previousYear() throws IOException {
        System.out.println("You've entered previous year");
        String line;

        FileReader fileReader = new FileReader("transactions.csv");
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        bufferedReader.readLine();
        while ((line = bufferedReader.readLine()) != null) {
            String[] entries = line.split("\\|");
            String previous = entries[0];
            LocalDate previousYr = LocalDate.parse(previous);
            // Gets previous year by subtracting from current year
            if (previousYr.getYear() == (LocalDate.now().minusYears(1).getYear())) {
                System.out.println(line);
            }
        }

    }
    // This method asks user to enter a vendor name and prints entries matching the vendor name
    public static void searchByVendor() throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter vendor name below");
        String vendorInput = scanner.nextLine();
        String line;

        FileReader fileReader = new FileReader("transactions.csv");
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        bufferedReader.readLine();
        while ((line = bufferedReader.readLine()) != null) {
            String[] entries = line.split("\\|");
            String vendorNames = entries[3];
            // If user input matches vendor name in csv file it will print
            if (Objects.equals(vendorInput, vendorNames)) {
                System.out.println(line);
            }
        }
    }


}


