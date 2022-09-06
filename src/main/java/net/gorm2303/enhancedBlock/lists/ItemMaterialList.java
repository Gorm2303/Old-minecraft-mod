package net.gorm2303.enhancedBlock.lists;

import net.minecraft.item.IItemTier;
import net.minecraft.item.Item;
import net.minecraft.item.crafting.Ingredient;

import static net.gorm2303.enhancedBlock.lists.ItemList.*;

public enum ItemMaterialList implements IItemTier {
    ultimate_wooden_pickaxe(1, 2, 1500,0, 5, stone_one),
    ultimate_stone_pickaxe(1, 4, 4000,0, 5, stone_one),
    ultimate_iron_pickaxe(1, 5, 8000,0, 14, stone_two),
    ultimate_golden_pickaxe(1, 6, 10000,1, 22, stone_three),
    ultimate_diamond_pickaxe(1, 7, 20000,3, 10, stone_four),
    ultimate_netherite_pickaxe(1, 8, 59050,3, 15, stone_five),

    ultimate_stone_shovel(3, 4, 4000,0, 5, stone_one),
    ultimate_iron_shovel(4, 5, 8000,0, 14, stone_two),
    ultimate_golden_shovel(5, 6, 10000,1, 22, stone_three),
    ultimate_diamond_shovel(6, 7, 20000,3, 10, stone_four),
    ultimate_netherite_shovel(7, 8, 59050,3, 15, stone_five),

    ultimate_stone_axe(9, 4, 4000,0, 5, stone_one),
    ultimate_iron_axe(9, 5, 8000,0, 14, stone_two),
    ultimate_golden_axe(9, 6, 10000,1, 22, stone_three),
    ultimate_diamond_axe(9, 7, 20000,3, 10, stone_four),
    ultimate_netherite_axe(10, 8, 59050,3, 15, stone_five);

    private float attackDamage;
    private float efficiency;
    private int durability;
    private int harvestLevel;
    private int enchantability;
    private Item repairMaterial;

    private ItemMaterialList(float attackDamage, float efficiency, int durability, int harvestLevel, int enchantability, Item repairMaterial) {
        this.attackDamage = attackDamage;
        this.efficiency = efficiency;
        this.durability = durability;
        this.harvestLevel = harvestLevel;
        this.enchantability = enchantability;
        this.repairMaterial = repairMaterial;
    }

    @Override
    public int getMaxUses() {
        return durability;
    }

    @Override
    public float getEfficiency() {
        return efficiency;
    }

    @Override
    public float getAttackDamage() {
        return attackDamage;
    }

    @Override
    public int getHarvestLevel() {
        return harvestLevel;
    }

    @Override
    public int getEnchantability() {
        return enchantability;
    }

    @Override
    public Ingredient getRepairMaterial() {
        return Ingredient.fromItems(repairMaterial);
    }
}
