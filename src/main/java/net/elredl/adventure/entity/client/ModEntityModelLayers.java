package net.elredl.adventure.entity.client;

import net.elredl.adventure.Adventure;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.util.Identifier;

public class ModEntityModelLayers {
    public static final EntityModelLayer GOBLIN =
            new EntityModelLayer(Identifier.of(Adventure.MOD_ID, "goblin"), "main");
}
