package dev.jaegerwald.voidlings.particle;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.particle.ParticleFactory;
import net.minecraft.client.particle.ParticleTextureSheet;
import net.minecraft.client.particle.SpriteBillboardParticle;
import net.minecraft.client.particle.SpriteProvider;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.particle.DefaultParticleType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.LightType;

@Environment(EnvType.CLIENT)
public class VoidWispParticle extends SpriteBillboardParticle {

    VoidWispParticle(ClientWorld world, double x, double y, double z, double velX, double velY, double velZ, SpriteProvider spriteProvider) {
        super(world, x, y, z);
        velocityX = velX;
        velocityY = velY + 0.01;
        velocityZ = velZ;
        maxAge = 160;
        setColor(1f, 1f, 1f);
        scale = 0;
        alpha = 0;
        collidesWithWorld = false;
        setSprite(spriteProvider);
    }

    @Override
    public void tick() {
        prevPosX = x;
        prevPosY = y;
        prevPosZ = z;
        if (age++ >= maxAge) {
            markDead();
        } else {
            velocityX += (lightAt(x - 0.5, y, z) - lightAt(x + 0.5, y, z)) * 0.01 + Math.sin(age * 0.1) * 0.002;
            velocityY += (lightAt(x, y - 0.5, z) - lightAt(x, y + 0.5, z)) * 0.01 + Math.sin(age * 0.08) * 0.001;
            velocityZ += (lightAt(x, y, z - 0.5) - lightAt(x, y, z + 0.5)) * 0.01 + Math.cos(age * 0.1) * 0.002;

            PlayerEntity player;
            if (world.getClosestPlayer(x, y, z, 32, false) instanceof PlayerEntity) {
                player = (PlayerEntity) world.getClosestPlayer(x, y, z, 32, false);
                Vec3d playerVelocity = player.getVelocity();
                velocityX += playerVelocity.getX() * 0.04;
                velocityY += (playerVelocity.getY() + 0.08) * 0.04;
                velocityZ += playerVelocity.getZ() * 0.04;
            }

            world.getBlockCollisions(null, new Box(x - 1, y - 1, z - 1, x + 1, y + 1, z + 1)).iterator().forEachRemaining(voxelShape -> voxelShape.getClosestPointTo(new Vec3d(x, y, z)).ifPresent(point -> {
                Vec3d nudge = point.subtract(x, y, z).multiply(0.001);
                velocityX -= nudge.getX();
                velocityY -= nudge.getY();
                velocityZ -= nudge.getZ();
            }));

            double drag = 0.99;
            velocityX *= drag;
            velocityY *= drag;
            velocityZ *= drag;

            move(velocityX, velocityY, velocityZ);
            alpha = (float) Math.sin(Math.PI * age / maxAge);
            scale = 0.05f * alpha;
        }
    }

    private int lightAt(double x, double y, double z) {
        return world.getLightLevel(LightType.BLOCK, BlockPos.ofFloored(x, y, z));
    }

    @Override
    public ParticleTextureSheet getType() {
        return ParticleTextureSheet.PARTICLE_SHEET_TRANSLUCENT;
    }

    @Override
    public int getBrightness(float tint) {
        return 240;
    }

    @Environment(EnvType.CLIENT)
    public static class Factory implements ParticleFactory<DefaultParticleType> {
        private final SpriteProvider spriteProvider;

        public Factory(SpriteProvider spriteProvider) {
            this.spriteProvider = spriteProvider;
        }

        public VoidWispParticle createParticle(DefaultParticleType defaultParticleType, ClientWorld clientWorld, double x, double y, double z, double velX, double velY, double velZ) {
            return new VoidWispParticle(clientWorld, x, y, z, velX, velY, velZ, spriteProvider);
        }
    }
}
