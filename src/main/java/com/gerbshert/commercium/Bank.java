package com.gerbshert.commercium;

/**
 * Created by Gabriel on 19-May-16.
 */
public class Bank {
    public static final String $ = "currency";

    public static Double getBalance(String playerName) {
        return BankData.getPlayerBalance(playerName);
    }

    public static void setBalance(String playerName, Double amount) {
        if (amount < 0) {
            BankData.setPlayerBalance(playerName, 0.00);
        } else {
            BankData.setPlayerBalance(playerName, amount);
        }
    }

    public static void addBalance(String playerName, Double amount) {
        Double currentBal = getBalance(playerName);
        setBalance(playerName, (currentBal + amount));
    }

    public static void removeBalance(String playerName, Double amount) {
        Double currentBal = getBalance(playerName);
        setBalance(playerName, (currentBal - amount));
    }

    public static void sendBalance(String playerNameGive, String playerNameGet, Double amount) {
        addBalance(playerNameGet, amount);
        removeBalance(playerNameGive, amount);
    }
}
