package net.gorm2303.enhancedBlock.data.client;

import net.gorm2303.enhancedBlock.EnhancedBlockMod;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(DataGenerator generator, ExistingFileHelper existingFileHelper) {
        super(generator, EnhancedBlockMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        withExistingParent("silver_block", modLoc("block/silver_block"));
        withExistingParent("silver_ore", modLoc("block/silver_ore"));

        withExistingParent("stone_one", modLoc("block/stone_one"));
        withExistingParent("stone_two", modLoc("block/stone_two"));
        withExistingParent("stone_three", modLoc("block/stone_three"));
        withExistingParent("stone_four", modLoc("block/stone_four"));
        withExistingParent("stone_five", modLoc("block/stone_five"));

        ModelFile itemGenerated = getExistingFile(mcLoc("item/generated"));

        builder(itemGenerated, "silver_ingot");

        ModelFile itemGenerated2 = getExistingFile(mcLoc("item/handheld"));

        builder(itemGenerated2,"ultimate_wooden_pickaxe");
        builder(itemGenerated2,"ultimate_stone_pickaxe");
        builder(itemGenerated2,"ultimate_iron_pickaxe");
        builder(itemGenerated2,"ultimate_golden_pickaxe");
        builder(itemGenerated2,"ultimate_diamond_pickaxe");
        builder(itemGenerated2,"ultimate_netherite_pickaxe");

        builder(itemGenerated2,"ultimate_stone_shovel");
        builder(itemGenerated2,"ultimate_iron_shovel");
        builder(itemGenerated2,"ultimate_golden_shovel");
        builder(itemGenerated2,"ultimate_diamond_shovel");
        builder(itemGenerated2,"ultimate_netherite_shovel");

        builder(itemGenerated2,"ultimate_stone_axe");
        builder(itemGenerated2,"ultimate_iron_axe");
        builder(itemGenerated2,"ultimate_golden_axe");
        builder(itemGenerated2,"ultimate_diamond_axe");
        builder(itemGenerated2,"ultimate_netherite_axe");

    }

    private ItemModelBuilder builder(ModelFile itemGenerated, String name) {
        return getBuilder(name).parent(itemGenerated).texture("layer0", "item/" + name);
    }
}
