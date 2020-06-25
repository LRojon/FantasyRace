package com.zelkior.fantasyrace.items;

import com.google.common.collect.Lists;
import com.zelkior.fantasyrace.utils.References;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.List;

public class FantasyRaceItems {

    public static final FantasyRaceItems INSTANCE = new FantasyRaceItems();

    public static Item IRON_STICK;

    private static List<Item> items;

    public static void init()
    {
        items = Lists.newArrayList();

        IRON_STICK = createItem("iron_stick").setCreativeTab(CreativeTabs.MISC);
        INSTANCE.items.add(IRON_STICK);
    }

    public static Item createItem(String name)
    {
        Item item = new Item();
        item.setRegistryName(References.MODID, name).setUnlocalizedName(References.MODID + "." + name);
        return item;
    }

    @SubscribeEvent
    public static void registerModels(ModelRegistryEvent e)
    {
        init();
        for(Item item : items)
        {
            registerModel(item);
        }
    }

    public static void registerModel(Item item)
    {
        //ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(new ResourceLocation(References.MODID, item.getUnlocalizedName().substring(5)), "inventory"));
        GameRegistry.findRegistry(Item.class).register(item);
    }

    public List<Item> getItems() {
        return items;
    }
}
