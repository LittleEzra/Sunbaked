package com.feliscape.sunbaked.registry;

import com.feliscape.sunbaked.Sunbaked;
import com.feliscape.sunbaked.content.block.entity.ModHangingSignBlockEntity;
import com.feliscape.sunbaked.content.block.entity.ModSignBlockEntity;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class SunbakedBlockEntityTypes {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES =
            DeferredRegister.create(Registries.BLOCK_ENTITY_TYPE, Sunbaked.MOD_ID);

    public static final Supplier<BlockEntityType<ModSignBlockEntity>> MOD_SIGN =
            BLOCK_ENTITIES.register("mod_sign", () -> BlockEntityType.Builder.of(ModSignBlockEntity::new,
                    SunbakedBlocks.AURUM_SIGN.get(), SunbakedBlocks.AURUM_WALL_SIGN.get()).build(null));
    public static final Supplier<BlockEntityType<ModHangingSignBlockEntity>> MOD_HANGING_SIGN =
            BLOCK_ENTITIES.register("mod_hanging_sign", () -> BlockEntityType.Builder.of(ModHangingSignBlockEntity::new,
                    SunbakedBlocks.AURUM_HANGING_SIGN.get(), SunbakedBlocks.AURUM_WALL_HANGING_SIGN.get()).build(null));

    public static void register(IEventBus eventBus){
        BLOCK_ENTITIES.register(eventBus);
    }
}
