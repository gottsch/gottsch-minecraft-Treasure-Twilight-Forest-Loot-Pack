/*
 * This file is part of  TreasureTwilightForestLP.
 * Copyright (c) 2021, Mark Gottschling (gottsch)
 * 
 * All rights reserved.
 *
 * TreasureTwilightForestLP is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * TreasureTwilightForestLP is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with TreasureTwilightForestLP.  If not, see <http://www.gnu.org/licenses/lgpl>.
 */
package com.someguyssoftware.treasure_twilight_forest_lootpack;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.someguyssoftware.gottschcore.annotation.Credits;
import com.someguyssoftware.gottschcore.annotation.ModInfo;
import com.someguyssoftware.gottschcore.config.IConfig;
import com.someguyssoftware.gottschcore.mod.IMod;
import com.someguyssoftware.treasure2.api.TreasureApi;
import com.someguyssoftware.treasure_twilight_forest_lootpack.eventhandler.WorldEventHandler;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

/**
 * 
 * @author Mark Gottschling on Dec 25, 2020
 *
 */
@Mod(value = TreasureTwilightForestLP.MODID)
@ModInfo(
		modid = TreasureTwilightForestLP.MODID, 
		name = TreasureTwilightForestLP.NAME, 
		version = TreasureTwilightForestLP.VERSION, 
		minecraftVersion = "1.16.5", 
		forgeVersion = "36.2.34", 
		updateJsonUrl = TreasureTwilightForestLP.UPDATE_JSON_URL)
@Credits(values = { "Treasure2: Twilight Forest Loot Pack was first developed by Mark Gottschling on June 11, 2021."})
public class TreasureTwilightForestLP implements IMod {
	// constants
	public static final String MODID = "treasure2_twilight_forest_lp";
	protected static final String NAME = "Treasure2TwilightForestLP";
	protected static final String VERSION = "2.0.0";

	public static final String UPDATE_JSON_URL = "https://raw.githubusercontent.com/gottsch/gottsch-minecraft-Treasure-Twilight-Forest-Loot-Pack/1.16.5-master/update.json";

	// logger
	public static Logger LOGGER = LogManager.getLogger(TreasureTwilightForestLP.NAME);

	public static TreasureTwilightForestLP instance;

	/**
	 * 
	 */
	public TreasureTwilightForestLP() {
		TreasureTwilightForestLP.instance = this;
		
		// Register the setup method for modloading
		IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();
		eventBus.addListener(this::common);
		MinecraftForge.EVENT_BUS.register(new WorldEventHandler(getInstance()));
	}
	
	private void common(final FMLCommonSetupEvent event) {
		TreasureApi.registerLootTables(MODID);
	}
	
	@Override
	public IMod getInstance() {
		return TreasureTwilightForestLP.instance;
	}

	@Override
	public String getId() {
		return TreasureTwilightForestLP.MODID;
	}

	@Override
	public IConfig getConfig() {
		return null;
	}
}