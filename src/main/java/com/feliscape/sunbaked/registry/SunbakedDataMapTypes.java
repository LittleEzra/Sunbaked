package com.feliscape.sunbaked.registry;

import com.feliscape.sunbaked.Sunbaked;
import com.feliscape.sunbaked.data.map.Strippable;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.block.Block;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.registries.datamaps.AdvancedDataMapType;
import net.neoforged.neoforge.registries.datamaps.DataMapType;
import net.neoforged.neoforge.registries.datamaps.RegisterDataMapTypesEvent;

@EventBusSubscriber(modid = Sunbaked.MOD_ID)
public class SunbakedDataMapTypes {
    public static final DataMapType<Block, Strippable> STRIPPABLES = AdvancedDataMapType.builder(
            Sunbaked.location("strippables"),
            Registries.BLOCK,
            Strippable.CODEC
    ).build();

    @SubscribeEvent
    private static void registerDataMapTypes(RegisterDataMapTypesEvent event){
        event.register(STRIPPABLES);
    }
}
