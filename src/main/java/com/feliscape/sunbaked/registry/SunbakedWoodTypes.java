package com.feliscape.sunbaked.registry;

import com.feliscape.sunbaked.Sunbaked;
import net.minecraft.world.level.block.state.properties.WoodType;

public class SunbakedWoodTypes {
    public static final WoodType AURUM = WoodType.register(new WoodType(Sunbaked.stringLocation("aurum"), SunbakedBlockSetTypes.AURUM));
}
