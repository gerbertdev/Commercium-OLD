package com.gerbshert.commercium.network;

import com.gerbshert.commercium.Bank;
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

    public NetworkSendPlayerData() {
    }

    public NetworkSendPlayerData(NBTTagCompound playerData) {
        this.playerData = playerData;
    }

    @Override
    public void fromBytes(ByteBuf buf) {
        playerData = ByteBufUtils.readTag(buf);
    }

    @Override
    public void toBytes(ByteBuf buf) {
        ByteBufUtils.writeTag(buf, playerData);
    }

    public static class Handler implements IMessageHandler<NetworkSendPlayerData, IMessage> {


        public static void usePacket(NetworkSendPlayerData message) {
            Bank.updateClientPlayerBank(Double.toString(message.playerData.getDouble(Bank.$)));
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

