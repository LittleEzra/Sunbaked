package com.feliscape.sunbaked.content.item;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class HealingFoodItem extends Item {
    private final float healing;

    public HealingFoodItem(Properties properties, float healing) {
        super(properties);
        this.healing = healing;
    }

    public float getHealing(){
        return healing;
    }

    @Override
    public ItemStack finishUsingItem(ItemStack stack, Level level, LivingEntity livingEntity) {
        FoodProperties food = stack.getFoodProperties(livingEntity);
        if (food != null){
            livingEntity.heal(this.healing);
        }
        return super.finishUsingItem(stack, level, livingEntity);
    }
}
