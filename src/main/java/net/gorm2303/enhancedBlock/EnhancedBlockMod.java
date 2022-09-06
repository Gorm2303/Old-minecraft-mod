package net.gorm2303.enhancedBlock;

import net.gorm2303.enhancedBlock.setup.Registration;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(EnhancedBlockMod.MOD_ID)
public class EnhancedBlockMod {
    public static final String MOD_ID = "enhancedblock";

    private static final Logger LOGGER = LogManager.getLogger();

    public EnhancedBlockMod() {
        Registration.register();

        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);
    }
}
