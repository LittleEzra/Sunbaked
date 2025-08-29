package com.feliscape.sunbaked.content.block.flammable;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.TrapDoorBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockSetType;

public class FlammableTrapdoorBlock extends TrapDoorBlock {
    private final int fireSpreadSpeed;
    private final int flammability;

    public FlammableTrapdoorBlock(BlockSetType type, Properties properties) {
        this(type, properties, 5, 20);
    }
    public FlammableTrapdoorBlock(BlockSetType type, Properties properties, int fireSpreadSpeed, int flammability) {
        super(type, properties);
        this.fireSpreadSpeed = fireSpreadSpeed;
        this.flammability = flammability;
    }

    @Override
    public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
        return fireSpreadSpeed;
    }

    @Override
    public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
        return flammability;
    }
}
