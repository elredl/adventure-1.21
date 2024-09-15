package net.elredl.adventure.item.custom;

//import net.elredl.adventure.projectile.custom.GhostSwordProjectile;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.*;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;



public class RuinedGreatsword extends SwordItem {
    public RuinedGreatsword(ToolMaterial toolMaterial, Settings settings) {
        super(toolMaterial, settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        ItemStack itemStack = user.getStackInHand(hand);
        user.setCurrentHand(hand);
//        if (!user.getItemCooldownManager().isCoolingDown(itemStack.getItem())) {
//            user.getItemCooldownManager().set(this, 50);
//            GhostSwordProjectile ghostSwordProjectile = new GhostSwordProjectile(world);
//            ghostSwordProjectile.setVelocity(user, user.getPitch(), user.getYaw(), 0.0F, 1.5F, 1.0F);
//            world.spawnEntity(ghostSwordProjectile);
//        }
        return TypedActionResult.consume(itemStack);
    }

    @Override
    public void postDamageEntity(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        stack.damage(0, attacker, EquipmentSlot.MAINHAND);
    }
}
