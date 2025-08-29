package com.feliscape.sunbaked;

import net.neoforged.neoforge.common.ModConfigSpec;

public class SunbakedServerConfig {
    private static final ModConfigSpec.Builder BUILDER = new ModConfigSpec.Builder();

    public static final SunbakedServerConfig CONFIG;
    public static final ModConfigSpec SPEC;

    public SunbakedServerConfig(ModConfigSpec.Builder builder){

    }

    static {
        var pair = BUILDER.configure(SunbakedServerConfig::new);

        CONFIG = pair.getLeft();
        SPEC = pair.getRight();
    }
}
