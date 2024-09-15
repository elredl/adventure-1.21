package net.elredl.adventure.item;

import com.sun.net.httpserver.Filter;
import net.elredl.adventure.Adventure;
import net.elredl.adventure.entity.ModEntities;
import net.elredl.adventure.item.custom.ChainedFury;
import net.elredl.adventure.item.custom.GigantGreatsword;
import net.elredl.adventure.item.custom.MourningStar;
import net.elredl.adventure.item.custom.RuinedGreatsword;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {

    public static final Item ARTIFICIAL_SWORD_CORE = registerItem("artificial_sword_core",
            new Item(new Item.Settings()));
    public static final Item SWORD_CORE = registerItem("sword_core",
            new Item(new Item.Settings()));
    public static final Item SCRAP_WOOD = registerItem("scrap_wood",
            new Item(new Item.Settings()));

    public static final Item GOBLIN_SLOP = registerItem("goblin_slop", new Item(new Item.Settings().food(ModFoodComponents.GOBLIN_SLOP)));

    public static final Item GOBLIN_SPAWN_EGG = registerItem("goblin_spawn_egg", new SpawnEggItem(ModEntities.GOBLIN, 0x028b00, 0x540000, new Item.Settings()));

    public static final Item RUINED_GREATSWORD = registerItem("ruined_greatsword",
            new RuinedGreatsword(ModToolMaterials.SWORD_CORE,
                    new Item.Settings().attributeModifiers(SwordItem.createAttributeModifiers(ModToolMaterials.SWORD_CORE, 3, -2.4f))));
    public static final Item MOURNING_STAR = registerItem("mourning_star",
            new MourningStar(ModToolMaterials.SWORD_CORE,
                    new Item.Settings().attributeModifiers(SwordItem.createAttributeModifiers(ModToolMaterials.SWORD_CORE, 3, -2.4f))));
    public static final Item GIGANT_GREATSWORD = registerItem("gigant_greatsword",
            new GigantGreatsword(new Item.Settings()));
    public static final Item CHAINED_FURY = registerItem("chained_fury",
            new ChainedFury(new Item.Settings()));

    public static final Item HELIOS_HELMET = registerItem("helios_helmet",
            new ArmorItem(ModArmorMaterials.HELIOS_ARMOR_MATERIAL, ArmorItem.Type.HELMET,
                    new Item.Settings().maxDamage(ArmorItem.Type.HELMET.getMaxDamage(0))));
    public static final Item HELIOS_CHESTPLATE = registerItem("helios_helmet",
            new ArmorItem(ModArmorMaterials.HELIOS_ARMOR_MATERIAL, ArmorItem.Type.CHESTPLATE,
                    new Item.Settings().maxDamage(ArmorItem.Type.CHESTPLATE.getMaxDamage(0))));


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
