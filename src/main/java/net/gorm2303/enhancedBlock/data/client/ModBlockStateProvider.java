package net.gorm2303.enhancedBlock.data.client;

import net.gorm2303.enhancedBlock.EnhancedBlockMod;
import net.gorm2303.enhancedBlock.setup.ModBlocks;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(DataGenerator gen, ExistingFileHelper exFileHelper) {
        super(gen, EnhancedBlockMod.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        simpleBlock(ModBlocks.SILVER_BLOCK.get());
        simpleBlock(ModBlocks.SILVER_ORE.get());
        simpleBlock(ModBlocks.STONE_ONE.get());
        simpleBlock(ModBlocks.STONE_TWO.get());
        simpleBlock(ModBlocks.STONE_THREE.get());
        simpleBlock(ModBlocks.STONE_FOUR.get());
        simpleBlock(ModBlocks.STONE_FIVE.get());

    }
}
