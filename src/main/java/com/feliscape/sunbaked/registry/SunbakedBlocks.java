package com.feliscape.sunbaked.registry;

import com.feliscape.sunbaked.Sunbaked;
import com.feliscape.sunbaked.content.block.ModHangingSignBlock;
import com.feliscape.sunbaked.content.block.ModStandingSignBlock;
import com.feliscape.sunbaked.content.block.ModWallHangingSignBlock;
import com.feliscape.sunbaked.content.block.ModWallSignBlock;
import com.feliscape.sunbaked.content.block.flammable.*;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Function;

public class SunbakedBlocks {
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(Sunbaked.MOD_ID);


    public static final DeferredBlock<FlammableLeavesBlock> AURUM_LEAVES = registerBlockWithItem("aurum_leaves",
            p -> flammableLeaves(p, SoundType.GRASS));

    public static final DeferredBlock<FlammableLogBlock> AURUM_LOG = registerBlockWithItem("aurum_log",
            p -> log(p, MapColor.SAND, MapColor.SNOW));
    public static final DeferredBlock<FlammableLogBlock> AURUM_WOOD = registerBlockWithItem("aurum_wood",
            p -> log(p, MapColor.SNOW, MapColor.SNOW));
    public static final DeferredBlock<FlammableLogBlock> STRIPPED_AURUM_LOG = registerBlockWithItem("stripped_aurum_log",
            p -> log(p, MapColor.SAND, MapColor.SAND));
    public static final DeferredBlock<FlammableLogBlock> STRIPPED_AURUM_WOOD = registerBlockWithItem("stripped_aurum_wood",
            p -> log(p, MapColor.SAND, MapColor.SAND));

    public static final DeferredBlock<FlammableBlock> AURUM_PLANKS = registerBlockWithItem("aurum_planks",
            p -> new FlammableBlock(p
                    .mapColor(MapColor.WOOD)
                    .instrument(NoteBlockInstrument.BASS)
                    .strength(2.0F, 3.0F)
                    .sound(SoundType.WOOD)
                    .ignitedByLava()
            ));

    public static final DeferredBlock<ModStandingSignBlock> AURUM_SIGN = BLOCKS.registerBlock("aurum_sign",
            p -> new ModStandingSignBlock(SunbakedWoodTypes.AURUM, p
                    .mapColor(MapColor.SAND)
                    .forceSolidOn()
                    .instrument(NoteBlockInstrument.BASS)
                    .noCollission()
                    .strength(1.0F)
                    .ignitedByLava()));
    public static final DeferredBlock<ModWallSignBlock> AURUM_WALL_SIGN = BLOCKS.registerBlock("aurum_wall_sign",
            p -> new ModWallSignBlock(SunbakedWoodTypes.AURUM, p
                    .mapColor(MapColor.SAND)
                    .forceSolidOn()
                    .instrument(NoteBlockInstrument.BASS)
                    .noCollission()
                    .strength(1.0F)
                    .ignitedByLava()));

    public static final DeferredBlock<ModHangingSignBlock> AURUM_HANGING_SIGN = BLOCKS.registerBlock("aurum_hanging_sign",
            p -> new ModHangingSignBlock(SunbakedWoodTypes.AURUM, p
                    .mapColor(MapColor.SAND)
                    .forceSolidOn()
                    .instrument(NoteBlockInstrument.BASS)
                    .noCollission()
                    .strength(1.0F)
                    .ignitedByLava()));
    public static final DeferredBlock<ModWallHangingSignBlock> AURUM_WALL_HANGING_SIGN = BLOCKS.registerBlock("aurum_wall_hanging_sign",
            p -> new ModWallHangingSignBlock(SunbakedWoodTypes.AURUM, p
                    .mapColor(MapColor.SAND)
                    .forceSolidOn()
                    .instrument(NoteBlockInstrument.BASS)
                    .noCollission()
                    .strength(1.0F)
                    .ignitedByLava()));

    public static final DeferredBlock<FlammableStairBlock> AURUM_STAIRS = registerBlockWithItem("aurum_stairs",
            p -> flammableStair(AURUM_PLANKS.get()));
    public static final DeferredBlock<FlammableSlabBlock> AURUM_SLAB = registerBlockWithItem("aurum_slab",
            p -> new FlammableSlabBlock(p
                    .mapColor(MapColor.WOOD)
                    .instrument(NoteBlockInstrument.BASS)
                    .strength(2.0F, 3.0F)
                    .sound(SoundType.WOOD)
                    .ignitedByLava()));

    public static final DeferredBlock<ButtonBlock> AURUM_BUTTON = registerBlockWithItem("aurum_button",
            p -> woodenButton(SunbakedBlockSetTypes.AURUM));
    public static final DeferredBlock<PressurePlateBlock> AURUM_PRESSURE_PLATE = registerBlockWithItem("aurum_pressure_plate",
            p -> new PressurePlateBlock(SunbakedBlockSetTypes.AURUM, p
                    .mapColor(AURUM_PLANKS.get().defaultMapColor())
                    .forceSolidOn()
                    .instrument(NoteBlockInstrument.BASS)
                    .noCollission()
                    .strength(0.5F)
                    .ignitedByLava()
                    .pushReaction(PushReaction.DESTROY)
            ));

    public static final DeferredBlock<FlammableFenceBlock> AURUM_FENCE = registerBlockWithItem("aurum_fence",
            p -> new FlammableFenceBlock(p
                    .mapColor(AURUM_PLANKS.get().defaultMapColor())
                    .instrument(NoteBlockInstrument.BASS)
                    .strength(2.0F, 3.0F)
                    .ignitedByLava()
                    .sound(SoundType.WOOD)
            ));
    public static final DeferredBlock<FlammableFenceGateBlock> AURUM_FENCE_GATE = registerBlockWithItem("aurum_fence_gate",
            p -> new FlammableFenceGateBlock(SunbakedWoodTypes.AURUM, p
                    .mapColor(AURUM_PLANKS.get().defaultMapColor())
                    .forceSolidOn()
                    .instrument(NoteBlockInstrument.BASS)
                    .strength(2.0F, 3.0F)
                    .ignitedByLava()));

    public static final DeferredBlock<FlammableDoorBlock> AURUM_DOOR = registerBlockWithItem("aurum_door",
            p -> new FlammableDoorBlock(SunbakedBlockSetTypes.AURUM, p
                    .mapColor(AURUM_PLANKS.get().defaultMapColor())
                    .instrument(NoteBlockInstrument.BASS)
                    .strength(3.0F)
                    .noOcclusion()
                    .ignitedByLava()
                    .pushReaction(PushReaction.DESTROY)));

    public static final DeferredBlock<FlammableTrapdoorBlock> AURUM_TRAPDOOR = registerBlockWithItem("aurum_trapdoor",
            p -> new FlammableTrapdoorBlock(SunbakedBlockSetTypes.AURUM, p
                    .mapColor(MapColor.WOOD)
                    .instrument(NoteBlockInstrument.BASS)
                    .strength(3.0F)
                    .noOcclusion()
                    .isValidSpawn(Blocks::never)
                    .ignitedByLava()));


    private static FlammableLogBlock log(BlockBehaviour.Properties properties, MapColor topMapColor, MapColor sideMapColor) {
        return new FlammableLogBlock(
                properties
                        .mapColor(state -> state.getValue(RotatedPillarBlock.AXIS) == Direction.Axis.Y ? topMapColor : sideMapColor)
                        .instrument(NoteBlockInstrument.BASS)
                        .strength(2.0F)
                        .sound(SoundType.WOOD)
                        .ignitedByLava()
        );
    }

    private static LeavesBlock leaves(BlockBehaviour.Properties properties, SoundType soundType) {
        return new LeavesBlock(
                properties
                        .mapColor(MapColor.PLANT)
                        .strength(0.2F)
                        .randomTicks()
                        .sound(soundType)
                        .noOcclusion()
                        .isValidSpawn(Blocks::ocelotOrParrot)
                        .isSuffocating(SunbakedBlocks::never)
                        .isViewBlocking(SunbakedBlocks::never)
                        .ignitedByLava()
                        .pushReaction(PushReaction.DESTROY)
                        .isRedstoneConductor(SunbakedBlocks::never)
        );
    }
    private static LeavesBlock leaves(BlockBehaviour.Properties properties, SoundType soundType, MapColor mapColor) {
        return new LeavesBlock(
                properties
                        .mapColor(mapColor)
                        .strength(0.2F)
                        .randomTicks()
                        .sound(soundType)
                        .noOcclusion()
                        .isValidSpawn(Blocks::ocelotOrParrot)
                        .isSuffocating(SunbakedBlocks::never)
                        .isViewBlocking(SunbakedBlocks::never)
                        .ignitedByLava()
                        .pushReaction(PushReaction.DESTROY)
                        .isRedstoneConductor(SunbakedBlocks::never)
        );
    }
    private static FlammableLeavesBlock flammableLeaves(BlockBehaviour.Properties properties, SoundType soundType) {
        return new FlammableLeavesBlock(
                properties
                        .mapColor(MapColor.PLANT)
                        .strength(0.2F)
                        .randomTicks()
                        .sound(soundType)
                        .noOcclusion()
                        .isValidSpawn(Blocks::ocelotOrParrot)
                        .isSuffocating(SunbakedBlocks::never)
                        .isViewBlocking(SunbakedBlocks::never)
                        .ignitedByLava()
                        .pushReaction(PushReaction.DESTROY)
                        .isRedstoneConductor(SunbakedBlocks::never)
        );
    }
    private static FlammableLeavesBlock flammableLeaves(BlockBehaviour.Properties properties, SoundType soundType, MapColor mapColor) {
        return new FlammableLeavesBlock(
                properties
                        .mapColor(mapColor)
                        .strength(0.2F)
                        .randomTicks()
                        .sound(soundType)
                        .noOcclusion()
                        .isValidSpawn(Blocks::ocelotOrParrot)
                        .isSuffocating(SunbakedBlocks::never)
                        .isViewBlocking(SunbakedBlocks::never)
                        .ignitedByLava()
                        .pushReaction(PushReaction.DESTROY)
                        .isRedstoneConductor(SunbakedBlocks::never)
        );
    }

    private static boolean always(BlockState state, BlockGetter blockGetter, BlockPos pos) {
        return true;
    }

    private static boolean never(BlockState state, BlockGetter blockGetter, BlockPos pos) {
        return false;
    }

    private static FlammableStairBlock flammableStair(Block baseBlock) {
        return new FlammableStairBlock(baseBlock.defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(baseBlock));
    }

    private static ButtonBlock woodenButton(BlockSetType type) {
        return new ButtonBlock(type, 30, BlockBehaviour.Properties.of().noCollission().strength(0.5F).pushReaction(PushReaction.DESTROY));
    }

    private static <T extends Block> DeferredBlock<T> registerBlockWithItem(String name, Function<BlockBehaviour.Properties, ? extends T> block)
    {
        DeferredBlock<T> toReturn = BLOCKS.registerBlock(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> DeferredItem<Item> registerBlockItem(String name, DeferredBlock<T> block)
    {
        return SunbakedItems.ITEMS.registerItem(name, p -> new BlockItem(block.get(), p));
    }

    public static void register(IEventBus eventBus){
        BLOCKS.register(eventBus);
    }
}
