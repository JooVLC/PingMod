package com.ping.pingmod.proxy;

import net.minecraft.entity.player.EntityPlayer;

public abstract class CommonProxy {
    public abstract void registerKeybinds();

    public abstract EntityPlayer getClientPlayer();
}
