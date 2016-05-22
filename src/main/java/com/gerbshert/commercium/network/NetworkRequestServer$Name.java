package com.gerbshert.commercium.network;

import com.gerbshert.commercium.libraries.Configuration;
import io.netty.buffer.ByteBuf;
import net.minecraft.util.IThreadListener;
import net.minecraft.world.WorldServer;
import net.minecraftforge.fml.common.network.ByteBufUtils;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

/**
 * Created by Gabriel on 22-May-16.
 */
public class NetworkRequestServer$Name implements IMessage {
    private String playerName;

    public NetworkRequestServer$Name() {
    }

    public NetworkRequestServer$Name(String playerName) {
        this.playerName = playerName;
    }

    @Override
    public void fromBytes(ByteBuf buf) {
        playerName = ByteBufUtils.readUTF8String(buf);
    }

    @Override
    public void toBytes(ByteBuf buf) {
        ByteBufUtils.writeUTF8String(buf, playerName);
    }

    public static class Handler implements IMessageHandler<NetworkRequestServer$Name, IMessage> {
        public static void respondToPacket(NetworkRequestServer$Name message, MessageContext ctx) {
            PacketHandler.network.sendTo(new NetworkSendServer$Name(Configuration.currencyName + "_&_" + Configuration.currencyNamePlural, message.playerName), ctx.getServerHandler().playerEntity);
        }

        public IMessage onMessage(final NetworkRequestServer$Name message, final MessageContext ctx) {
            IThreadListener mainThread = (WorldServer) ctx.getServerHandler().playerEntity.worldObj;
            mainThread.addScheduledTask(new Runnable() {
                @Override
                public void run() {
                    respondToPacket(message, ctx);
                }
            });
            return null;
        }
    }

}