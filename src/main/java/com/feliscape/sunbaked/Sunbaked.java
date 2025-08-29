package com.feliscape.sunbaked;

import com.feliscape.sunbaked.registry.SunbakedBlockEntityTypes;
import com.feliscape.sunbaked.registry.SunbakedBlocks;
import com.feliscape.sunbaked.registry.SunbakedCreativeModeTabs;
import com.feliscape.sunbaked.registry.SunbakedItems;
import net.minecraft.resources.ResourceLocation;
import org.slf4j.Logger;

import com.mojang.logging.LogUtils;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.server.ServerStartingEvent;

@Mod(Sunbaked.MOD_ID)
public class Sunbaked {
    public static final String MOD_ID = "sunbaked";
    public static final Logger LOGGER = LogUtils.getLogger();

    public Sunbaked(IEventBus modEventBus, ModContainer modContainer) {
        modEventBus.addListener(this::commonSetup);

        SunbakedBlocks.register(modEventBus);
        SunbakedBlockEntityTypes.register(modEventBus);

        SunbakedItems.register(modEventBus);
        SunbakedCreativeModeTabs.register(modEventBus);

        NeoForge.EVENT_BUS.register(this);

        modContainer.registerConfig(ModConfig.Type.SERVER, SunbakedServerConfig.SPEC);
    }


    public static String stringLocation(String path){
        return MOD_ID + ":" + path;
    }
    public static ResourceLocation location(String path){
        return ResourceLocation.fromNamespaceAndPath(MOD_ID, path);
    }

    private void commonSetup(FMLCommonSetupEvent event) {

    }

    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {

    }
}
