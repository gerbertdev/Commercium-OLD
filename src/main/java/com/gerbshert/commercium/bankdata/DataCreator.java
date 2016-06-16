package com.gerbshert.commercium.bankdata;

import java.io.BufferedWriter;
import java.io.FileWriter;

/**
 * Created by Gabriel on 26-May-16.
 */
public class DataCreator {
    DataCreator() {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(DataHandler.dataFile));
            writer.write("testNotch-0.89");
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
