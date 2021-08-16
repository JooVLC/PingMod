package com.ping.pingmod.proxy;

import com.ping.pingmod.client.KeybindsPingMod;
import com.ping.pingmod.client.PingInputHandler;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.common.MinecraftForge;

public class ClientProxy extends CommonProxy {
    @Override
    public void registerKeybinds() {
        KeybindsPingMod.register();
        MinecraftForge.EVENT_BUS.register(new PingInputHandler());
    }

    @Override
    public EntityPlayer getClientPlayer() {
        return Minecraft.getMinecraft().player;
    }
}
