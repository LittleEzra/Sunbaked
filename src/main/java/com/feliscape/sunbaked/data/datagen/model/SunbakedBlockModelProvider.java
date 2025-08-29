package com.feliscape.sunbaked.data.datagen.model;

import com.feliscape.sunbaked.Sunbaked;
import com.feliscape.sunbaked.registry.SunbakedBlocks;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.client.model.generators.ConfiguredModel;
import net.neoforged.neoforge.client.model.generators.ModelFile;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

import java.util.function.Supplier;

public class SunbakedBlockModelProvider extends BlockStateProvider {
    public SunbakedBlockModelProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, Sunbaked.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {

        leavesBlock(SunbakedBlocks.AURUM_LEAVES, "cutout_mipped");

        ResourceLocation aurumLogTexture = blockTexture(SunbakedBlocks.AURUM_LOG.get());
        ResourceLocation strippedAurumLogTexture = blockTexture(SunbakedBlocks.STRIPPED_AURUM_LOG.get());
        ResourceLocation aurumPlanksTexture = blockTexture(SunbakedBlocks.AURUM_PLANKS.get());

        signBlock(SunbakedBlocks.AURUM_SIGN.get(), SunbakedBlocks.AURUM_WALL_SIGN.get(),
                aurumPlanksTexture);
        hangingSignBlock(SunbakedBlocks.AURUM_HANGING_SIGN.get(), SunbakedBlocks.AURUM_WALL_HANGING_SIGN.get(),
                aurumPlanksTexture);

        logBlock(SunbakedBlocks.AURUM_LOG.get());
        axisBlock(SunbakedBlocks.AURUM_WOOD.get(), aurumLogTexture, aurumLogTexture);
        logBlock(SunbakedBlocks.STRIPPED_AURUM_LOG.get());
        axisBlock(SunbakedBlocks.STRIPPED_AURUM_WOOD.get(), strippedAurumLogTexture, strippedAurumLogTexture);

        blockWithItem(SunbakedBlocks.AURUM_PLANKS);

        stairsBlock(SunbakedBlocks.AURUM_STAIRS.get(), aurumPlanksTexture);
        slabBlock(SunbakedBlocks.AURUM_SLAB.get(), aurumPlanksTexture, aurumPlanksTexture);
        buttonBlock(SunbakedBlocks.AURUM_BUTTON.get(), aurumPlanksTexture);
        pressurePlateBlock(SunbakedBlocks.AURUM_PRESSURE_PLATE.get(), aurumPlanksTexture);
        fenceBlock(SunbakedBlocks.AURUM_FENCE.get(), aurumPlanksTexture);
        fenceGateBlock(SunbakedBlocks.AURUM_FENCE_GATE.get(), aurumPlanksTexture);

        doorBlockWithRenderType(SunbakedBlocks.AURUM_DOOR.get(), modLoc("block/aurum_door_bottom"), modLoc("block/aurum_door_top"), "cutout");
        trapdoorBlockWithRenderType(SunbakedBlocks.AURUM_TRAPDOOR.get(), modLoc("block/aurum_trapdoor"), true, "cutout");
    }

    private void blockWithItem(Supplier<? extends Block> block){
        simpleBlockWithItem(block.get(), cubeAll(block.get()));
    }
    private void blockWithItem(Supplier<? extends Block> block, String renderType){
        simpleBlockWithItem(block.get(), models().cubeAll(this.name(block.get()), this.blockTexture(block.get())).renderType(renderType));
    }

    private void leavesBlock(Supplier<? extends Block> block, String renderType){
        ModelFile model = models().withExistingParent(getLocation(block).getPath(), "minecraft:block/leaves")
                .texture("all", blockTexture(block.get())).renderType(renderType);
        getVariantBuilder(block.get())
                .partialState().setModels( new ConfiguredModel(model));
        simpleBlockItem(block.get(), model);
    }

    public void crossBlockWithRenderType(Block block, String renderType) {
        getVariantBuilder(block).partialState().setModels(new ConfiguredModel(models().cross(name(block), blockTexture(block)).renderType(renderType)));
    }

    private String name(Block block) {
        return this.getLocation(block).getPath();
    }

    private ResourceLocation getLocation(Supplier<? extends Block> block){
        return BuiltInRegistries.BLOCK.getKey(block.get());
    }
    private ResourceLocation getLocation(Block block){
        return BuiltInRegistries.BLOCK.getKey(block);
    }

    private ResourceLocation extend(ResourceLocation location, String suffix) {
        String namespace = location.getNamespace();
        String path = location.getPath();
        return ResourceLocation.fromNamespaceAndPath(namespace, path + suffix);
    }
}
