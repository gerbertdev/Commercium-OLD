package com.gerbshert.commercium.network;

import io.netty.buffer.ByteBuf;
import net.minecraft.client.Minecraft;
import net.minecraft.util.IThreadListener;
import net.minecraftforge.fml.common.network.ByteBufUtils;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

/**
 * Created by Gabriel on 22-May-16.
 */
public class NetworkSendServer$Name implements IMessage {
    private String server$Name;
    private String playerName;

    public NetworkSendServer$Name() {
    }

    public NetworkSendServer$Name(String server$Name, String playerName) {
        this.server$Name = server$Name;
        this.playerName = playerName;
    }

    @Override
    public void fromBytes(ByteBuf buf) {
        server$Name = ByteBufUtils.readUTF8String(buf);
        playerName = ByteBufUtils.readUTF8String(buf);
    }

    @Override
    public void toBytes(ByteBuf buf) {
        ByteBufUtils.writeUTF8String(buf, server$Name);
        ByteBufUtils.writeUTF8String(buf, playerName);
    }

    public static class Handler implements IMessageHandler<NetworkSendServer$Name, IMessage> {


        public static void usePacket(NetworkSendServer$Name message) {
            DataCacheHandler.setServer$NameCache(message.server$Name);
        }

        public IMessage onMessage(final NetworkSendServer$Name message, MessageContext ctx) {
            IThreadListener mainThread = Minecraft.getMinecraft();
            mainThread.addScheduledTask(new Runnable() {
                @Override
                public void run() {
                    usePacket(message);
                }
            });
            return null;
        }
    }

}
