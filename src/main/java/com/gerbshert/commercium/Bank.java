package com.gerbshert.commercium;

import com.gerbshert.commercium.network.DataCacheHandler;
import net.minecraft.entity.player.EntityPlayer;

import java.text.NumberFormat;

/**
 * Created by Gabriel on 19-May-16.
 */
public class Bank {
    public static final String $ = "currency";
    protected static String player$ = "0.00";

    public static Double getBalance(EntityPlayer player) {
        return player.getEntityData().getDouble($);
    }

    public static void setBalance(EntityPlayer player, Double amount) {
        player.getEntityData().setDouble($, amount);
    }

    public static void addBalance(EntityPlayer player, Double amount) {
        Double currentBal = getBalance(player);
        setBalance(player, (currentBal + amount));
    }

    public static void removeBalance(EntityPlayer player, Double amount) {
        Double currentBal = getBalance(player);
        setBalance(player, (currentBal - amount));
    }

    public static void sendBalance(EntityPlayer giver, EntityPlayer getter, Double amount) {
        addBalance(getter, amount);
        removeBalance(giver, amount);
    }

    //Gets cached data of playerData from DataCacheHandler
    private static void updateClientPlayerBank(String playerName) {
        if (DataCacheHandler.getPlayerDataCache(playerName) == null) {
            player$ = "0.00";
        } else {
            Double player$double = DataCacheHandler.getPlayerDataCache(playerName).getDouble($);
            NumberFormat formatter = NumberFormat.getCurrencyInstance();
            String moneyString;
            if (player$double > 9999999999d){
                moneyString ="ToDamnHigh";
            }
            else if (player$double >= 1000000000){
                player$double = player$double/1000000000;
                moneyString = formatter.format(player$double);
                moneyString = moneyString.replaceAll("$", "");
                moneyString = moneyString.replaceAll(",", "");
                moneyString = moneyString+"T";
            }
            else if (player$double >= 1000000){
                player$double = player$double/1000000;
                moneyString = formatter.format(player$double);
                moneyString = moneyString.replaceAll("$", "");
                moneyString = moneyString.replaceAll(",", "");
                moneyString = moneyString+"M";
            }
            else{
                moneyString = formatter.format(player$double);
                moneyString = moneyString.replaceAll("$", "");
                moneyString = moneyString.replaceAll(",", "");
            }
            player$ = moneyString;
        }
    }

    //Calls for player$ to be updated and returns value
    public static String getClientPlayerBank(String playerName) {
        updateClientPlayerBank(playerName);
        return player$;
    }
}
