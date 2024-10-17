package com.pluralsight.capstone1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Ledger {
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
        List<float[]> depositEntriesList = new ArrayList<>();

        try {
            FileReader fileReader = new FileReader("transactions.csv");
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;

            while ((line = bufferedReader.readLine()) != null) {
                String[] values = line.split("\\|");
                float[] floatValues = new float[values.length];

            }
        } catch (IOException e) {
            e.printStackTrace();

        }
    }
}
