package com.ping.pingmod.client;

import com.ping.pingmod.packet.PingChatMessagePacket;
import com.ping.pingmod.network.NetworkHandler;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.InputEvent.KeyInputEvent;

public class PingInputHandler {
    private String getPingText(EntityPlayer player)
    {
        int posX = Double.valueOf(player.posX).intValue();
        int posZ = Double.valueOf(player.posZ).intValue();
        int posY = Double.valueOf(player.posY).intValue();

        String playerName = player.getDisplayNameString();

        return String.format("<%s> X:%d Y:%d Z:%d", playerName, posX, posY, posZ);
    }



    @SuppressWarnings("unused")
    @SubscribeEvent
    public void onPingInput(KeyInputEvent event)
    {
        if (KeybindsPingMod.ping.isPressed())
        {
            EntityPlayer player = Minecraft.getMinecraft().player;
            String pingMessage = getPingText(player);
            NetworkHandler.INSTANCE.sendToServer(new PingChatMessagePacket(pingMessage));
        }
    }
}

