package com.mccreater.morearmortools;

import net.fabricmc.api.ModInitializer;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import com.mccreater.morearmortools.blocks.Group;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import java.lang.Thread;
import java.util.Date;
import net.minecraft.item.Items;

public class Client implements ModInitializer {
	public static final Logger logger = LogManager.getLogger("More Armor Tools Logger");

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
			logger.info("Max Memory:"+Runtime.getRuntime().maxMemory() / 1024 / 1024+"MB");
			logger.info("Run on OS:"+ System.getProperty("os.name"));

			ThreadGroup parentThread;
			int totalThread = 0;
			for (parentThread = Thread.currentThread().getThreadGroup(); parentThread
					.getParent() != null; parentThread = parentThread.getParent()) {
				totalThread = parentThread.activeCount();
			}
			logger.info("Threads:"+totalThread);
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
			logger.info("Items Registried");
		}
		catch (Exception e){
			e.printStackTrace();
			logger.error("An Exception declared , "+e.toString());
			throw e;
		}
	}

}
