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
public class NetworkSendServer$Icon implements IMessage {
    private String Server$Icon;
    private String playerName;

    public NetworkSendServer$Icon() {
    }

    public NetworkSendServer$Icon(String Server$Icon, String playerName) {
        this.Server$Icon = Server$Icon;
        this.playerName = playerName;
    }

    @Override
    public void fromBytes(ByteBuf buf) {
        Server$Icon = ByteBufUtils.readUTF8String(buf);
        playerName = ByteBufUtils.readUTF8String(buf);
    }

    @Override
    public void toBytes(ByteBuf buf) {
        ByteBufUtils.writeUTF8String(buf, Server$Icon);
        ByteBufUtils.writeUTF8String(buf, playerName);
    }

    public static class Handler implements IMessageHandler<NetworkSendServer$Icon, IMessage> {


        public static void usePacket(NetworkSendServer$Icon message) {
            DataCacheHandler.setServer$IconCache(message.Server$Icon);
        }

        public IMessage onMessage(final NetworkSendServer$Icon message, MessageContext ctx) {
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