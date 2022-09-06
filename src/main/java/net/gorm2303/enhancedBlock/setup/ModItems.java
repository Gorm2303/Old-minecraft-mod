package net.gorm2303.enhancedBlock.setup;

import net.gorm2303.enhancedBlock.UltimateAxe;
import net.gorm2303.enhancedBlock.UltimatePickaxe;
import net.gorm2303.enhancedBlock.UltimateShovel;
import net.gorm2303.enhancedBlock.lists.ItemMaterialList;
import net.minecraft.block.material.Material;
import net.minecraft.item.*;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.loading.moddiscovery.ModAnnotation;

public class ModItems {
    public static final RegistryObject<Item> SILVER_INGOT = Registration.ITEMS.register("silver_ingot", () ->
            new Item(new Item.Properties().group(ItemGroup.MATERIALS)));

    public static final RegistryObject<UltimatePickaxe> ULTIMATE_WOODEN_PICKAXE = Registration.ITEMS.register("ultimate_wooden_pickaxe", () ->
            new UltimatePickaxe(ItemMaterialList.ultimate_wooden_pickaxe, 0, 0,
                    new Item.Properties().group(ItemGroup.TOOLS)));

    public static final RegistryObject<UltimatePickaxe> ULTIMATE_STONE_PICKAXE = Registration.ITEMS.register("ultimate_stone_pickaxe", () ->
            new UltimatePickaxe(ItemMaterialList.ultimate_stone_pickaxe, 0, 0,
                    new Item.Properties().group(ItemGroup.TOOLS)));
    public static final RegistryObject<UltimatePickaxe> ULTIMATE_IRON_PICKAXE = Registration.ITEMS.register("ultimate_iron_pickaxe", () ->
            new UltimatePickaxe(ItemMaterialList.ultimate_iron_pickaxe, 0, 0,
                    new Item.Properties().group(ItemGroup.TOOLS)));
    public static final RegistryObject<UltimatePickaxe> ULTIMATE_GOLDEN_PICKAXE = Registration.ITEMS.register("ultimate_golden_pickaxe", () ->
            new UltimatePickaxe(ItemMaterialList.ultimate_golden_pickaxe, 0, 0,
                    new Item.Properties().group(ItemGroup.TOOLS)));
    public static final RegistryObject<UltimatePickaxe> ULTIMATE_DIAMOND_PICKAXE = Registration.ITEMS.register("ultimate_diamond_pickaxe", () ->
            new UltimatePickaxe(ItemMaterialList.ultimate_diamond_pickaxe, 0, 0,
                    new Item.Properties().group(ItemGroup.TOOLS)));
    public static final RegistryObject<UltimatePickaxe> ULTIMATE_NETHERITE_PICKAXE = Registration.ITEMS.register("ultimate_netherite_pickaxe", () ->
            new UltimatePickaxe(ItemMaterialList.ultimate_netherite_pickaxe, 0, 0,
                    new Item.Properties().group(ItemGroup.TOOLS)));

    public static final RegistryObject<UltimateShovel> ULTIMATE_STONE_SHOVEL = Registration.ITEMS.register("ultimate_stone_shovel", () ->
            new UltimateShovel(ItemMaterialList.ultimate_stone_shovel, 0, 0,
                    new Item.Properties().group(ItemGroup.TOOLS)));
    public static final RegistryObject<UltimateShovel> ULTIMATE_IRON_SHOVEL = Registration.ITEMS.register("ultimate_iron_shovel", () ->
            new UltimateShovel(ItemMaterialList.ultimate_iron_shovel, 0, 0,
                    new Item.Properties().group(ItemGroup.TOOLS)));
    public static final RegistryObject<UltimateShovel> ULTIMATE_GOLDEN_SHOVEL = Registration.ITEMS.register("ultimate_golden_shovel", () ->
            new UltimateShovel(ItemMaterialList.ultimate_golden_shovel, 0, 0,
                    new Item.Properties().group(ItemGroup.TOOLS)));
    public static final RegistryObject<UltimateShovel> ULTIMATE_DIAMOND_SHOVEL = Registration.ITEMS.register("ultimate_diamond_shovel", () ->
            new UltimateShovel(ItemMaterialList.ultimate_diamond_shovel, 0, 0,
                    new Item.Properties().group(ItemGroup.TOOLS)));
    public static final RegistryObject<UltimateShovel> ULTIMATE_NETHERITE_SHOVEL = Registration.ITEMS.register("ultimate_netherite_shovel", () ->
            new UltimateShovel(ItemMaterialList.ultimate_netherite_shovel, 0, 0,
                    new Item.Properties().group(ItemGroup.TOOLS)));

    public static final RegistryObject<UltimateAxe> ULTIMATE_STONE_AXE = Registration.ITEMS.register("ultimate_stone_axe", () ->
            new UltimateAxe(ItemMaterialList.ultimate_stone_axe, 0, 0,
                    new Item.Properties().group(ItemGroup.TOOLS)));
    public static final RegistryObject<UltimateAxe> ULTIMATE_IRON_AXE = Registration.ITEMS.register("ultimate_iron_axe", () ->
            new UltimateAxe(ItemMaterialList.ultimate_iron_axe, 0, 0,
                    new Item.Properties().group(ItemGroup.TOOLS)));
    public static final RegistryObject<UltimateAxe> ULTIMATE_GOLDEN_AXE = Registration.ITEMS.register("ultimate_golden_axe", () ->
            new UltimateAxe(ItemMaterialList.ultimate_golden_axe, 0, 0,
                    new Item.Properties().group(ItemGroup.TOOLS)));
    public static final RegistryObject<UltimateAxe> ULTIMATE_DIAMOND_AXE = Registration.ITEMS.register("ultimate_diamond_axe", () ->
            new UltimateAxe(ItemMaterialList.ultimate_diamond_axe, 0, 0,
                    new Item.Properties().group(ItemGroup.TOOLS)));
    public static final RegistryObject<UltimateAxe> ULTIMATE_NETHERITE_AXE = Registration.ITEMS.register("ultimate_netherite_axe", () ->
            new UltimateAxe(ItemMaterialList.ultimate_netherite_axe, 0, 0,
                    new Item.Properties().group(ItemGroup.TOOLS)));

    static void register() {}
}
