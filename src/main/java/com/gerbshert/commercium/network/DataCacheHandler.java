package com.gerbshert.commercium.network;

import net.minecraft.nbt.NBTTagCompound;

/**
 * Created by Gabriel on 22-May-16.
 */
public class DataCacheHandler {
    private static NBTTagCompound playerDataCache;
    private static String server$IconCache;
    private static String server$NameCache;

    //Allows anyone to get and request and update for cached values. Returns cached values after updating.
    public static NBTTagCompound getPlayerDataCache(String playerRequesting) {
        updateFromServer("playerData", playerRequesting);
        return playerDataCache;
    }

    public static String getServer$IconCache(String playerRequesting) {
        updateFromServer("server$Icon", playerRequesting);
        return server$IconCache;
    }

    public static String getServer$NameCache(String playerRequesting) {
        updateFromServer("server$Name", playerRequesting);
        return server$NameCache;
    }

    //Summons packets to updates cached values from server.
    private static void updateFromServer(String infoToUpdate, String playerRequesting) {
        if (infoToUpdate == "playerData") {
            PacketHandler.network.sendToServer(new NetworkRequestPlayerData(playerRequesting));
        } else if (infoToUpdate == "server$Icon") {
            PacketHandler.network.sendToServer(new NetworkRequestServer$Icon(playerRequesting));
        } else if (infoToUpdate == "server$Name") {
            PacketHandler.network.sendToServer(new NetworkRequestServer$Name(playerRequesting));
        } else {
            System.err.println("Unknown request from " + playerRequesting + ". Requested " + infoToUpdate);
        }
    }

    //Allows packets in "com.gerbshert.commercium.network" to edit private cached values.
    protected static void setPlayerDataCache(NBTTagCompound newPlayerData) {
        playerDataCache = newPlayerData;
    }

    protected static void setServer$IconCache(String newServer$Icon) {
        server$IconCache = newServer$Icon;
    }

    protected static void setServer$NameCache(String newServer$Name) {
        server$NameCache = newServer$Name;
    }
}
