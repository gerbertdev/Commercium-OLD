package com.gerbshert.commercium.network;

import com.gerbshert.commercium.libraries.Strings;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import net.minecraftforge.fml.relauncher.Side;

/**
 * Created by Gabriel on 20-May-16.
 */
public class PacketHandler {
    public static SimpleNetworkWrapper network;

    public static void registerPackets() {
        network = NetworkRegistry.INSTANCE.newSimpleChannel(Strings.MOD_ID + "1");

        network.registerMessage(NetworkSendPlayerData.Handler.class, NetworkSendPlayerData.class, 0, Side.CLIENT);
        network.registerMessage(NetworkRequestPlayerData.Handler.class, NetworkRequestPlayerData.class, 1, Side.SERVER);
    }
}
