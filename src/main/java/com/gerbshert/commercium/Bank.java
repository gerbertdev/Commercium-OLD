package com.gerbshert.commercium;

import net.minecraft.entity.player.EntityPlayer;

/**
 * Created by Gabriel on 19-May-16.
 */
public class Bank {
    public static final String $ = "currency";

    // Returns play's balance
    public static Double getBalance(EntityPlayer playerEntity) {
        Double playerCurrency = playerEntity.getEntityData().getDouble($);
        return playerCurrency;
    }

    // Set's the player's balance to a certain amount
    public static void setBalance(EntityPlayer playerEntity, Double amount) {
        if (amount < 0) {
            playerEntity.getEntityData().setDouble($, 0.00);
        } else {
            playerEntity.getEntityData().setDouble($, amount);
        }
    }

    // Use to add funds to a player's balance
    public static void addBalance(EntityPlayer playerEntity, Double amount) {
        Double currentBal = getBalance(playerEntity);
        setBalance(playerEntity, (currentBal + amount));
    }

    /*
    * Use to remove funds from a player first checking to make sure sender has available funds to do such.
    *   Returns false if player is too poor to loose given amount.
    */
    public static boolean removeBalance(EntityPlayer playerEntity, Double amount) {
        Double currentBal = getBalance(playerEntity);
        if (currentBal >= amount){
            setBalance(playerEntity, (currentBal - amount));
            return true;
        }else{
            return false;
        }
    }

    /*
    * Use to send currency from one player or another first checking to make sure sender has available funds to do such.
    *   Returns false if player is too poor to give given amount.
    */
    public static boolean sendBalance(EntityPlayer playerEntity, String playerRecive, Double amount) {
        if (getBalance(playerEntity) >= amount){
        addBalance(playerEntity.worldObj.getPlayerEntityByName(playerRecive), amount);
        removeBalance(playerEntity, amount);
            return true;
        }else{
            return false;
        }
    }
}
