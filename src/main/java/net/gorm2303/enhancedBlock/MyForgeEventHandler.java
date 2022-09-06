package net.gorm2303.enhancedBlock;

import net.gorm2303.enhancedBlock.setup.ModItems;

import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.entity.item.ExperienceOrbEntity;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.*;
import java.util.stream.Stream;

import static net.minecraftforge.common.ToolType.*;

@Mod.EventBusSubscriber(modid = EnhancedBlockMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)

public class MyForgeEventHandler {

    private static Stream<BlockPos> blockList;
    private static int radius;
    private static BlockPos eventPos;
    private static BlockPos firstPos;
    private static BlockPos secondPos;
    private static ArrayList<BlockPos> destroyList = new ArrayList<>();
    private static PlayerEntity player;
    private static World world;
    private static ItemStack usedItem;
    private static int stoneAmount = 0, dirtAmount = 0, sandAmount = 0, gravelAmount = 0, dioriteAmount = 0, graniteAmount = 0, sandstoneAmount = 0, andesiteAmount = 0;
    private static int entitiesSpawned = 0;

    public static PlayerEntity getPlayer() {
        return player;
    }

    public static BlockPos getEventPos() {
        return eventPos;
    }

/*
    @SubscribeEvent
    public void dropBlock(BlockDropItemEvent event) {
        blockList.forEach(blockPos -> breakEvent.getState().getDrops());

        event.getItems();
    }

 */


    @SubscribeEvent
    public void onBlockBreakWithPickaxeEvent(BlockEvent.BreakEvent e) {
        System.out.println("A block just broke! :D");
        // Break all blocks in a specific cube.
        // Maybe Look for item in hand.

        Item stonePickaxe = ModItems.ULTIMATE_STONE_PICKAXE.get();
        Item ironPickaxe = ModItems.ULTIMATE_IRON_PICKAXE.get();
        Item goldenPickaxe = ModItems.ULTIMATE_GOLDEN_PICKAXE.get();
        Item diamondPickaxe = ModItems.ULTIMATE_DIAMOND_PICKAXE.get();
        Item netheritePickaxe = ModItems.ULTIMATE_NETHERITE_PICKAXE.get();

        Item stoneAxe = ModItems.ULTIMATE_STONE_AXE.get();
        Item ironAxe = ModItems.ULTIMATE_IRON_AXE.get();
        Item goldenAxe = ModItems.ULTIMATE_GOLDEN_AXE.get();
        Item diamondAxe = ModItems.ULTIMATE_DIAMOND_AXE.get();
        Item netheriteAxe = ModItems.ULTIMATE_NETHERITE_AXE.get();

        Item stoneShovel = ModItems.ULTIMATE_STONE_SHOVEL.get();
        Item ironShovel = ModItems.ULTIMATE_IRON_SHOVEL.get();
        Item goldenShovel = ModItems.ULTIMATE_GOLDEN_SHOVEL.get();
        Item diamondShovel = ModItems.ULTIMATE_DIAMOND_SHOVEL.get();
        Item netheriteShovel = ModItems.ULTIMATE_NETHERITE_SHOVEL.get();

        player = e.getPlayer();
        world = e.getPlayer().world;
        usedItem = player.getHeldItemMainhand();

        int bonusX;
        int bonusY;
        int bonusZ;

        // Maybe change bonus with enchantment
        if (usedItem.getItem().equals(stonePickaxe) || usedItem.getItem().equals(stoneAxe) || usedItem.getItem().equals(stoneShovel)) {
            radius = 2;
            bonusX = 2;
            bonusY = 3;
            bonusZ = 2;

        } else if (usedItem.getItem().equals(ironPickaxe) || usedItem.getItem().equals(ironAxe) || usedItem.getItem().equals(ironShovel)) {
            radius = 2;
            bonusX = 4;
            bonusY = 4;
            bonusZ = 4;

        } else if (usedItem.getItem().equals(goldenPickaxe) || usedItem.getItem().equals(goldenAxe) || usedItem.getItem().equals(goldenShovel)) {
            radius = 6;
            bonusX = 6;
            bonusY = 4;
            bonusZ = 6;

        } else if (usedItem.getItem().equals(diamondPickaxe) || usedItem.getItem().equals(diamondAxe) || usedItem.getItem().equals(diamondShovel)) {
            radius = 8;
            bonusX = 8;
            bonusY = 5;
            bonusZ = 8;

        } else if (usedItem.getItem().equals(netheritePickaxe) || usedItem.getItem().equals(netheriteAxe) || usedItem.getItem().equals(netheriteShovel)) {
            radius = 20;
            bonusX = 3;
            bonusY = -1000;
            bonusZ = 3;

        } else {
            return;
        }

        eventPos = e.getPos();

        int targetX = e.getPos().getX();
        int targetY = e.getPos().getY();
        int targetZ = e.getPos().getZ();

        int playerX = player.getPosition().getX();
        int playerY = player.getPosition().getY();
        int playerZ = player.getPosition().getZ();

        int baseX = e.getPos().getX();
        int baseZ = e.getPos().getZ();

        int finalX = e.getPos().getX() + (bonusX * 2);
        int finalZ = e.getPos().getZ() + (bonusZ * 2);


        if (targetX > playerX || targetX < playerX) {
            baseZ = targetZ - bonusZ;
            finalZ = targetZ + bonusZ;
            if (targetX < playerX) {
                baseX = targetX;
                finalX = targetX - (bonusX * 2);
            }
        }
        if (targetZ > playerZ || targetZ < playerZ) {
            baseX = targetX - bonusX;
            finalX = targetX + bonusX;
            if (targetZ < playerZ) {
                baseZ = targetZ;
                finalZ = targetZ - (bonusZ * 2);
            }
        }


        if (targetX > playerX && targetZ > playerZ) {
            baseX = targetX - 1;
            finalX = targetX + (bonusX * 2);
            baseZ = targetZ - 1;
            finalZ = targetZ + (bonusZ * 2);

        } else if (targetX < playerX && targetZ < playerZ) {
            baseX = targetX + 1;
            finalX = targetX - (bonusX * 2);
            baseZ = targetZ + 1;
            finalZ = targetZ - (bonusZ * 2);
        }

        if (targetX < playerX && targetZ > playerZ) {
            baseX = targetX + 1;
            finalX = targetX - (bonusX * 2);
            baseZ = targetZ - 1;
            finalZ = targetZ + (bonusZ * 2);

        } else if (targetX > playerX && targetZ < playerZ) {
            baseX = targetX - 1;
            finalX = targetX + (bonusX * 2);
            baseZ = targetZ + 1;
            finalZ = targetZ - (bonusZ * 2);
        }


        int baseY = targetY - (targetY - playerY);
        int finalY = targetY + bonusY;

        if (targetX == playerX && targetZ == playerZ && (targetY > playerY || targetY < playerY)) {
            baseX = targetX - bonusX;
            finalX = targetX + bonusX;
            baseZ = targetZ - bonusZ;
            finalZ = targetZ + bonusZ;

            if (targetY < playerY) {
                baseY = playerY;
                finalY = playerY - bonusY;
            }
        }

        if (bonusY == -1000) finalY = world.getChunk(eventPos).getHeight();


        firstPos = new BlockPos(baseX, baseY, baseZ);
        secondPos = new BlockPos(finalX, finalY, finalZ);

        if (usedItem.getItem() instanceof UltimateAxe) {
            firstPos = new BlockPos(eventPos.getX() - radius, eventPos.getY() - radius, eventPos.getZ() - radius);
            secondPos = new BlockPos(eventPos.getX() + radius, eventPos.getY() + radius, eventPos.getZ() + radius);
        }

        blockList = BlockPos.getAllInBox(firstPos, secondPos);

        ArrayList<BlockPos> newDestroyList = new ArrayList<>();

        ToolType toolType = null;

        if (usedItem.getItem() instanceof UltimateAxe) {
            toolType = AXE;
        } else if (usedItem.getItem() instanceof UltimateShovel) {
            toolType = SHOVEL;
        } else if (usedItem.getItem() instanceof UltimatePickaxe) {
            toolType = PICKAXE;
        }

        if (world.getBlockState(eventPos).getBlockHardness(world, eventPos) <= 0 || (!world.getBlockState(eventPos).isToolEffective(toolType))) {
            return;
        }

        if (usedItem.getItem() instanceof UltimateAxe) {
            // check for axe
            blockList.forEach(
                    blockPosition -> {
                        if (world.getBlockState(blockPosition).getBlockHardness(world, blockPosition) > 0) {
                            if (!world.isAirBlock(blockPosition) && (world.getBlockState(blockPosition).isToolEffective(AXE) || world.getBlockState(blockPosition).getBlock().equals(Blocks.ACACIA_LEAVES) || world.getBlockState(blockPosition).getBlock().equals(Blocks.BIRCH_LEAVES) || world.getBlockState(blockPosition).getBlock().equals(Blocks.OAK_LEAVES) || world.getBlockState(blockPosition).getBlock().equals(Blocks.DARK_OAK_LEAVES) || world.getBlockState(blockPosition).getBlock().equals(Blocks.JUNGLE_LEAVES) || world.getBlockState(blockPosition).getBlock().equals(Blocks.SPRUCE_LEAVES))) {
                                newDestroyList.add(new BlockPos(blockPosition));
                            }
                        }
                    });
        } else if (usedItem.getItem() instanceof UltimateShovel) {
            // check for shovel
            blockList.forEach(
                    blockPosition -> {
                        if (world.getBlockState(blockPosition).getBlockHardness(world, blockPosition) > 0) {
                            if (!world.isAirBlock(blockPosition) && (world.getBlockState(blockPosition).isToolEffective(SHOVEL))) {
                                newDestroyList.add(new BlockPos(blockPosition));
                            }
                        }
                    });

        } else {
            blockList.forEach(
                    blockPosition -> {
                        if (world.getBlockState(blockPosition).getBlockHardness(world, blockPosition) >= 0) {
                            // Stop block break sound and other things reducing lag
                            // Maybe get it to wait for a bit

                            if (!world.isAirBlock(blockPosition) && (usedItem.getItem().canHarvestBlock(world.getBlockState(blockPosition)))) {
                                // Maybe queue the drops and release them each 20 ticks
                                //Block.spawnDrops(world.getBlockState(blockPosition), world, eventPos);
                                newDestroyList.add(new BlockPos(blockPosition));
                                //world.removeBlock(blockPosition, false);
                            }
                            //System.out.println(!world.isAirBlock(blockPosition) && usedItem.getItem().canHarvestBlock(world.getBlockState(blockPosition)));
                            //System.out.println(world.getBlockState(blockPosition).getBlockHardness(world, blockPosition) >= 0);
                        }
                    });
        }

        destroyList.addAll(newDestroyList);
        destroyList.sort(new BlockPositionComparator().reversed());
    }

    @SubscribeEvent
    public void mineScheduled(TickEvent.ServerTickEvent event) {
        if (destroyList == null) {
            return;
        }

        Item[] items = new Item[]{Items.COBBLESTONE, Items.DIRT, Items.SAND, Items.GRAVEL, Items.DIORITE, Items.GRANITE, Items.SANDSTONE, Items.ANDESITE};
        int[] itemAmounts = new int[]{stoneAmount, dirtAmount, sandAmount, gravelAmount, dioriteAmount, graniteAmount, sandstoneAmount, andesiteAmount};

        BlockPos target = null;
        int quantity = 40;
        int i = 0;
        while (i < quantity) {
            if (!destroyList.isEmpty()) {
                // Check if target block can be broken by item
                // Use item durability for every mined block
                // Drop Exp too
                target = destroyList.remove(destroyList.size() - 1);
                //List<ItemStack> itemStackList = Block.getDrops(world.getBlockState(target), (ServerWorld) world, target, player.getEntityWorld().getTileEntity(target));

                //player.getHeldItemMainhand().getItem().setDamage(player.getHeldItemMainhand(), player.getHeldItemMainhand().getDamage());
                //player.addStat(Stats.ITEM_USED.get(usedItem.getItem()));
                usedItem.onBlockDestroyed(world, world.getBlockState(target), target, player);

                //Block.spawnDrops(world.getBlockState(target), world, target, world.getTileEntity(target), player, );
                //ServerPlayerEntity serverPlayer = (ServerPlayerEntity) player;
                //world.getBlockState(target).getBlock().dropXpOnBlockBreak((ServerWorld) world, target, ForgeHooks.onBlockBreakEvent(world, serverPlayer.interactionManager.getGameType(), serverPlayer, target)); //
                spawnMiningEXP(target);
                isCommonBlock(target);
                checkToSpawnCommonDrops(target, items, itemAmounts);

                world.removeBlock(target, false);
                i += 1;

            } else {
                if (entitiesSpawned > 0) {
                    System.out.println("Entities spawned total: " + entitiesSpawned);
                    entitiesSpawned = 0;
                }
                break;
            }
        }
    }

    public void checkToSpawnCommonDrops(BlockPos target, Item[] items, int[] amounts) {
        if (destroyList.isEmpty()) {
            for (int i = 0; i < items.length; i++) {
                if (amounts[i] > 0) {
                    spawnCommonBlock(target, items[i], amounts[i]);
                }
            }
            stoneAmount = dirtAmount = sandAmount = gravelAmount = dioriteAmount = graniteAmount = sandstoneAmount = andesiteAmount = 0;
        } else {
            stoneAmount = reset(stoneAmount, target, Items.COBBLESTONE);
            dirtAmount = reset(dirtAmount, target, Items.DIRT);
            sandAmount = reset(sandAmount, target, Items.SAND);
            gravelAmount = reset(gravelAmount, target, Items.GRAVEL);
            dioriteAmount = reset(dioriteAmount, target, Items.DIORITE);
            graniteAmount = reset(graniteAmount, target, Items.GRANITE);
            sandstoneAmount = reset(sandstoneAmount, target, Items.SANDSTONE);
            andesiteAmount = reset(andesiteAmount, target, Items.ANDESITE);
        }
    }

    public int reset(int amount, BlockPos target, Item item) {
        if (amount > 64) {
            spawnCommonBlock(target, item, 64);
            return amount % 64;
        }
        return amount;
    }

    public void spawnCommonBlock(BlockPos target, Item item, int amount) {
        entitiesSpawned += amount;
        System.out.println(amount + " " + item);
        world.addEntity(new ItemEntity(world, target.getX(), target.getY(), target.getZ(), new ItemStack(item, amount)));
    }

    public void isCommonBlock(BlockPos target) {
        if (world.getBlockState(target).getBlock().equals(Blocks.STONE)) {
            stoneAmount++;
        } else if (world.getBlockState(target).getBlock().equals(Blocks.DIRT)) {
            dirtAmount++;
        } else if (world.getBlockState(target).getBlock().equals(Blocks.SAND)) {
            sandAmount++;
        } else if (world.getBlockState(target).getBlock().equals(Blocks.GRAVEL)) {
            gravelAmount++;
        } else if (world.getBlockState(target).getBlock().equals(Blocks.DIORITE)) {
            dioriteAmount++;
        } else if (world.getBlockState(target).getBlock().equals(Blocks.GRANITE)) {
            graniteAmount++;
        } else if (world.getBlockState(target).getBlock().equals(Blocks.SANDSTONE)) {
            sandstoneAmount++;
        } else if (world.getBlockState(target).getBlock().equals(Blocks.ANDESITE)) {
            andesiteAmount++;
        } else {
            Block.spawnDrops(world.getBlockState(target), world, target);
        }
    }

    public void spawnMiningEXP(BlockPos target) {
        int experienceInt;
        Block block = world.getBlockState(target).getBlock();

        if (block.equals(Blocks.COAL_ORE) || block.equals(Blocks.NETHER_GOLD_ORE)) {
            experienceInt = (int) (Math.random() + 1);
        } else if (block.equals(Blocks.REDSTONE_ORE) || block.equals(Blocks.LAPIS_ORE) || block.equals(Blocks.NETHER_QUARTZ_ORE)) {
            experienceInt = (int) (Math.random() * 4 + 1);
        } else if (block.equals(Blocks.EMERALD_ORE) || block.equals(Blocks.DIAMOND_ORE)) {
            experienceInt = (int) (Math.random() * 4 + 3);
        } else {
            return;
        }

        //Block.spawnDrops(exp.get);
        //ItemStack itemStack = new ItemStack();
        //Block.spawnAsEntity(world, target, );
        //Block.spawnAsEntity();
        ExperienceOrbEntity exp = new ExperienceOrbEntity(world, target.getX(), target.getY(), target.getZ(), experienceInt);
        world.addEntity(exp);

    }

/*
    @SubscribeEvent
    public void pickupItem(EntityItemPickupEvent event) {
        System.out.println("Pickup item D:");
        // Pick up all items in a specific radius
        // Items gets into a marked chest
    }
 */


}
