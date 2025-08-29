package com.feliscape.sunbaked.registry;

import com.feliscape.sunbaked.Sunbaked;
import com.feliscape.sunbaked.content.item.HealingFoodItem;
import net.minecraft.world.item.HangingSignItem;
import net.minecraft.world.item.SignItem;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class SunbakedItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(Sunbaked.MOD_ID);

    public static final DeferredItem<HealingFoodItem> CRISP_APPLE = ITEMS.registerItem("crisp_apple",
            p -> new HealingFoodItem(p.food(SunbakedFoods.CRISP_APPLE), 2.0F));

    public static final DeferredItem<SignItem> AURUM_SIGN = ITEMS.registerItem("aurum_sign",
            p -> new SignItem(p.stacksTo(16), SunbakedBlocks.AURUM_SIGN.get(), SunbakedBlocks.AURUM_WALL_SIGN.get()));
    public static final DeferredItem<HangingSignItem> AURUM_HANGING_SIGN = ITEMS.registerItem("aurum_hanging_sign",
            p -> new HangingSignItem(SunbakedBlocks.AURUM_HANGING_SIGN.get(), SunbakedBlocks.AURUM_WALL_HANGING_SIGN.get(), p.stacksTo(16)));

    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }
}
