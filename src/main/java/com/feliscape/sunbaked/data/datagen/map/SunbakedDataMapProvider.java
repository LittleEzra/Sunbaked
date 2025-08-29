package com.feliscape.sunbaked.data.datagen.map;

import com.feliscape.sunbaked.data.map.Strippable;
import com.feliscape.sunbaked.registry.SunbakedBlocks;
import com.feliscape.sunbaked.registry.SunbakedDataMapTypes;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.DataMapProvider;

import java.util.concurrent.CompletableFuture;

public class SunbakedDataMapProvider extends DataMapProvider {
    public SunbakedDataMapProvider(PackOutput packOutput, CompletableFuture<HolderLookup.Provider> lookupProvider) {
        super(packOutput, lookupProvider);
    }

    @Override
    protected void gather(HolderLookup.Provider provider) {
        this.builder(SunbakedDataMapTypes.STRIPPABLES)
                .add(SunbakedBlocks.AURUM_LOG, new Strippable(SunbakedBlocks.STRIPPED_AURUM_LOG.get()), false)
                .add(SunbakedBlocks.AURUM_WOOD, new Strippable(SunbakedBlocks.STRIPPED_AURUM_WOOD.get()), false)
        ;
    }
}
