package net.gorm2303.enhancedBlock;

import java.util.Comparator;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.BlockPos;

public class BlockPositionComparator implements Comparator<BlockPos> {
    private static PlayerEntity player = MyForgeEventHandler.getPlayer();
    private static BlockPos ePos = MyForgeEventHandler.getEventPos();

    @Override
    public int compare(BlockPos o1, BlockPos o2) {
        BlockPos bpP = player.getPosition();
        /*
        int eX = ePos.getX();
        int eZ = ePos.getZ();
        int pX = bpP.getX();
        int pZ = bpP.getZ();
        */
        double i1 = (Math.pow((o1.getX() - bpP.getX()), 2) + Math.pow((o1.getZ() - bpP.getZ()), 2));
        double i2 = (Math.pow((o2.getX() - bpP.getX()), 2) + Math.pow((o2.getZ() - bpP.getZ()), 2));
        //System.out.println("PlayerPosition: " + bpP);
        //System.out.println("Length1: " + i1);
        //System.out.println("Length2: " + i2);
        double xzDiff = Math.sqrt(i1) - Math.sqrt(i2);
        double yDiff = (o1.getY() - bpP.getY()) - (o2.getY() - bpP.getY());

        if (xzDiff != 0) {
            //System.out.println("xzDiff: " + xzDiff);
            if (xzDiff < 0) {
                return -1;
            } else if (xzDiff > 0) {
                return 1;
            }

        } else {
            //System.out.println("yDiff: " + yDiff);
            if (yDiff < 0) {
                return -1;
            } else if (yDiff > 0) {
                return 1;
            }
        }
        return 0;

    }
}
