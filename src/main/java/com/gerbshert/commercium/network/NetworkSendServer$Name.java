package com.gerbshert.commercium.network;

import io.netty.buffer.ByteBuf;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

/**
 * Created by Gabriel on 22-May-16.
 */
public class NetworkSendServer$Name implements IMessage {
    @Override
    public void fromBytes(ByteBuf buf) {

    }

    @Override
    public void toBytes(ByteBuf buf) {

    }

    public class Handler implements IMessageHandler<NetworkSendServer$Name, IMessage> {
        @Override
        public IMessage onMessage(NetworkSendServer$Name message, MessageContext ctx) {
            return null;
        }
    }
}
