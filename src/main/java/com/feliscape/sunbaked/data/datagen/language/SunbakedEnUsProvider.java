package com.feliscape.sunbaked.data.datagen.language;

import com.feliscape.sunbaked.registry.SunbakedBlocks;
import com.feliscape.sunbaked.registry.SunbakedItems;
import net.minecraft.data.PackOutput;

public class SunbakedEnUsProvider extends SunbakedLanguageProvider{
    public SunbakedEnUsProvider(PackOutput output) {
        super(output, "en_us");
    }

    @Override
    protected void addTranslations() {
        this.addItem(SunbakedItems.CRISP_APPLE, "Crisp Apple");

        this.addItem(SunbakedItems.AURUM_SIGN, "Aurum Sign");
        this.addItem(SunbakedItems.AURUM_HANGING_SIGN, "Aurum Hanging Sign");

        this.addBlock(SunbakedBlocks.AURUM_LEAVES, "Aurum Leaves");
        this.addBlock(SunbakedBlocks.AURUM_LOG, "Aurum Log");
        this.addBlock(SunbakedBlocks.AURUM_WOOD, "Aurum Wood");
        this.addBlock(SunbakedBlocks.STRIPPED_AURUM_LOG, "Stripped Aurum Log");
        this.addBlock(SunbakedBlocks.STRIPPED_AURUM_WOOD, "Stripped Aurum Wood");
        this.addBlock(SunbakedBlocks.AURUM_PLANKS, "Aurum Planks");
        this.addBlock(SunbakedBlocks.AURUM_STAIRS, "Aurum Stairs");
        this.addBlock(SunbakedBlocks.AURUM_SLAB, "Aurum Slab");
        this.addBlock(SunbakedBlocks.AURUM_BUTTON, "Aurum Button");
        this.addBlock(SunbakedBlocks.AURUM_PRESSURE_PLATE, "Aurum Pressure Plate");
        this.addBlock(SunbakedBlocks.AURUM_FENCE, "Aurum Fence");
        this.addBlock(SunbakedBlocks.AURUM_FENCE_GATE, "Aurum Fence Gate");

        this.add("block.artistry.aurum_wall_sign", "Aurum Wall Sign");
        this.add("block.artistry.aurum_wall_hanging_sign", "Aurum Wall Hanging Sign");

        this.addBlock(SunbakedBlocks.AURUM_DOOR, "Aurum Door");
        this.addBlock(SunbakedBlocks.AURUM_TRAPDOOR, "Aurum Trapdoor");
        //this.addBlock(SunbakedBlocks.AURUM_SAPLING, "Aurum Sapling");
        //this.addBlock(SunbakedBlocks.POTTED_AURUM_SAPLING, "Potted Aurum Sapling");

        this.add("itemGroup.sunbaked.base", "Sunbaked");
    }
}
