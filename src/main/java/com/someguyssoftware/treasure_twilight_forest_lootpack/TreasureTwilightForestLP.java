package com.someguyssoftware.treasure_twilight_forest_lootpack;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.someguyssoftware.gottschcore.annotation.Credits;
import com.someguyssoftware.gottschcore.config.IConfig;
import com.someguyssoftware.gottschcore.mod.AbstractMod;
import com.someguyssoftware.gottschcore.mod.IMod;
import com.someguyssoftware.gottschcore.version.BuildVersion;
import com.someguyssoftware.treasure_twilight_forest_lootpack.config.ModConfig;
import com.someguyssoftware.treasure_twilight_forest_lootpack.eventhandler.WorldEventHandler;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

/**
 * 
 * @author Mark Gottschling on Dec 25, 2020
 *
 */
@Mod(modid = TreasureTwilightForestLP.MODID, 
name = TreasureTwilightForestLP.NAME, 
version = TreasureTwilightForestLP.VERSION, 
dependencies = "required-after:gottschcore@[1.14.0,);required-after:treasure2@[1.14.0,);required-after:twilightforest@[3.11.1021,)", 
acceptedMinecraftVersions = "[1.12.2]", 
updateJSON = TreasureTwilightForestLP.UPDATE_JSON_URL)
@Credits(values = { "Treasure2: Twilight Forest Loot Pack was first developed by Mark Gottschling on June 11, 2021."})
public class TreasureTwilightForestLP extends AbstractMod {
	// constants
	public static final String MODID = "treasure2_twilight_forest_lp";
	protected static final String NAME = "Treasure2TwilightForestLP";
	protected static final String VERSION = "1.0.0";

	public static final String UPDATE_JSON_URL = "https://raw.githubusercontent.com/gottsch/gottsch-minecraft-Treasure-Twilight-Forest-Loot-Pack/1.12.2-master/update.json";

	private static final BuildVersion MINECRAFT_VERSION = new BuildVersion(1, 12, 2);

	// latest version
	private static BuildVersion latestVersion;

	// logger
	public static Logger LOGGER = LogManager.getLogger(TreasureTwilightForestLP.NAME);

	@Instance(value = TreasureTwilightForestLP.MODID)
	public static TreasureTwilightForestLP instance;

	/**
	 * 
	 */
	public TreasureTwilightForestLP() {

	}

	/**
	 * 
	 * @param event
	 */
	@Override
	@EventHandler
	public void preInt(FMLPreInitializationEvent event) {
		super.preInt(event);

		// register additional events
		MinecraftForge.EVENT_BUS.register(new WorldEventHandler(getInstance()));
	}

	@EventHandler
	public void postInit(FMLPostInitializationEvent event) {
		if (!getConfig().isModEnabled()) {
			return;
		}

		// perform any post init
		super.postInit(event);
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see com.someguyssoftware.gottschcore.mod.IMod#getConfig()
	 */
	@Override
	public IConfig getConfig() {
		return ModConfig.instance;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.someguyssoftware.gottschcore.mod.IMod#getMinecraftVersion()
	 */
	@Override
	public BuildVersion getMinecraftVersion() {
		return TreasureTwilightForestLP.MINECRAFT_VERSION;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.someguyssoftware.gottschcore.mod.IMod#getVerisionURL()
	 */
	@Override
	public String getVerisionURL() {
		return "";
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.someguyssoftware.gottschcore.mod.IMod#getName()
	 */
	@Override
	public String getName() {
		return TreasureTwilightForestLP.NAME;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.someguyssoftware.gottschcore.mod.IMod#getId()
	 */
	@Override
	public String getId() {
		return TreasureTwilightForestLP.MODID;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.someguyssoftware.gottschcore.mod.AbstractMod#getInstance()
	 */
	@Override
	public IMod getInstance() {
		return TreasureTwilightForestLP.instance;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.someguyssoftware.gottschcore.mod.AbstractMod#getVersion()
	 */
	@Override
	public String getVersion() {
		return TreasureTwilightForestLP.VERSION;
	}

	@Override
	public BuildVersion getModLatestVersion() {
		return latestVersion;
	}

	@Override
	public void setModLatestVersion(BuildVersion version) {
		TreasureTwilightForestLP.latestVersion = version;
	}

	@Override
	public String getUpdateURL() {
		return TreasureTwilightForestLP.UPDATE_JSON_URL;
	}
}