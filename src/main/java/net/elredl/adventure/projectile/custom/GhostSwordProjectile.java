package net.elredl.adventure.projectile.custom;

import net.elredl.adventure.projectile.ModProjectiles;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.projectile.ProjectileEntity;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.util.hit.HitResult;
import net.minecraft.world.World;


public class GhostSwordProjectile extends ProjectileEntity {


    public GhostSwordProjectile(EntityType<? extends ProjectileEntity> entityType, World world) {
        super(entityType, world);
    }

    public GhostSwordProjectile(World world) {
        super(ModProjectiles.ghostSwordProjectileEntityType, world);
    }


    @Override
    protected void onEntityHit(EntityHitResult entityHitResult) {
        super.onEntityHit(entityHitResult);
        Entity entity = entityHitResult.getEntity();
        DamageSource damageSource = this.getDamageSources().magic();
        entity.damage(damageSource, 6f);
    }

    @Override
    protected void onCollision(HitResult hitResult) {
        super.onCollision(hitResult);
        if (!this.getWorld().isClient) {
            this.getWorld().createExplosion(this, this.getX(), this.getY(), this.getZ(), 6.0F, false, World.ExplosionSourceType.BLOCK);
            this.discard();
        }
    }

    @Override
    protected void initDataTracker(DataTracker.Builder builder) {

    }
}
