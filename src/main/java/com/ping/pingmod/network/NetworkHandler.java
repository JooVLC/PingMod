package com.ping.pingmod.network;

import com.ping.pingmod.packet.PingChatMessagePacket;
import com.ping.pingmod.PingMod;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import net.minecraftforge.fml.relauncher.Side;

public class NetworkHandler {
    public static SimpleNetworkWrapper INSTANCE;

    public static void register() {
        INSTANCE = NetworkRegistry.INSTANCE.newSimpleChannel(
                PingMod.MODID
        );

        INSTANCE.registerMessage(PingChatMessagePacket.class, PingChatMessagePacket.class, 0, Side.SERVER);
    }
}
