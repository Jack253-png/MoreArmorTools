package com.mccreater.morearmortools;

import com.mccreater.morearmortools.utils.getBytes;
import io.netty.channel.Channel;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.loader.api.FabricLoader;
import net.fabricmc.loader.api.ModContainer;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import java.lang.Thread;
import java.util.Collection;
import java.util.Date;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import com.mccreater.morearmortools.utils.spiltString;
import com.mccreater.morearmortools.config.ConfigReader;
import com.mccreater.morearmortools.config.ConfigResult;

public class Client implements ModInitializer {
	public static final Logger logger = LoggerFactory.getLogger("More Armor Tools Logger");
	public static boolean debug = true;
	@Override
	public void onInitialize(){
		logger.info("getting config");
		ConfigReader configReader = new ConfigReader();
		ConfigResult configResult = configReader.readConfig();
		if (configResult != null){
			debug = configResult.debug;
		}
		Thread initlaze = new Thread(this::initlaze);
		initlaze.setName("More Armor Tools Initlaze Thread");
		initlaze.start();
	}
	public void initlaze(){
		try {
			if (debug) {
				logger.info("Now Time:" + new Date().toString());
				logger.info("Max Memory:" + getBytes.get(Runtime.getRuntime().maxMemory()));
				logger.info("Total Memory:" + getBytes.get(Runtime.getRuntime().totalMemory()));
				long total = Runtime.getRuntime().totalMemory();
				long max = Runtime.getRuntime().maxMemory();
				logger.info("Allcated : " + (total * 100 / max) + "%");
				logger.info("Run on OS:" + System.getProperty("os.name"));
				ThreadGroup parentThread;
				int totalThread = 0;
				for (parentThread = Thread.currentThread().getThreadGroup(); parentThread
						.getParent() != null; parentThread = parentThread.getParent()) {
					totalThread = parentThread.activeCount();
				}
				logger.info("Detected " + totalThread + "threads running");
			}
			Registry.register(Registry.ITEM, new Identifier(Vars.modid,"wool_hamlet"), Group.WoolHelmet);
			Registry.register(Registry.ITEM, new Identifier(Vars.modid,"wool_chestplate"), Group.WoolChestplate);
			Registry.register(Registry.ITEM, new Identifier(Vars.modid,"wool_leggings"), Group.WoolLeggings);
			Registry.register(Registry.ITEM, new Identifier(Vars.modid,"wool_boots"),Group.WoolBoots);
			Registry.register(Registry.ITEM, new Identifier(Vars.modid,"wool_axe"),Group.WoolAxe);
			Registry.register(Registry.ITEM, new Identifier(Vars.modid,"wool_sword"),Group.WoolSword);
			Registry.register(Registry.ITEM, new Identifier(Vars.modid,"wool_pickaxe"),Group.WoolPickaxe);
			Registry.register(Registry.ITEM, new Identifier(Vars.modid,"wool_shovel"),Group.WoolShovel);
			Registry.register(Registry.ITEM, new Identifier(Vars.modid,"wool_hoe"),Group.WoolHoe);
			Registry.register(Registry.ITEM, new Identifier(Vars.modid,"compressionwoodsword"),Group.CompressionWoodSword);
			Registry.register(Registry.BLOCK,new Identifier(Vars.modid,"industry_wool"),Group.IndustryWool);
			Registry.register(Registry.ITEM, new Identifier(Vars.modid,"industry_wool"),new BlockItem(Group.IndustryWool, new Item.Settings().group(Group.Materials)));
			Registry.register(Registry.BLOCK,new Identifier(Vars.modid,"irongoldblock"),Group.IronGoldBlock);
			Registry.register(Registry.ITEM, new Identifier(Vars.modid,"irongoldblock"),new BlockItem(Group.IronGoldBlock, new Item.Settings().group(Group.Materials)));
			Registry.register(Registry.ITEM, new Identifier(Vars.modid,"compressionstick1x"),Group.CompressionStick1x);
			Registry.register(Registry.ITEM, new Identifier(Vars.modid,"compressionstick2x"),Group.CompressionStick2x);
			Registry.register(Registry.ITEM, new Identifier(Vars.modid,"compressionstick3x"),Group.CompressionStick3x);
			Registry.register(Registry.ITEM, new Identifier(Vars.modid,"compressionstick4x"),Group.CompressionStick4x);
			Registry.register(Registry.ITEM, new Identifier(Vars.modid,"compressionstick5x"),Group.CompressionStick5x);
			Registry.register(Registry.ITEM, new Identifier(Vars.modid,"compressionstick6x"),Group.CompressionStick6x);
			Registry.register(Registry.ITEM, new Identifier(Vars.modid,"compressionstick7x"),Group.CompressionStick7x);
			Registry.register(Registry.ITEM, new Identifier(Vars.modid,"compressionstick8x"),Group.CompressionStick8x);
			Registry.register(Registry.ITEM, new Identifier(Vars.modid,"compressionstick9x"),Group.CompressionStick9x);
			Registry.register(Registry.ITEM, new Identifier(Vars.modid,"irongoldingot"),Group.IronGoldIngot);
			Registry.register(Registry.ITEM, new Identifier(Vars.modid,"irongoldaxe"),Group.IronGoldAxe);
			Registry.register(Registry.ITEM, new Identifier(Vars.modid,"irongoldpickaxe"),Group.IronGoldPickaxe);
			Registry.register(Registry.ITEM, new Identifier(Vars.modid,"irongoldsword"),Group.IronGoldSword);
			Registry.register(Registry.ITEM, new Identifier(Vars.modid,"irongoldshovel"),Group.IronGoldShovel);
			Registry.register(Registry.ITEM, new Identifier(Vars.modid,"irongoldhoe"),Group.IronGoldHoe);
			Registry.register(Registry.ITEM, new Identifier(Vars.modid,"irongoldhemlet"),Group.IronGoldHemlet);
			Registry.register(Registry.ITEM, new Identifier(Vars.modid,"irongoldchestplate"),Group.IronGoldChestplate);
			Registry.register(Registry.ITEM, new Identifier(Vars.modid,"irongoldleggings"),Group.IronGoldLeggings);
			Registry.register(Registry.ITEM, new Identifier(Vars.modid,"irongoldboots"),Group.IronGoldBoots);
			Registry.register(Registry.ITEM, new Identifier(Vars.modid,"irongoldingottoirongoldblock"),Group.IronGoldBlockToIronGoldIngot);
			Registry.register(Registry.ITEM, new Identifier(Vars.modid,"copperaxe"),Group.CopperAxe);
			Registry.register(Registry.ITEM, new Identifier(Vars.modid,"copperpickaxe"),Group.CopperPickaxe);
			Registry.register(Registry.ITEM, new Identifier(Vars.modid,"coppersword"),Group.CopperSword);
			Registry.register(Registry.ITEM, new Identifier(Vars.modid,"coppershovel"),Group.CopperShovel);
			Registry.register(Registry.ITEM, new Identifier(Vars.modid,"copperhoe"),Group.CopperHoe);
			Registry.register(Registry.ITEM, new Identifier(Vars.modid,"copperhelmet"),Group.CopperHelmet);
			Registry.register(Registry.ITEM, new Identifier(Vars.modid,"copperchestplate"),Group.CopperChestPlate);
			Registry.register(Registry.ITEM, new Identifier(Vars.modid,"copperleggings"),Group.CopperLeggings);
			Registry.register(Registry.ITEM, new Identifier(Vars.modid,"copperboots"),Group.CopperBoots);
			Registry.register(Registry.ITEM, new Identifier(Vars.modid,"obsidianaxe"),Group.ObsidianAxe);
			Registry.register(Registry.ITEM, new Identifier(Vars.modid,"obsidianpickaxe"),Group.ObsidianPickaxe);
			Registry.register(Registry.ITEM, new Identifier(Vars.modid,"obsidiansword"),Group.ObsidianSword);
			Registry.register(Registry.ITEM, new Identifier(Vars.modid,"obsidianshovel"),Group.ObsidianShovel);
			Registry.register(Registry.ITEM, new Identifier(Vars.modid,"obsidianhoe"),Group.ObsidianHoe);
			Registry.register(Registry.ITEM, new Identifier(Vars.modid,"obsidianhelmet"),Group.ObsidianHelmet);
			Registry.register(Registry.ITEM, new Identifier(Vars.modid,"obsidianchestplate"),Group.ObsidianChestplate);
			Registry.register(Registry.ITEM, new Identifier(Vars.modid,"obsidianleggings"),Group.ObsidianLeggings);
			Registry.register(Registry.ITEM, new Identifier(Vars.modid,"obsidianboots"),Group.ObsidianBoots);
			logger.info("Items Registried");
			if (debug) {
				Thread getmods = new Thread(this::GetMods);
				getmods.setName("Get Mod List");
				getmods.start();
			}
		}
		catch (Exception e){
			e.printStackTrace();
			logger.error("An Exception declared , "+e.toString());
			throw e;
		}
	}
	
	public void GetMods(){
		try {
			String st = "Detected " + FabricLoader.getInstance().getAllMods().toArray().length + " Mods:";
			logger.info("In develop : " + FabricLoader.getInstance().isDevelopmentEnvironment());
			logger.info(st);
			spiltString spiltString = new spiltString();
			Collection<ModContainer> modContainerCollection = FabricLoader.getInstance().getAllMods();
			for (ModContainer m : modContainerCollection) {
				logger.info(" - " + spiltString.split(m.toString()));
			}
			String[] arrays = FabricLoader.getInstance().getLaunchArguments(true);
			logger.info("Arguments :");
			for (String array : arrays) {
				logger.info(array);
			}
		}
		catch (Exception e){
			e.printStackTrace();
		}
	}
}