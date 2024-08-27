package net.elredl.adventure.projectile;

import net.elredl.adventure.Adventure;
import net.elredl.adventure.projectile.custom.GhostSwordProjectile;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityType;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.client.render.entity.FlyingItemEntityRenderer;
import net.minecraft.entity.*;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModProjectiles {

    public static final EntityType<GhostSwordProjectile> ghostSwordProjectileEntityType =
        Registry.register(
            Registries.ENTITY_TYPE,
            Identifier.of(Adventure.MOD_ID, "ghost_sword_projectile"),
            FabricEntityTypeBuilder.<GhostSwordProjectile>create(SpawnGroup.MISC, GhostSwordProjectile::new)
                    .dimensions(EntityDimensions.fixed(1f,2f))
                    .trackRangeBlocks(4).trackedUpdateRate(10).build());


    public static void registerModProjectiles() {
        Adventure.LOGGER.info("Registering Mod Projectiles for " + Adventure.MOD_ID);
        EntityRendererRegistry.register(ModProjectiles.ghostSwordProjectileEntityType, (context) -> new FlyingItemEntityRenderer(context));
    }
}
