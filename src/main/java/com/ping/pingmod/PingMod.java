package com.ping.pingmod;

import com.ping.pingmod.network.NetworkHandler;
import com.ping.pingmod.proxy.CommonProxy;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.apache.logging.log4j.Logger;

@Mod(modid = PingMod.MODID, name = PingMod.NAME, version = PingMod.VERSION)
public class PingMod
{
    public static final String MODID = "pingmod";
    public static final String NAME = "Ping Mod";
    public static final String VERSION = "1.0";
    public static final String CLIENT_PROXY_CLASS = "com.ping.pingmod.proxy.ClientProxy";
    public static final String SERVER_PROXY_CLASS = "com.ping.pingmod.proxy.ServerProxy";

    private static Logger logger;

    @Mod.Instance(MODID)
    public static PingMod INSTANCE;

    @SidedProxy(modId = MODID, serverSide = SERVER_PROXY_CLASS, clientSide = CLIENT_PROXY_CLASS)
    public static CommonProxy PROXY;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        logger = event.getModLog();
        NetworkHandler.register();
        PROXY.registerKeybinds();
    }

    @SuppressWarnings("unused")
    @Mod.EventHandler
    public void init(FMLInitializationEvent event)
    {
        logger.info("INICIANDO MOD");
        logger.info("Mod started in ALT-Right key.");
    }
}

