package mod.gottsch.forge.treasure2_twilight_forest_lp;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import mod.gottsch.forge.treasure2.Treasure;
import mod.gottsch.forge.treasure2.api.TreasureApi;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(TreasureTwilightForestLP.MODID)
public class TreasureTwilightForestLP {
    // Directly reference a slf4j logger
	public static Logger LOGGER = LogManager.getLogger(Treasure.MODID);

	public static final String MODID = "treasure2_twilight_forest_lp";
	
    public TreasureTwilightForestLP() {
        // Register the setup method for modloading
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::commonSetup);
    }

    /**
     * 
     * @param event
     */
    private void commonSetup(final FMLCommonSetupEvent event) {
		// register loot tables
    	LOGGER.debug("registering Treasure Twilight Forest LP");
		TreasureApi.registerLootTables(TreasureTwilightForestLP.MODID);
    }
}
