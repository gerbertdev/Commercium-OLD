package com.gerbshert.commercium.bankdata;

import java.io.File;
import java.util.ArrayList;

/**
 * Created by Gabriel on 26-May-16.
 */
public class DataHandler {
    public static ArrayList<String> dataArrayList = null;
    private static File fileDir = new File(System.getProperty("user.dir") + File.separator + "commercium");
    public static File dataFile = new File(fileDir + "\\bank.data");

    public DataHandler() {
        if (!fileDir.exists()) {
            fileDir.mkdir();
        }
        if (!dataFile.exists()) {
            new DataCreator();
        }
        DataReaderWriter.loadDataToArray();
    }

    /*
    * Check if Player exists
    */
    public static boolean getPlayerExist(String playerName) {
        DataReaderWriter.loadDataToArray();

        Boolean playerFound = false;
        int listPosition = 0;
        while (!playerFound && listPosition != dataArrayList.size()) {
            if (dataArrayList.get(listPosition).contains(playerName)) {
                playerFound = true;
            }
            listPosition++;
        }
        return playerFound;
    }

    /*
    * Get a players data position
    */
    public static int getPlayerDataPosition(String playerName) {
        DataReaderWriter.loadDataToArray();

        Boolean playerFound = false;
        int listPosition = 0;
        while (!playerFound && listPosition != dataArrayList.size()) {
            if (dataArrayList.get(listPosition).contains(playerName)) {
                playerFound = true;
            }
            listPosition++;
        }
        return listPosition;
    }

    public static double getPlayerData(String playerName) {
        Double playerBal = null;
        String playerData = dataArrayList.get(getPlayerDataPosition(playerName)-1);
        String[] strings = playerData.split("-", 2);
        for (String s : strings) {
        }
        playerBal = Double.parseDouble(strings[strings.length - 1]);
        return playerBal;
    }

    /*
    * Sets a players data
    */
    public static void setPlayerData(String playerName, Double amount) {
        int arrayPos = getPlayerDataPosition(playerName) - 1;
        DataReaderWriter.loadDataToArray();
        dataArrayList.remove(arrayPos);
        dataArrayList.add(arrayPos, playerName + "-" + amount);
        DataReaderWriter.unloadArrayToData();
    }

    /*
    * Adds a new player data
    */
    public static void newPlayerBalance(String playerName) {
        if (!getPlayerExist(playerName)) {
            DataReaderWriter.loadDataToArray();
            dataArrayList.add(playerName + "-" + 0.00);
            DataReaderWriter.unloadArrayToData();
        }
    }
}
