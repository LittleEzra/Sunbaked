package com.feliscape.sunbaked.data.datagen.model;

import com.feliscape.sunbaked.Sunbaked;
import com.feliscape.sunbaked.registry.SunbakedBlocks;
import com.feliscape.sunbaked.registry.SunbakedItems;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.client.model.generators.ItemModelBuilder;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

import java.util.function.Supplier;

public class SunbakedItemModelProvider extends ItemModelProvider {
    public SunbakedItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, Sunbaked.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        simpleItem(SunbakedItems.CRISP_APPLE);

        // Aspen

        manualBlockItem(SunbakedBlocks.AURUM_LOG);
        manualBlockItem(SunbakedBlocks.AURUM_WOOD);
        manualBlockItem(SunbakedBlocks.STRIPPED_AURUM_LOG);
        manualBlockItem(SunbakedBlocks.STRIPPED_AURUM_WOOD);

        manualBlockItem(SunbakedBlocks.AURUM_STAIRS);
        manualBlockItem(SunbakedBlocks.AURUM_SLAB);
        manualBlockItem(SunbakedBlocks.AURUM_PRESSURE_PLATE);
        manualBlockItem(SunbakedBlocks.AURUM_FENCE_GATE);
        buttonItem(SunbakedBlocks.AURUM_BUTTON, SunbakedBlocks.AURUM_PLANKS);
        fenceItem(SunbakedBlocks.AURUM_FENCE, SunbakedBlocks.AURUM_PLANKS);
        trapdoorItem(SunbakedBlocks.AURUM_TRAPDOOR);

        //generatedBlockItem(SunbakedBlocks.AURUM_SAPLING);

        simpleItem(SunbakedItems.AURUM_SIGN);
        simpleItem(SunbakedItems.AURUM_HANGING_SIGN);
        //simpleItem(SunbakedItems.AURUM_BOAT);
        //simpleItem(SunbakedItems.AURUM_CHEST_BOAT);
    }
    
    private ItemModelBuilder simpleItem(Supplier<? extends Item> item){
        return withExistingParent(getLocation(item.get()).getPath(),
                ResourceLocation.withDefaultNamespace("item/generated"))
                .texture("layer0", Sunbaked.location("item/" + getLocation(item.get()).getPath()));
    }
    private ItemModelBuilder simpleDoubleLayered(Supplier<? extends Item> item){
        return withExistingParent(getLocation(item.get()).getPath(),
                ResourceLocation.withDefaultNamespace("item/generated"))
                .texture("layer0", Sunbaked.location("item/" + getLocation(item.get()).getPath()))
                .texture("layer1", Sunbaked.location("item/" + getLocation(item.get()).getPath() + "_overlay"))
                ;
    }
    private ItemModelBuilder handheldItem(Supplier<? extends Item> item){
        return withExistingParent(getLocation(item.get()).getPath(),
                ResourceLocation.withDefaultNamespace("item/handheld"))
                .texture("layer0", Sunbaked.location("item/" + getLocation(item.get()).getPath()));
    }
    private ItemModelBuilder rotatedHandheldItem(Supplier<? extends Item> item){
        return withExistingParent(getLocation(item.get()).getPath(),
                Sunbaked.location("item/rotated_handheld"))
                .texture("layer0", Sunbaked.location("item/" + getLocation(item.get()).getPath()));
    }
    private ItemModelBuilder itemWithBlockTexture(Supplier<? extends Item> item){
        return withExistingParent(getLocation(item.get()).getPath(),
                ResourceLocation.withDefaultNamespace("item/generated"))
                .texture("layer0", Sunbaked.location("block/" + getLocation(item.get()).getPath()));
    }

    public void manualBlockItem(Supplier<? extends Block> block) {
        this.withExistingParent(Sunbaked.MOD_ID + ":" + BuiltInRegistries.BLOCK.getKey(block.get()).getPath(),
                modLoc("block/" + BuiltInRegistries.BLOCK.getKey(block.get()).getPath()));
    }

    public void trapdoorItem(Supplier<? extends Block> block) {
        this.withExistingParent(BuiltInRegistries.BLOCK.getKey(block.get()).getPath(),
                modLoc("block/" + BuiltInRegistries.BLOCK.getKey(block.get()).getPath() + "_bottom"));
    }

    public void fenceItem(Supplier<? extends Block> block, Supplier<? extends Block> baseBlock) {
        this.withExistingParent(BuiltInRegistries.BLOCK.getKey(block.get()).getPath(), mcLoc("block/fence_inventory"))
                .texture("texture",  Sunbaked.location("block/" + BuiltInRegistries.BLOCK.getKey(baseBlock.get()).getPath()));
    }

    public void buttonItem(Supplier<? extends Block> block, Supplier<? extends Block> baseBlock) {
        this.withExistingParent(BuiltInRegistries.BLOCK.getKey(block.get()).getPath(), mcLoc("block/button_inventory"))
                .texture("texture",  Sunbaked.location("block/" + BuiltInRegistries.BLOCK.getKey(baseBlock.get()).getPath()));
    }

    public void wallItem(Supplier<? extends Block> block, Supplier<? extends Block> baseBlock) {
        this.withExistingParent(BuiltInRegistries.BLOCK.getKey(block.get()).getPath(), mcLoc("block/wall_inventory"))
                .texture("wall",  Sunbaked.location("block/" + BuiltInRegistries.BLOCK.getKey(baseBlock.get()).getPath()));
    }
    public void minecraftBasedWallItem(Supplier<? extends Block> block, Block baseBlock) {
        this.withExistingParent(BuiltInRegistries.BLOCK.getKey(block.get()).getPath(), mcLoc("block/wall_inventory"))
                .texture("wall",  ResourceLocation.withDefaultNamespace("block/" + BuiltInRegistries.BLOCK.getKey(baseBlock).getPath()));
    }

    private ItemModelBuilder blockItemSprite(Supplier<? extends Block> block) { // Uses a block instead of item with a unique item texture (Example: Doors or Lanterns)
        return withExistingParent(getBlockLocation(block.get()).getPath(),
                ResourceLocation.withDefaultNamespace("item/generated")).texture("layer0",
                Sunbaked.location("item/" + getBlockLocation(block.get()).getPath()));
    }
    private ItemModelBuilder blockItemSprite(Supplier<? extends Block> block, ResourceLocation texture) { // Uses a block instead of item with a unique item texture (Example: Doors or Lanterns)
        return withExistingParent(getBlockLocation(block.get()).getPath(),
                ResourceLocation.withDefaultNamespace("item/generated")).texture("layer0", texture);
    }
    private ItemModelBuilder blockItemSpriteLayered(Supplier<? extends Block> block) { // Uses a block instead of item with a unique item texture (Example: Doors or Lanterns)
        return withExistingParent(getBlockLocation(block.get()).getPath(),
                ResourceLocation.withDefaultNamespace("item/generated"))
                .texture("layer0", Sunbaked.location("item/" + getBlockLocation(block.get()).getPath()))
                .texture("layer1", Sunbaked.location("item/" + getBlockLocation(block.get()).getPath()) + "_overlay")
                ;
    }
    private ItemModelBuilder generatedBlockItem(Supplier<? extends Block> block) { // Uses the texture from textures/block (Example: Saplings or Torches)
        return withExistingParent(getBlockLocation(block.get()).getPath(),
                ResourceLocation.withDefaultNamespace("item/generated")).texture("layer0",
                Sunbaked.location("block/" + getBlockLocation(block.get()).getPath()));
    }
    private ItemModelBuilder generatedBlockItem(Supplier<? extends Block> block, ResourceLocation sprite) { // Uses the texture from textures/block (Example: Saplings or Torches)
        return withExistingParent(getBlockLocation(block.get()).getPath(),
                ResourceLocation.withDefaultNamespace("item/generated")).texture("layer0",
                sprite);
    }

    private ResourceLocation getLocation(Supplier<? extends Item> item){
        return BuiltInRegistries.ITEM.getKey(item.get());
    }
    private ResourceLocation getLocation(Item item){
        return BuiltInRegistries.ITEM.getKey(item);
    }

    private ResourceLocation getBlockLocation(Supplier<? extends Block> block){
        return BuiltInRegistries.BLOCK.getKey(block.get());
    }
    private ResourceLocation getBlockLocation(Block block){
        return BuiltInRegistries.BLOCK.getKey(block);
    }

    private ResourceLocation blockTexture(Supplier<? extends Block> block){
        ResourceLocation location = getBlockLocation(block);
        return ResourceLocation.fromNamespaceAndPath(location.getNamespace(), "block/" + location.getPath());
    }
    private ResourceLocation blockTexture(Block block){
        ResourceLocation location = getBlockLocation(block);
        return ResourceLocation.fromNamespaceAndPath(location.getNamespace(), "block/" + location.getPath());
    }

    private ResourceLocation getBlockItemSpriteLocation(Supplier<? extends Block> block){
        return Sunbaked.location("item/" + getBlockLocation(block.get()).getPath());
    }
}
