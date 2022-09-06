package net.gorm2303.enhancedBlock.data;

import net.gorm2303.enhancedBlock.EnhancedBlockMod;
import net.gorm2303.enhancedBlock.setup.ModItems;
import net.gorm2303.enhancedBlock.setup.ModTags;
import net.minecraft.data.BlockTagsProvider;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.ItemTagsProvider;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.ExistingFileHelper;

public class ModItemTagsProvider extends ItemTagsProvider {
    public ModItemTagsProvider(DataGenerator dataGenerator, BlockTagsProvider blockTagProvider, ExistingFileHelper existingFileHelper) {
        super(dataGenerator, blockTagProvider, EnhancedBlockMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerTags() {
        copy(ModTags.Blocks.ORES_SILVER, ModTags.Items.ORES_SILVER);
        copy(Tags.Blocks.ORES, Tags.Items.ORES);
        copy(ModTags.Blocks.STORAGE_BLOCKS_SILVER, ModTags.Items.STORAGE_BLOCKS_SILVER);
        copy(Tags.Blocks.STORAGE_BLOCKS, Tags.Items.STORAGE_BLOCKS);
        copy(ModTags.Blocks.BLOCKS_STONES, ModTags.Items.BLOCKS_STONES);
        copy(Tags.Blocks.STONE, Tags.Items.STONE);


        getOrCreateBuilder(ModTags.Items.INGOTS_SILVER).add(ModItems.SILVER_INGOT.get());
        getOrCreateBuilder(Tags.Items.INGOTS).addTag(ModTags.Items.INGOTS_SILVER);

        getOrCreateBuilder(ModTags.Items.PICKAXE_WOODEN).add(ModItems.ULTIMATE_WOODEN_PICKAXE.get());
        getOrCreateBuilder(ModTags.Items.PICKAXE_STONE).add(ModItems.ULTIMATE_STONE_PICKAXE.get());
        getOrCreateBuilder(ModTags.Items.PICKAXE_IRON).add(ModItems.ULTIMATE_IRON_PICKAXE.get());
        getOrCreateBuilder(ModTags.Items.PICKAXE_GOLDEN).add(ModItems.ULTIMATE_GOLDEN_PICKAXE.get());
        getOrCreateBuilder(ModTags.Items.PICKAXE_DIAMOND).add(ModItems.ULTIMATE_DIAMOND_PICKAXE.get());
        getOrCreateBuilder(ModTags.Items.PICKAXE_NETHERITE).add(ModItems.ULTIMATE_NETHERITE_PICKAXE.get());

        getOrCreateBuilder(ModTags.Items.SHOVEL_STONE).add(ModItems.ULTIMATE_STONE_SHOVEL.get());
        getOrCreateBuilder(ModTags.Items.SHOVEL_IRON).add(ModItems.ULTIMATE_IRON_SHOVEL.get());
        getOrCreateBuilder(ModTags.Items.SHOVEL_GOLDEN).add(ModItems.ULTIMATE_GOLDEN_SHOVEL.get());
        getOrCreateBuilder(ModTags.Items.SHOVEL_DIAMOND).add(ModItems.ULTIMATE_DIAMOND_SHOVEL.get());
        getOrCreateBuilder(ModTags.Items.SHOVEL_NETHERITE).add(ModItems.ULTIMATE_NETHERITE_SHOVEL.get());

        getOrCreateBuilder(ModTags.Items.AXE_STONE).add(ModItems.ULTIMATE_STONE_AXE.get());
        getOrCreateBuilder(ModTags.Items.AXE_IRON).add(ModItems.ULTIMATE_IRON_AXE.get());
        getOrCreateBuilder(ModTags.Items.AXE_GOLDEN).add(ModItems.ULTIMATE_GOLDEN_AXE.get());
        getOrCreateBuilder(ModTags.Items.AXE_DIAMOND).add(ModItems.ULTIMATE_DIAMOND_AXE.get());
        getOrCreateBuilder(ModTags.Items.AXE_NETHERITE).add(ModItems.ULTIMATE_NETHERITE_AXE.get());

    }
}
