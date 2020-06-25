package com.zelkior.fantasyrace.blocks;

import com.google.common.collect.Lists;
import com.zelkior.fantasyrace.utils.References;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

import java.lang.ref.Reference;
import java.util.List;

public class FantasyRaceBlocks
{

    public static Block iron_ladder;

    public static final FantasyRaceBlocks instance = new FantasyRaceBlocks();

    public List<Block> blocks;

    public void init()
    {
        blocks = Lists.newArrayList();

        iron_ladder = createBlock("iron_ladder", Material.IRON).setCreativeTab(CreativeTabs.DECORATIONS);
        iron_ladder.setResistance(30).setHardness(5).setHarvestLevel("pickaxe", 2);
        instance.blocks.add(iron_ladder);
    }

    private Block createBlock(String name, Material material)
    {
        Block b = new Block(material);
        b.setRegistryName(name).setUnlocalizedName(name);
        return b;
    }

    @SubscribeEvent
    public void registerModels(ModelRegistryEvent e)
    {
        for(Block block : blocks)
        {
            registerModel(block);
        }
    }

    public void registerModel(Block block)
    {
        ItemBlock ib = new ItemBlock(block);
        ib.setRegistryName(block.getRegistryName());
        GameRegistry.findRegistry(Item.class).register(ib);

        ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(block), 0, new ModelResourceLocation(new ResourceLocation(References.MODID, block.getUnlocalizedName().substring(5)), "inventory"));

    }
}
