package com.gerbshert.commercium;

import com.gerbshert.commercium.libraries.Strings;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Gabriel on 23-May-16.
 */
public class BankData {
    public static File file = new File(Strings.MOD_ID + "\\bank.data");
    static ArrayList<String> bankData;
    private File dir = new File(Strings.MOD_ID);

    BankData() {
        dir.mkdir();
        if (!file.exists()) {
            createBankData();
        }
        //ToDo: Create /comercium/bank.data if not found.
        //ToDo: Populate arraylist with player balances.
    }

    static Boolean getPlayerExist(String playerName) {
        loadBankData();
        Boolean playerFound = false;
        int listPosition = 0;
        do {
            String arrayTestS = bankData.get(listPosition);
            String[] arrayTestA = arrayTestS.split("|", -1);
            if (arrayTestA[0].equals(playerName)) {
                playerFound = true;
            }
        } while (!playerFound && listPosition <= bankData.size());
        return playerFound;
    }

    static Double getPlayerBalance(String playerName) {
        loadBankData();
        String playerBalance = "Error Not Found";
        Boolean playerFound = false;
        int listPosition = 0;
        do {
            String arrayTestS = bankData.get(listPosition);
            String[] arrayTestA = arrayTestS.split("|", -1);
            if (arrayTestA[0].equals(playerName)) {
                playerBalance = arrayTestA[1].replace("|", "");
                playerBalance = arrayTestA[1].replace(",\\s", "");
                playerFound = true;
            }
        } while (!playerFound && listPosition <= bankData.size());
        return Double.parseDouble(playerBalance);
    }

    public static void setPlayerBalance(String playerName, Double Amount) {
        loadBankData();
        String playerBalance = "Err";
        Boolean playerFound = false;
        int listPosition = 0;
        do {
            String arrayTestS = bankData.get(listPosition);
            String[] arrayTestA = arrayTestS.split("|", -1);
            if (arrayTestA[0].equals(playerName)) {
                bankData.set(listPosition, playerName + "|" + Amount.toString() + ",\\s");
            }
        } while (!playerFound && listPosition <= bankData.size());
        saveBankData();
    }

    public static void newPlayerBalance(String playerName) {
        loadBankData();
        bankData.add(playerName + "|" + 0.00 + ",\\s");
        saveBankData();
    }

    public static void saveBankData() {
        int listPosition = 0;
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(file));
            do {
                writer.newLine();
                writer.write(bankData.get(listPosition));
            } while (listPosition <= bankData.size());
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void loadBankData() {
        String lineValue = "";
        try {
            Scanner inFile1 = new Scanner(file).useDelimiter(",\\s*");
            do {
                lineValue = inFile1.next();
                bankData.add(lineValue);
            } while ((inFile1.hasNext()));
            inFile1.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static void createBankData() {
        if (!file.exists()) {
            try {
                BufferedWriter writer = new BufferedWriter(new FileWriter(file));
                writer.write("uuid=00000000000000000000000000000000|currency=9999999999,");
                writer.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
