package net.elredl.adventure.util;

import net.elredl.adventure.Adventure;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

public class ModTags {
    public static class Blocks {
        public static final TagKey<Block> NEEDS_SWORD_CORE_TOOL = createTag("needs_sword_core_tool");
        public static final TagKey<Block> INCORRECT_FOR_SWORD_CORE_TOOL = createTag("incorrect_for_sword_core_tool");

        private static TagKey<Block> createTag(String name) {
            return TagKey.of(RegistryKeys.BLOCK, Identifier.of(Adventure.MOD_ID, name));
        }
    }

    public static class Items {
        public static final TagKey<Item> SWORD_CORE_ITEMS =
                createTag("sword_core_items");

        private static TagKey<Item> createTag(String name) {
            return TagKey.of(RegistryKeys.ITEM, Identifier.of(Adventure.MOD_ID, name));
        }
    }
}
