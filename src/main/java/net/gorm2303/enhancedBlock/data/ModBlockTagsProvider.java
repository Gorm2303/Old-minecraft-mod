package net.gorm2303.enhancedBlock.data;

import net.gorm2303.enhancedBlock.EnhancedBlockMod;
import net.gorm2303.enhancedBlock.setup.ModBlocks;
import net.gorm2303.enhancedBlock.setup.ModTags;
import net.minecraft.data.BlockTagsProvider;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.ExistingFileHelper;

public class ModBlockTagsProvider extends BlockTagsProvider {
    public ModBlockTagsProvider(DataGenerator generatorIn, ExistingFileHelper existingFileHelper) {
        super(generatorIn, EnhancedBlockMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerTags() {
        getOrCreateBuilder(ModTags.Blocks.ORES_SILVER).add(ModBlocks.SILVER_ORE.get());
        getOrCreateBuilder(Tags.Blocks.ORES).addTag(ModTags.Blocks.ORES_SILVER);
        getOrCreateBuilder(ModTags.Blocks.STORAGE_BLOCKS_SILVER).add(ModBlocks.SILVER_BLOCK.get());
        getOrCreateBuilder(Tags.Blocks.STORAGE_BLOCKS).addTag(ModTags.Blocks.STORAGE_BLOCKS_SILVER);
        getOrCreateBuilder(ModTags.Blocks.BLOCKS_STONES).add(ModBlocks.STONE_ONE.get());
        getOrCreateBuilder(ModTags.Blocks.BLOCKS_STONES).add(ModBlocks.STONE_TWO.get());
        getOrCreateBuilder(ModTags.Blocks.BLOCKS_STONES).add(ModBlocks.STONE_THREE.get());
        getOrCreateBuilder(ModTags.Blocks.BLOCKS_STONES).add(ModBlocks.STONE_FOUR.get());
        getOrCreateBuilder(ModTags.Blocks.BLOCKS_STONES).add(ModBlocks.STONE_FIVE.get());
        getOrCreateBuilder(Tags.Blocks.STONE).addTag(ModTags.Blocks.BLOCKS_STONES);
    }
}
