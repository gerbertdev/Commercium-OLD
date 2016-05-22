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
        network.registerMessage(NetworkSendServer$Name.Handler.class, NetworkSendServer$Name.class, 1, Side.CLIENT);
        network.registerMessage(NetworkSendServer$Icon.Handler.class, NetworkSendServer$Icon.class, 2, Side.CLIENT);
        network.registerMessage(NetworkRequestPlayerData.Handler.class, NetworkRequestPlayerData.class, 10, Side.SERVER);
        network.registerMessage(NetworkRequestServer$Name.Handler.class, NetworkRequestServer$Name.class, 11, Side.SERVER);
        network.registerMessage(NetworkRequestServer$Icon.Handler.class, NetworkRequestServer$Icon.class, 12, Side.SERVER);
    }
}
