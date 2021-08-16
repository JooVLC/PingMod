package com.ping.pingmod.packet;

import com.ping.pingmod.PingMod;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

public abstract class BaseMessagePacket<MESSAGE_TYPE extends IMessage> implements IMessage, IMessageHandler<MESSAGE_TYPE, MESSAGE_TYPE> {
    @Override
    public MESSAGE_TYPE onMessage(MESSAGE_TYPE message, MessageContext ctx) {
        if(ctx.side.isServer()) {
            handleServerSide(message, ctx.getServerHandler().player);
        } else if(ctx.side.isClient()) {
            handleClientSide(message, PingMod.PROXY.getClientPlayer());
        }

        return null;
    }

    public abstract void handleServerSide(MESSAGE_TYPE message, EntityPlayer player);

    public abstract void handleClientSide(MESSAGE_TYPE message, EntityPlayer player);
}
