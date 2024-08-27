package net.elredl.adventure;

import net.elredl.adventure.item.ModItemGroups;
import net.elredl.adventure.item.ModItems;
import net.elredl.adventure.projectile.ModProjectiles;
import net.fabricmc.api.ModInitializer;

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
		ModItems.registerModItems();
		ModProjectiles.registerModProjectiles();

	}
}