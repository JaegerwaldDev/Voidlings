package dev.jaegerwald.voidlings.item;

import dev.jaegerwald.voidlings.sound.ModSounds;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.ItemSteerable;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.stat.Stats;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SurgeonsBladeItem extends SwordItem {

    public SurgeonsBladeItem(ToolMaterial toolMaterial, int attackDamage, float attackSpeed, Settings settings) {
        super(toolMaterial, attackDamage, attackSpeed, settings);
    }

    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        ItemStack itemStack = user.getStackInHand(hand);
        user.incrementStat(Stats.USED.getOrCreateStat(this));

        world.playSound((PlayerEntity)null, user.getX(), user.getY(), user.getZ(), ModSounds.ITEM_SURGEONS_BLADE_STAB, SoundCategory.PLAYERS, 0.75F, 1.0F);

        // mainly like this for testing purposes
        if (!user.isCreative()) {
            user.getItemCooldownManager().set(this, 600);
        } else {
            user.getItemCooldownManager().set(this, 100);
        }

        itemStack.damage(5, user, e -> e.sendEquipmentBreakStatus(EquipmentSlot.MAINHAND));

        user.damage(world.getDamageSources().playerAttack(user), 9.0F);

        return TypedActionResult.pass(itemStack);
    }
}
