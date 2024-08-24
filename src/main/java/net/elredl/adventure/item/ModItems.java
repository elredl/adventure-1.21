package net.elredl.adventure.item;

import net.elredl.adventure.Adventure;
import net.elredl.adventure.item.custom.GigantGreatsword;
import net.elredl.adventure.item.custom.RuinedGreatsword;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {

    public static final Item ARTIFICIAL_SWORD_CORE = registerItem("artificial_sword_core",
            new Item(new Item.Settings()));
    public static final Item SWORD_CORE = registerItem("sword_core",
            new Item(new Item.Settings()));

    public static final Item RUINED_GREATSWORD = registerItem("ruined_greatsword",
            new RuinedGreatsword(new Item.Settings()));
    public static final Item GIGANT_GREATSWORD = registerItem("gigant_greatsword",
            new GigantGreatsword(new Item.Settings()));

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(Adventure.MOD_ID, name), item);
    }

    public static void customIngredients(FabricItemGroupEntries entries) {
        entries.add(ARTIFICIAL_SWORD_CORE);
        entries.add(SWORD_CORE);
    }

    public static void registerModItems() {
        Adventure.LOGGER.info("Registering Mod Items for " + Adventure.MOD_ID);

//        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(ModItems::customIngredients);
    }
}
