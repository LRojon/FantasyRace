package com.zelkior.fantasyrace.event;

import com.zelkior.fantasyrace.FantasyRace;
import com.zelkior.fantasyrace.items.FantasyRaceItems;
import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class RegisteringEvent {

    @SubscribeEvent
    public void registerItems(RegistryEvent.Register<Item> e)
    {
        FantasyRaceItems.INSTANCE.init();
        e.getRegistry().registerAll(FantasyRaceItems.INSTANCE.getItems().toArray(new Item[0]));
    }
}
