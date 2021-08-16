package com.ping.pingmod.proxy;

import net.minecraft.entity.player.EntityPlayer;

public class ServerProxy extends CommonProxy {
    @Override
    public void registerKeybinds() {
        return;
    }

    @Override
    public EntityPlayer getClientPlayer() {
        return null;
    }
}
