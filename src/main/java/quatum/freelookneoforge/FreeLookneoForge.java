package quatum.freelookneoforge;

import com.mojang.logging.LogUtils;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.ModLoadingContext;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import org.slf4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(FreeLookneoForge.MODID)
public class FreeLookneoForge {

    // Define mod id in a common place for everything to reference
    public static final String MODID = "freelookneoforge";
    // Directly reference a slf4j logger
    private static final Logger LOGGER = LogUtils.getLogger();

    public FreeLookneoForge(IEventBus modEventBus, ModContainer modContainer) {
        // Register our mod's ForgeConfigSpec so that Forge can create and load the config file for us
        modContainer.registerConfig(ModConfig.Type.CLIENT, Config.SPEC);
    }
}