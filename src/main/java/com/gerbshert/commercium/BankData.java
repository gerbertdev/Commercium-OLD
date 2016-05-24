package com.gerbshert.commercium;

import java.util.ArrayList;

/**
 * Created by Gabriel on 23-May-16.
 */
public class BankData {
    static ArrayList<String> bankData;

    BankData() {
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
                playerBalance = arrayTestA[1].replace(",", "");
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
                bankData.set(listPosition, playerName + "|" + Amount.toString() + ",");
            }
        } while (!playerFound && listPosition <= bankData.size());
        saveBankData();
    }

    public static void saveBankData() {
    }

    public static void loadBankData() {
    }

    public static void createBankData() {
    }
}
