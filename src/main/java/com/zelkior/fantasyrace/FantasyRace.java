package com.zelkior.fantasyrace;

import com.zelkior.fantasyrace.event.RegisteringEvent;
import com.zelkior.fantasyrace.proxy.CommonProxy;
import com.zelkior.fantasyrace.utils.References;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import org.apache.logging.log4j.Logger;

import java.util.Map;

@Mod(modid = References.MODID, name = References.NAME, version = References.VERSION)
public class FantasyRace
{
    public static Map<String, Race> RacePerPlayer;

    @Mod.Instance(References.MODID)
    public static FantasyRace instance;

    @SidedProxy(clientSide = References.CLIENT_PROXY, serverSide = References.SERVER_PROXY)
    public static CommonProxy proxy;

    public static Logger logger;

    public FantasyRace()
    {
        MinecraftForge.EVENT_BUS.register(new RegisteringEvent());
    }

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent e)
    {
        logger = e.getModLog();
        proxy.preInit(e.getSuggestedConfigurationFile());
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent e)
    {
        proxy.init();
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent e)
    {
        proxy.postInit();
    }

    @Mod.EventHandler
    public void onServerStart(FMLServerStartingEvent e)
    {

    }
}

enum Race
{
    Humain,
    Orc,
    Elfe,
    Nain
}
