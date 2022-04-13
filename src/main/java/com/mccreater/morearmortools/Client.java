package com.mccreater.morearmortools;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.loader.api.FabricLoader;
import net.fabricmc.loader.api.ModContainer;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import com.mccreater.morearmortools.blocks.Group;
import java.lang.Thread;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import com.mccreater.morearmortools.utils.spiltString;

public class Client implements ModInitializer {
	public static final Logger logger = LoggerFactory.getLogger("More Armor Tools Logger");
	@Override
	public void onInitialize(){
		Thread initlaze = new Thread(this::initlaze);
		initlaze.setName("More Armor Tools Initlaze Thread");
		initlaze.start();
	}

	public void initlaze(){
		try {
			String modid = "morearmortools";
			logger.info("Now Time:"+new Date().toString());
			int max = (int) (Runtime.getRuntime().maxMemory() / 1024 / 1024);
			int total = (int) (Runtime.getRuntime().totalMemory() / 1024 / 1024);
			logger.info("Max Memory:"+max+"MB");
			logger.info("Total Memory:"+total+"MB");
			logger.info("Run on OS:"+ System.getProperty("os.name"));
			ThreadGroup parentThread;
			int totalThread = 0;
			for (parentThread = Thread.currentThread().getThreadGroup(); parentThread
					.getParent() != null; parentThread = parentThread.getParent()) {
				totalThread = parentThread.activeCount();
			}
			logger.info("Detected "+totalThread+"threads running");
			Registry.register(Registry.ITEM, new Identifier(modid, "wool_hamlet"), Group.WoolHelmet);
			Registry.register(Registry.ITEM, new Identifier(modid, "wool_chestplate"), Group.WoolChestplate);
			Registry.register(Registry.ITEM, new Identifier(modid,"wool_leggings"), Group.WoolLeggings);
			Registry.register(Registry.ITEM, new Identifier(modid,"wool_boots"),Group.WoolBoots);
			Registry.register(Registry.ITEM, new Identifier(modid,"wool_axe"),Group.WoolAxe);
			Registry.register(Registry.ITEM, new Identifier(modid,"wool_sword"),Group.WoolSword);
			Registry.register(Registry.ITEM, new Identifier(modid,"wool_pickaxe"),Group.WoolPickaxe);
			Registry.register(Registry.ITEM, new Identifier(modid,"wool_shovel"),Group.WoolShovel);
			Registry.register(Registry.ITEM, new Identifier(modid,"wool_hoe"),Group.WoolHoe);
			Registry.register(Registry.ITEM, new Identifier(modid,"compressionwoodsword"),Group.CompressionWoodSword);
			Registry.register(Registry.BLOCK,new Identifier(modid,"industry_wool"),Group.IndustryWool);
			Registry.register(Registry.ITEM, new Identifier(modid,"industry_wool"),new BlockItem(Group.IndustryWool, new Item.Settings().group(Group.Materials)));
			Registry.register(Registry.BLOCK,new Identifier(modid,"irongoldblock"),Group.IronGoldBlock);
			Registry.register(Registry.ITEM, new Identifier(modid,"irongoldblock"),new BlockItem(Group.IronGoldBlock, new Item.Settings().group(Group.Materials)));
			Registry.register(Registry.ITEM, new Identifier(modid,"compressionstick1x"),Group.CompressionStick1x);
			Registry.register(Registry.ITEM, new Identifier(modid,"compressionstick2x"),Group.CompressionStick2x);
			Registry.register(Registry.ITEM, new Identifier(modid,"compressionstick3x"),Group.CompressionStick3x);
			Registry.register(Registry.ITEM, new Identifier(modid,"compressionstick4x"),Group.CompressionStick4x);
			Registry.register(Registry.ITEM, new Identifier(modid,"compressionstick5x"),Group.CompressionStick5x);
			Registry.register(Registry.ITEM, new Identifier(modid,"compressionstick6x"),Group.CompressionStick6x);
			Registry.register(Registry.ITEM, new Identifier(modid,"compressionstick7x"),Group.CompressionStick7x);
			Registry.register(Registry.ITEM, new Identifier(modid,"compressionstick8x"),Group.CompressionStick8x);
			Registry.register(Registry.ITEM, new Identifier(modid,"compressionstick9x"),Group.CompressionStick9x);
			Registry.register(Registry.ITEM, new Identifier(modid,"irongoldingot"),Group.IronGoldIngot);
			Registry.register(Registry.ITEM, new Identifier(modid,"irongoldaxe"),Group.IronGoldAxe);
			Registry.register(Registry.ITEM, new Identifier(modid,"irongoldpickaxe"),Group.IronGoldPickaxe);
			Registry.register(Registry.ITEM, new Identifier(modid,"irongoldsword"),Group.IronGoldSword);
			Registry.register(Registry.ITEM, new Identifier(modid,"irongoldshovel"),Group.IronGoldShovel);
			Registry.register(Registry.ITEM, new Identifier(modid,"irongoldhoe"),Group.IronGoldHoe);
			Registry.register(Registry.ITEM, new Identifier(modid,"irongoldhemlet"),Group.IronGoldHemlet);
			Registry.register(Registry.ITEM, new Identifier(modid,"irongoldchestplate"),Group.IronGoldChestplate);
			Registry.register(Registry.ITEM, new Identifier(modid,"irongoldleggings"),Group.IronGoldLeggings);
			Registry.register(Registry.ITEM, new Identifier(modid,"irongoldboots"),Group.IronGoldBoots);
			Registry.register(Registry.ITEM, new Identifier(modid,"irongoldingottoirongoldblock"),Group.IronGoldBlockToIronGoldIngot);
			Registry.register(Registry.ITEM, new Identifier(modid,"copperaxe"),Group.CopperAxe);
			Registry.register(Registry.ITEM, new Identifier(modid,"copperpickaxe"),Group.CopperPickaxe);
			Registry.register(Registry.ITEM, new Identifier(modid,"coppersword"),Group.CopperSword);
			Registry.register(Registry.ITEM, new Identifier(modid,"coppershovel"),Group.CopperShovel);
			Registry.register(Registry.ITEM, new Identifier(modid,"copperhoe"),Group.CopperHoe);
			Registry.register(Registry.ITEM, new Identifier(modid,"copperhelmet"),Group.CopperHelmet);
			Registry.register(Registry.ITEM, new Identifier(modid,"copperchestplate"),Group.CopperChestPlate);
			Registry.register(Registry.ITEM, new Identifier(modid,"copperleggings"),Group.CopperLeggings);
			Registry.register(Registry.ITEM, new Identifier(modid,"copperboots"),Group.CopperBoots);
			Registry.register(Registry.ITEM, new Identifier(modid,"obsidianaxe"),Group.ObsidianAxe);
			Registry.register(Registry.ITEM, new Identifier(modid,"obsidianpickaxe"),Group.ObsidianPickaxe);
			Registry.register(Registry.ITEM, new Identifier(modid,"obsidiansword"),Group.ObsidianSword);
			Registry.register(Registry.ITEM, new Identifier(modid,"obsidianshovel"),Group.ObsidianShovel);
			Registry.register(Registry.ITEM, new Identifier(modid,"obsidianhoe"),Group.ObsidianHoe);
			logger.info("Items Registried");
			Thread getmods = new Thread(this::GetMods);
			getmods.setName("Get Mod List");
			getmods.start();
		}
		catch (Exception e){
			e.printStackTrace();
			logger.error("An Exception declared , "+e.toString());
			throw e;
		}
	}
	
	public void GetMods(){
		String st = "Detected "+FabricLoader.getInstance().getAllMods().toArray().length+" Mods:";
		logger.info("In develop : "+FabricLoader.getInstance().isDevelopmentEnvironment());
		logger.info(st);
		spiltString spiltString = new spiltString();
		Collection<ModContainer> modContainerCollection = FabricLoader.getInstance().getAllMods();
		for (ModContainer m : modContainerCollection){
			logger.info(" - "+spiltString.split(m.toString()));
		}
		String[] arrays = FabricLoader.getInstance().getLaunchArguments(true);
		logger.info("Arguments :");
		for (String array : arrays) {
			logger.info(array);
		}
	}
}