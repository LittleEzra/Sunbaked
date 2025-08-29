package com.feliscape.sunbaked.registry;

import com.feliscape.sunbaked.Sunbaked;
import net.minecraft.world.level.block.state.properties.BlockSetType;

import static net.minecraft.world.level.block.state.properties.BlockSetType.register;

public class SunbakedBlockSetTypes {
    public static final BlockSetType AURUM = register(new BlockSetType(Sunbaked.stringLocation("aurum")));
}
