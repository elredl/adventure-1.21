//package net.elredl.adventure.projectile;
//
//import net.minecraft.enchantment.EnchantmentHelper;
//import net.minecraft.entity.Entity;
//import net.minecraft.entity.EntityType;
//import net.minecraft.entity.LivingEntity;
//import net.minecraft.entity.damage.DamageSource;
//import net.minecraft.entity.effect.StatusEffectInstance;
//import net.minecraft.entity.effect.StatusEffects;
//import net.minecraft.entity.projectile.ExplosiveProjectileEntity;
//import net.minecraft.item.Item;
//import net.minecraft.server.world.ServerWorld;
//import net.minecraft.util.hit.EntityHitResult;
//import net.minecraft.util.hit.HitResult;
//import net.minecraft.world.Difficulty;
//import net.minecraft.world.World;
//import net.minecraft.world.explosion.Explosion;
//
//public class GhostSwordProjectile extends ExplosiveProjectileEntity {
//    protected GhostSwordProjectile(EntityType<? extends ExplosiveProjectileEntity> entityType, World world) {
//        super(entityType, world);
//    }
//
//    public GhostSwordProjectile(World world, LivingEntity owner) {
//        super(null, owner, world); // null will be changed later
//    }
//
//    public GhostSwordProjectile(World world, double x, double y, double z) {
//        super(null, x, y, z, world); // null will be changed later
//    }
//
//    @Override
//    protected Item getDefaultItem() {
//        return null; // We will configure this later, once we have created the ProjectileItem.
//    }
//
//    @Override
//    protected void onEntityHit(EntityHitResult entityHitResult) {
//        super.onEntityHit(entityHitResult);
//        if (this.getWorld() instanceof ServerWorld serverWorld) {
//            Entity var8 = entityHitResult.getEntity();
//            boolean bl;
//            if (this.getOwner() instanceof LivingEntity livingEntity) {
//                DamageSource damageSource = this.getDamageSources().witherSkull(this, livingEntity);
//                bl = var8.damage(damageSource, 8.0F);
//                if (bl) {
//                    if (var8.isAlive()) {
//                        EnchantmentHelper.onTargetDamaged(serverWorld, var8, damageSource);
//                    } else {
//                        livingEntity.heal(5.0F);
//                    }
//                }
//            } else {
//                bl = var8.damage(this.getDamageSources().magic(), 5.0F);
//            }
//
//            if (bl && var8 instanceof LivingEntity livingEntityx) {
//                int i = 0;
//                if (this.getWorld().getDifficulty() == Difficulty.NORMAL) {
//                    i = 10;
//                } else if (this.getWorld().getDifficulty() == Difficulty.HARD) {
//                    i = 40;
//                }
//
//                if (i > 0) {
//                    livingEntityx.addStatusEffect(new StatusEffectInstance(StatusEffects.WITHER, 20 * i, 1), this.getEffectCause());
//                }
//            }
//        }
//    }
//
//    @Override
//    protected void onCollision(HitResult hitResult) {
//        super.onCollision(hitResult);
//        if (!this.getWorld().isClient) {
//            this.getWorld().createExplosion(this, this.getX(), this.getY(), this.getZ(), 1.0F, false, World.ExplosionSourceType.MOB);
//            this.discard();
//        }
//    }
//
//    @Override
//    public boolean damage(DamageSource source, float amount) {
//        return false;
//    }
//
//
//}
