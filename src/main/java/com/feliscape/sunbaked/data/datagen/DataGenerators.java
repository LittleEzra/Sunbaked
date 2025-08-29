package com.feliscape.sunbaked.data.datagen;

import com.feliscape.sunbaked.Sunbaked;
import com.feliscape.sunbaked.data.datagen.language.SunbakedEnUsProvider;
import com.feliscape.sunbaked.data.datagen.map.SunbakedDataMapProvider;
import com.feliscape.sunbaked.data.datagen.model.SunbakedBlockModelProvider;
import com.feliscape.sunbaked.data.datagen.model.SunbakedItemModelProvider;
import com.feliscape.sunbaked.data.datagen.tag.SunbakedBlockTagGenerator;
import com.feliscape.sunbaked.data.datagen.tag.SunbakedItemTagGenerator;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.data.event.GatherDataEvent;

import java.util.concurrent.CompletableFuture;

@EventBusSubscriber(modid = Sunbaked.MOD_ID)
public class DataGenerators {
    @SubscribeEvent
    public static void gatherClientData(GatherDataEvent event){
        DataGenerator generator = event.getGenerator();
        PackOutput packOutput = generator.getPackOutput();
        ExistingFileHelper existingFileHelper = event.getExistingFileHelper();
        CompletableFuture<HolderLookup.Provider> lookupProvider = event.getLookupProvider();

        SunbakedGeneratedEntries generatedEntries = new SunbakedGeneratedEntries(packOutput, lookupProvider);
        lookupProvider = generatedEntries.getRegistryProvider();
        generator.addProvider(true, generatedEntries);

        //generator.addProvider(true, new SunbakedRecipeProvider(packOutput, lookupProvider));

        var blockTags = new SunbakedBlockTagGenerator(packOutput, lookupProvider, existingFileHelper);
        generator.addProvider(true, blockTags);
        generator.addProvider(true, new SunbakedItemTagGenerator(packOutput, lookupProvider, existingFileHelper, blockTags.contentsGetter()));
        //generator.addProvider(true, new SunbakedEntityTypeTagGenerator(packOutput, lookupProvider, existingFileHelper));
        //generator.addProvider(true, new SunbakedMobEffectTagGenerator(packOutput, lookupProvider, existingFileHelper));
        //generator.addProvider(true, new SunbakedDamageTypeTagGenerator(packOutput, lookupProvider, existingFileHelper));

        generator.addProvider(true, new SunbakedDataMapProvider(packOutput, lookupProvider));

        //generator.addProvider(event.includeServer(), new SunbakedAdvancementProvider(packOutput, lookupProvider, existingFileHelper));

        //generator.addProvider(event.includeServer(), new SunbakedLootTableProvider(packOutput, lookupProvider));
        //generator.addProvider(event.includeServer(), new SunbakedGlobalLootModifierProvider(packOutput, lookupProvider));

        generator.addProvider(true, new SunbakedBlockModelProvider(packOutput, existingFileHelper));
        generator.addProvider(true, new SunbakedItemModelProvider(packOutput, existingFileHelper));

        generator.addProvider(true, new SunbakedEnUsProvider(packOutput));
    }
}
