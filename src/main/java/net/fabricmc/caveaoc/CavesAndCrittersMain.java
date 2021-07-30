package net.fabricmc.caveaoc;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.caveaoc.core.CACBlocks;
import net.fabricmc.caveaoc.core.CACEntities;
import net.fabricmc.caveaoc.core.CACItems;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.nio.file.Path;

public class CavesAndCrittersMain implements ModInitializer {
	public static final String MOD_ID = "cavesandcritters";
	public static boolean isClient = false;
	public static Logger LOGGER = LogManager.getLogger();
	public static boolean isUsingMixin;
	public static String FILE_PATH = "yes";
	public static final Path CONFIG_PATH = new File(String.valueOf(FabricLoader.getInstance().getConfigDirectory().toPath().resolve(MOD_ID))).toPath();

	@Override
	public void onInitialize() {
		File dir = new File(CONFIG_PATH.toString());
		if (!dir.exists())
			dir.mkdir();

		CACRegistries.registerBlocks();
		CACRegistries.registerItems();
		CACRegistries.registerEntities();

		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.

		System.out.println("Hello Fabric world!");
	}


	public static class CACRegistries {
		public static void registerBlocks() {
			CavesAndCrittersMain.LOGGER.debug("CAC: Registering blocks...");
			CACBlocks.init();
			CavesAndCrittersMain.LOGGER.info("CAC: Blocks registered!");
		}

		public static void registerItems() {
			CavesAndCrittersMain.LOGGER.debug("CAC: Registering items...");
			CACItems.init();
			CavesAndCrittersMain.LOGGER.info("CAC: Items registered!");
		}

		public static void registerEntities() {
			CavesAndCrittersMain.LOGGER.debug("CAC: Registering entities...");
			CACEntities.init();
			CavesAndCrittersMain.LOGGER.info("CAC: Entities registered!");
		}
	}
}
