package com.ping.pingmod.packet;

import com.ping.pingmod.models.PingMessageText;
import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;

public class PingChatMessagePacket extends BaseMessagePacket<PingChatMessagePacket> {
    private String textMessage;

    public PingChatMessagePacket() { }

    public PingChatMessagePacket(String textMessage) {
        this.textMessage = textMessage;
    }

    @Override
    public void handleServerSide(PingChatMessagePacket message, EntityPlayer player) {
        if(message.textMessage != null && player.getServer() != null)
        {
            PingMessageText pingMessage = new PingMessageText(message.textMessage);

            player.getServer().getPlayerList().sendMessage(pingMessage.getPingTextComponent());
        }
    }

    @Override
    public void handleClientSide(PingChatMessagePacket message, EntityPlayer player) {
        //DO NOTHING
    }

    @Override
    public void fromBytes(ByteBuf buf) {
        try {
            byte[] bytes = new byte[buf.readableBytes()];
            buf.readBytes(bytes);

            this.textMessage = new String(bytes);
        } catch (Exception ex) {
            return;
        }
    }

    @Override
    public void toBytes(ByteBuf buf) {
        try {
            buf.writeBytes(textMessage.getBytes());
        } catch (Exception ex) {
            return;
        }
    }
}
