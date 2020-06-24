package com.zelkior.fantasyrace.proxy;

import com.zelkior.fantasyrace.FantasyRace;
import com.zelkior.fantasyrace.items.FantasyRaceItems;
import net.minecraftforge.common.MinecraftForge;

import java.io.File;

public class ClientProxy extends CommonProxy
{
    @Override
    public void preInit(File configFile)
    {
        super.preInit(configFile);
        MinecraftForge.EVENT_BUS.register(FantasyRaceItems.INSTANCE);
    }

    @Override
    public void init() {
        super.init();
    }

    @Override
    public void postInit() {
        super.postInit();
    }
}
