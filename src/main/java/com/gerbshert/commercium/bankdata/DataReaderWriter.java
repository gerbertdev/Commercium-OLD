package com.gerbshert.commercium.bankdata;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Gabriel on 26-May-16.
 */
public class DataReaderWriter {
    //Loads data from bank.data to dataArray
    public static void loadDataToArray() {
        String token1 = "";
        String[] tempsArray = null;

        try {
            Scanner dataFileIn = new Scanner(DataHandler.dataFile).useDelimiter(",\\s*");
            ArrayList<String> temps = new ArrayList<String>();

            while (dataFileIn.hasNext()) {
                token1 = dataFileIn.next();
                temps.add(token1);
            }

            dataFileIn.close();
            DataHandler.dataArrayList = temps;

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //Saves data from dataArray to bank.data
    public static void unloadArrayToData() {
        int listPosition = 0;

        try {
            DataHandler.dataFile.delete();
            BufferedWriter writer = new BufferedWriter(new FileWriter(DataHandler.dataFile));
            while (listPosition != DataHandler.dataArrayList.size()) {
                if (listPosition == 0) {
                    writer.write(DataHandler.dataArrayList.get(listPosition) + ",");
                } else {
                    writer.newLine();
                    writer.write(DataHandler.dataArrayList.get(listPosition) + ",");
                }
                listPosition++;
            }
            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
