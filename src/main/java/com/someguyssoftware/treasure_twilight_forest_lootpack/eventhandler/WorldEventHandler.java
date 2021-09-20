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
package com.someguyssoftware.treasure_twilight_forest_lootpack.eventhandler;

import java.util.Objects;

import com.someguyssoftware.gottschcore.mod.IMod;
import com.someguyssoftware.gottschcore.world.WorldInfo;
import com.someguyssoftware.treasure2.Treasure;
import com.someguyssoftware.treasure2.loot.LootResources;
import com.someguyssoftware.treasure2.loot.TreasureLootTableRegistry;
import com.someguyssoftware.treasure_twilight_forest_lootpack.TreasureTwilightForestLP;

import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.event.world.WorldEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class WorldEventHandler {
    	// reference to the mod.
	private IMod mod;
	
	/**
	 * 
	 */
	public WorldEventHandler(IMod mod) {
		setMod(mod);
	}

	@SubscribeEvent(priority = EventPriority.LOW)
	public void onWorldLoad(WorldEvent.Load event) {
        
		/*
		 * On load of dimension 0 (overworld), initialize the loot table's context and other static loot tables
		 */
		if (WorldInfo.isServerSide((World)event.getWorld())) {
			ServerWorld world = (ServerWorld) event.getWorld();
			Treasure.LOGGER.info("In world load event for dimension {}", WorldInfo.getDimension(world).toString());
			if (WorldInfo.isSurfaceWorld(world)) {
				// load master loot resources lists
				try {
					LootResources lootResources = TreasureLootTableRegistry.readLootResourcesFromFromStream(
							Objects.requireNonNull(TreasureTwilightForestLP.instance.getClass().getClassLoader().getResourceAsStream("loot_tables/treasure2_twilight_forest_lp/default_loot_tables_list.json"))
							);
					Treasure.LOGGER.debug(lootResources);
					// register mod's loot tables with the LootTableMaster
					TreasureLootTableRegistry.register(mod.getId(), lootResources);
				}
				catch(Exception e) {
					Treasure.LOGGER.warn("Unable to register loot tables");
				}
			}
		}	
	}
	
	/**
	 * @return the mod
	 */
	public IMod getMod() {
		return mod;
	}

	/**
	 * @param mod the mod to set
	 */
	public void setMod(IMod mod) {
		this.mod = mod;
	}

}