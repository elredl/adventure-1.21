package net.elredl.adventure;

import net.elredl.adventure.block.ModBlocks;
import net.elredl.adventure.entity.ModEntities;
import net.elredl.adventure.entity.client.GoblinRenderer;
import net.elredl.adventure.entity.custom.GoblinEntity;
import net.elredl.adventure.item.ModItemGroups;
import net.elredl.adventure.item.ModItems;
//import net.elredl.adventure.projectile.ModProjectiles;
import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.minecraft.entity.boss.WitherEntity;
import net.minecraft.entity.mob.SkeletonEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class Adventure implements ModInitializer {
	public static final String MOD_ID = "adventure";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItemGroups.registerItemGroups();
		ModBlocks.registerModBlocks();
		ModItems.registerModItems();
		ModEntities.registerModEntities();

		FabricDefaultAttributeRegistry.register(ModEntities.GOBLIN, GoblinEntity.createGoblinAttributes());

		FuelRegistry.INSTANCE.add(ModItems.SCRAP_WOOD, 100);
		FuelRegistry.INSTANCE.add(ModBlocks.SCRAP_WOOD_BLOCK, 600);

	}
}