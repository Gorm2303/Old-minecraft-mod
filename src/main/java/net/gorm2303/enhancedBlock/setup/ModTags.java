package net.gorm2303.enhancedBlock.setup;

import net.gorm2303.enhancedBlock.EnhancedBlockMod;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ITag;
import net.minecraft.tags.ItemTags;
import net.minecraft.util.ResourceLocation;

public class ModTags {
    public static final class Blocks {
        public static final ITag.INamedTag<Block> ORES_SILVER = forge("ores/silver");
        public static final ITag.INamedTag<Block> STORAGE_BLOCKS_SILVER = forge("storage_blocks/silver");
        public static final ITag.INamedTag<Block> BLOCKS_STONES = forge("new_blocks/stones");

        private static ITag.INamedTag<Block> forge(String path) {
            return BlockTags.makeWrapperTag(new ResourceLocation("forge", path).toString());
        }

        private static ITag.INamedTag<Block> mod(String path) {
            return BlockTags.makeWrapperTag(new ResourceLocation(EnhancedBlockMod.MOD_ID, path).toString());
        }
    }

    public static final class Items {
        public static final ITag.INamedTag<Item> ORES_SILVER = forge("ores/silver");
        public static final ITag.INamedTag<Item> STORAGE_BLOCKS_SILVER = forge("storage_blocks/silver");
        public static final ITag.INamedTag<Item> BLOCKS_STONES = forge("new_blocks/stones");

        public static final ITag.INamedTag<Item> INGOTS_SILVER = forge("ingots/silver");
        public static final ITag.INamedTag<Item> PICKAXE_WOODEN = forge("pickaxe/wooden");
        public static final ITag.INamedTag<Item> PICKAXE_STONE = forge("pickaxe/stone");
        public static final ITag.INamedTag<Item> PICKAXE_IRON = forge("pickaxe/iron");
        public static final ITag.INamedTag<Item> PICKAXE_GOLDEN = forge("pickaxe/golden");
        public static final ITag.INamedTag<Item> PICKAXE_DIAMOND = forge("pickaxe/diamond");
        public static final ITag.INamedTag<Item> PICKAXE_NETHERITE = forge("pickaxe/netherite");

        public static final ITag.INamedTag<Item> SHOVEL_STONE = forge("shovel/stone");
        public static final ITag.INamedTag<Item> SHOVEL_IRON = forge("shovel/iron");
        public static final ITag.INamedTag<Item> SHOVEL_GOLDEN = forge("shovel/golden");
        public static final ITag.INamedTag<Item> SHOVEL_DIAMOND = forge("shovel/diamond");
        public static final ITag.INamedTag<Item> SHOVEL_NETHERITE = forge("shovel/netherite");

        public static final ITag.INamedTag<Item> AXE_STONE = forge("axe/stone");
        public static final ITag.INamedTag<Item> AXE_IRON = forge("axe/iron");
        public static final ITag.INamedTag<Item> AXE_GOLDEN = forge("axe/golden");
        public static final ITag.INamedTag<Item> AXE_DIAMOND = forge("axe/diamond");
        public static final ITag.INamedTag<Item> AXE_NETHERITE = forge("axe/netherite");

        private static ITag.INamedTag<Item> forge(String path) {
            return ItemTags.makeWrapperTag(new ResourceLocation("forge", path).toString());
        }

        private static ITag.INamedTag<Item> mod(String path) {
            return ItemTags.makeWrapperTag(new ResourceLocation(EnhancedBlockMod.MOD_ID, path).toString());
        }
    }
}
