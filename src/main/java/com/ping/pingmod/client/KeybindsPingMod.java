package com.ping.pingmod.client;

import net.minecraft.client.settings.KeyBinding;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import org.lwjgl.input.Keyboard;

public class KeybindsPingMod {
    public static KeyBinding ping;

    public static void register()
    {
        ping = new KeyBinding("Ping", Keyboard.KEY_RMENU, "Ping Mod");

        ClientRegistry.registerKeyBinding(ping);
    }
}
