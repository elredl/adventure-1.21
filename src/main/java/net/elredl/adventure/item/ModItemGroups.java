package net.elredl.adventure.item;

import net.elredl.adventure.Adventure;
import net.elredl.adventure.block.ModBlocks;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroups {
    public static final ItemGroup ADVENTURE_GROUP = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(Adventure.MOD_ID, "sword_core"),
            FabricItemGroup.builder().displayName(Text.translatable("itemgroup.adventure"))
                    .icon(() -> new ItemStack(ModItems.SWORD_CORE)).entries((displayContext, entries) -> {
                        entries.add(ModItems.ARTIFICIAL_SWORD_CORE);
                        entries.add(ModItems.SWORD_CORE);
                        entries.add(ModItems.RUINED_GREATSWORD);
                        entries.add(ModItems.GIGANT_GREATSWORD);
                        entries.add(ModItems.CHAINED_FURY);
                        entries.add(ModItems.MOURNING_STAR);
                        entries.add(ModItems.HELIOS_HELMET);
                        entries.add(ModItems.HELIOS_CHESTPLATE);
                        entries.add(ModBlocks.SCRAP_WOOD_BLOCK);
                        entries.add(ModItems.SCRAP_WOOD);
                        entries.add(ModItems.GOBLIN_SLOP);
                        entries.add(ModItems.GOBLIN_SPAWN_EGG);
                    }).build());

    public static void registerItemGroups() {
        Adventure.LOGGER.info("Registering Item and Block Groups for " + Adventure.MOD_ID);
    }
}
