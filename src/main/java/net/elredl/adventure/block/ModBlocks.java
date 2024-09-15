package net.elredl.adventure.block;

import net.elredl.adventure.Adventure;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;

public class ModBlocks {

    public static final Block SCRAP_WOOD_BLOCK = registerBlock("scrap_wood_block",
            new Block(AbstractBlock.Settings.create().sounds(BlockSoundGroup.WOOD).strength(1f)));

    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, Identifier.of(Adventure.MOD_ID, name), block);
    }

    private static void registerBlockItem(String name, Block block) {
        Registry.register(Registries.ITEM, Identifier.of(Adventure.MOD_ID, name),
                new BlockItem(block, new Item.Settings()));
    }

    public static void registerModBlocks() {
        Adventure.LOGGER.info("Registering Mod Blocks for " + Adventure.MOD_ID);
    }
}
