package com.gerbshert.commercium;

import com.gerbshert.commercium.bankdata.DataHandler;

/**
 * Created by Gabriel on 19-May-16.
 */
public class Bank {

    // Returns player's balance
    public static Double getBalance(String playerName) {
        Double playerCurrency = DataHandler.getPlayerData(playerName);
        return playerCurrency;
    }

    // Set's the player's balance to a certain amount
    public static void setBalance(String playerName, Double amount) {
        if (amount < 0) {
            DataHandler.setPlayerData(playerName, 0.00);
        } else {
            DataHandler.setPlayerData(playerName, amount);
        }
    }

    // Use to add funds to a player's balance
    public static void addBalance(String playerName, Double amount) {
        Double currentBal = getBalance(playerName);
        setBalance(playerName, (currentBal + amount));
    }

    /*
    * Use to remove funds from a player first checking to make sure sender has available funds to do such.
    *   Returns false if player is too poor to loose given amount.
    */
    public static boolean removeBalance(String playerName, Double amount) {
        Double currentBal = getBalance(playerName);
        if (currentBal >= amount) {
            setBalance(playerName, (currentBal - amount));
            return true;
        } else {
            return false;
        }
    }

    /*
    * Use to send currency from one player or another first checking to make sure sender has available funds to do such.
    *   Returns false if player is too poor to give given amount.
    */
    public static boolean sendBalance(String playerName, String playerRecive, Double amount) {
        if (getBalance(playerName) >= amount) {
            addBalance(playerRecive, amount);
            removeBalance(playerName, amount);
            return true;
        } else {
            return false;
        }
    }

    //These
}
