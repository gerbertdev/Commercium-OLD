package com.gerbshert.commercium.network;

import com.gerbshert.commercium.Bank;
import com.gerbshert.commercium.client.ClientData;
import io.netty.buffer.ByteBuf;
import net.minecraft.client.Minecraft;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.IThreadListener;
import net.minecraftforge.fml.common.network.ByteBufUtils;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

/**
 * Created by Gabriel on 19-May-16.
 */
public class NetworkSendPlayerData implements IMessage {
    private NBTTagCompound playerData;
    private String playerName;

    public NetworkSendPlayerData() {
    }

    public NetworkSendPlayerData(NBTTagCompound playerData, String playerName) {
        this.playerData = playerData;
        this.playerName = playerName;
    }

    @Override
    public void fromBytes(ByteBuf buf) {
        playerData = ByteBufUtils.readTag(buf);
        playerName = ByteBufUtils.readUTF8String(buf);
    }

    @Override
    public void toBytes(ByteBuf buf) {
        ByteBufUtils.writeTag(buf, playerData);
        ByteBufUtils.writeUTF8String(buf, playerName);
    }

    public static class Handler implements IMessageHandler<NetworkSendPlayerData, IMessage> {


        public static void usePacket(NetworkSendPlayerData message) {
            ClientData.setPlayerData(message.playerData);
            Bank.updateClientPlayerBankFromClientData(message.playerName);
        }

        public IMessage onMessage(final NetworkSendPlayerData message, MessageContext ctx) {
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

