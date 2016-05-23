package com.gerbshert.commercium;

import com.gerbshert.commercium.network.DataCacheHandler;
import net.minecraft.entity.player.EntityPlayer;

/**
 * Created by Gabriel on 19-May-16.
 */
public class Bank {
    public static final String $ = "currency";
    protected static String player$ = "Wait";

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
            player$ = "wait.";
        } else {
            String player$FromData = Double.toString(DataCacheHandler.getPlayerDataCache(playerName).getDouble($));
            String playerFinal$ = player$FromData.substring(0, player$FromData.indexOf('.') + 3);
            player$ = playerFinal$;
        }
    }

    //Calls for player$ to be updated and returns value
    public static String getClientPlayerBank(String playerName) {
        updateClientPlayerBank(playerName);
        return player$;
    }
}
