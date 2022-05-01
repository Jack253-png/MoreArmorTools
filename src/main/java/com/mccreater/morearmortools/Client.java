package com.mccreater.morearmortools;

import com.mccreater.morearmortools.utils.GetNumMaxAndMin;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.loader.api.FabricLoader;
import net.fabricmc.loader.api.ModContainer;
import net.fabricmc.loader.impl.FabricLoaderImpl;

import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import java.awt.*;

import java.lang.Thread;

import java.text.DecimalFormat;
import java.util.Collection;
import java.util.Date;
import java.util.Enumeration;
import java.util.Objects;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

import com.mccreater.morearmortools.utils.getBytes;
import com.mccreater.morearmortools.utils.spiltString;
import com.mccreater.morearmortools.config.ConfigReader;
import com.mccreater.morearmortools.config.ConfigResult;
import static com.mccreater.morearmortools.Vars.modid;
import com.mccreater.morearmortools.config.ConfigWriter;

import javax.swing.*;
import javax.swing.plaf.FontUIResource;

public class Client implements ModInitializer {
	public static final Logger logger = LoggerFactory.getLogger("More Armor Tools Logger");
	public static boolean debug = true;
	Thread getmods;
	Thread initlaze;
	String minecraft_version;
	String loader_version;
	String java_version;
	String mod_version;
	Thread font;
	@Override
	public void onInitialize(){
		logger.info("getting config");
		ConfigReader configReader = new ConfigReader();
		ConfigResult configResult = configReader.readConfig();
		if (configResult != null){
			debug = configResult.debug;
		}
		initlaze = new Thread(this::initlaze);
		initlaze.setName("More Armor Tools Initlaze Thread");
		initlaze.start();
		getmods = new Thread(this::GetMods);
		getmods.setName("Get Mod List");
		try {
			logger.info("Fabric Version : " + FabricLoaderImpl.VERSION);
		}
		catch (Exception e){
			logger.error("Fabric version not found",e);
		}
		font = new Thread(() -> {
			if (configResult != null) {
				showWindow(configResult);
			}
		});
		font.setName("Look and Feel Change Thread");
		if (configResult != null) {
			if (configResult.changeUiLookAndFeel) {
				font.start();
			}
		}
	}
	public void showWindow(ConfigResult r){
		FontUIResource fontRes = new FontUIResource(new Font(r.FontName,r.FontType,r.FontSize));
		for(Enumeration<Object> keys = UIManager.getDefaults().keys(); keys.hasMoreElements();){
			Object key = keys.nextElement();
			Object value = UIManager.get(key);
			if(value instanceof FontUIResource) {
				UIManager.put(key, fontRes);
				logger.info("Put font for key : " + key);
			}
		}
		try {
			UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
		}
		catch (Exception e){
			e.printStackTrace();
		}
	}
	public void initlaze(){
		try {
			if (debug) {
				logger.info("Now Time:" + new Date());
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
				logger.info("Detected " + totalThread + " threads running");
				logger.info("");
				logger.info("Bytes Value Limit : " + GetNumMaxAndMin.getByte());
				logger.info("Chars Value Limit : " + GetNumMaxAndMin.getChar());
				logger.info("Floats Value Limit : " + GetNumMaxAndMin.getFloat());
				logger.info("Doubles Value Limit : " + GetNumMaxAndMin.getDouble());
				logger.info("Short Value Limit : " + GetNumMaxAndMin.getShort());
				logger.info("Ints Value Limit : " + GetNumMaxAndMin.getInt());
				logger.info("Longs Value Limit : " + GetNumMaxAndMin.getLong());
			}


			Registry.register(Registry.ITEM, new Identifier(modid, "wool_hamlet"), Group.WoolHelmet);
			Registry.register(Registry.ITEM, new Identifier(modid, "wool_chestplate"), Group.WoolChestplate);
			Registry.register(Registry.ITEM, new Identifier(modid, "wool_leggings"), Group.WoolLeggings);
			Registry.register(Registry.ITEM, new Identifier(modid, "wool_boots"), Group.WoolBoots);
			Registry.register(Registry.ITEM, new Identifier(modid, "wool_axe"), Group.WoolAxe);
			Registry.register(Registry.ITEM, new Identifier(modid, "wool_sword"), Group.WoolSword);
			Registry.register(Registry.ITEM, new Identifier(modid, "wool_pickaxe"), Group.WoolPickaxe);
			Registry.register(Registry.ITEM, new Identifier(modid, "wool_shovel"), Group.WoolShovel);
			Registry.register(Registry.ITEM, new Identifier(modid, "wool_hoe"), Group.WoolHoe);
			logger.info("Wool Tools Registered");


			Registry.register(Registry.ITEM, new Identifier(modid, "compressionwoodsword"), Group.CompressionWoodSword);
			Registry.register(Registry.ITEM, new Identifier(modid, "compressionstick1x"), Group.CompressionStick1x);
			Registry.register(Registry.ITEM, new Identifier(modid, "compressionstick2x"), Group.CompressionStick2x);
			Registry.register(Registry.ITEM, new Identifier(modid, "compressionstick3x"), Group.CompressionStick3x);
			Registry.register(Registry.ITEM, new Identifier(modid, "compressionstick4x"), Group.CompressionStick4x);
			Registry.register(Registry.ITEM, new Identifier(modid, "compressionstick5x"), Group.CompressionStick5x);
			Registry.register(Registry.ITEM, new Identifier(modid, "compressionstick6x"), Group.CompressionStick6x);
			Registry.register(Registry.ITEM, new Identifier(modid, "compressionstick7x"), Group.CompressionStick7x);
			Registry.register(Registry.ITEM, new Identifier(modid, "compressionstick8x"), Group.CompressionStick8x);
			Registry.register(Registry.ITEM, new Identifier(modid, "compressionstick9x"), Group.CompressionStick9x);
			logger.info("Compress Stick Tools Registered");

			Registry.register(Registry.BLOCK, new Identifier(modid, "irongoldblock"), Group.IronGoldBlock);
			Registry.register(Registry.ITEM, new Identifier(modid, "irongoldblock"), new BlockItem(Group.IronGoldBlock, new Item.Settings().group(Group.Materials)));
			Registry.register(Registry.ITEM, new Identifier(modid, "irongoldingot"), Group.IronGoldIngot);
			Registry.register(Registry.ITEM, new Identifier(modid, "irongoldaxe"), Group.IronGoldAxe);
			Registry.register(Registry.ITEM, new Identifier(modid, "irongoldpickaxe"), Group.IronGoldPickaxe);
			Registry.register(Registry.ITEM, new Identifier(modid, "irongoldsword"), Group.IronGoldSword);
			Registry.register(Registry.ITEM, new Identifier(modid, "irongoldshovel"), Group.IronGoldShovel);
			Registry.register(Registry.ITEM, new Identifier(modid, "irongoldhoe"), Group.IronGoldHoe);
			Registry.register(Registry.ITEM, new Identifier(modid, "irongoldhemlet"), Group.IronGoldHemlet);
			Registry.register(Registry.ITEM, new Identifier(modid, "irongoldchestplate"), Group.IronGoldChestplate);
			Registry.register(Registry.ITEM, new Identifier(modid, "irongoldleggings"), Group.IronGoldLeggings);
			Registry.register(Registry.ITEM, new Identifier(modid, "irongoldboots"), Group.IronGoldBoots);
			Registry.register(Registry.ITEM, new Identifier(modid, "irongoldingottoirongoldblock"), Group.IronGoldBlockToIronGoldIngot);
			logger.info("IronGold Tools Registered");

			Registry.register(Registry.ITEM, new Identifier(modid, "copperaxe"), Group.CopperAxe);
			Registry.register(Registry.ITEM, new Identifier(modid, "copperpickaxe"), Group.CopperPickaxe);
			Registry.register(Registry.ITEM, new Identifier(modid, "coppersword"), Group.CopperSword);
			Registry.register(Registry.ITEM, new Identifier(modid, "coppershovel"), Group.CopperShovel);
			Registry.register(Registry.ITEM, new Identifier(modid, "copperhoe"), Group.CopperHoe);
			Registry.register(Registry.ITEM, new Identifier(modid, "copperhelmet"), Group.CopperHelmet);
			Registry.register(Registry.ITEM, new Identifier(modid, "copperchestplate"), Group.CopperChestPlate);
			Registry.register(Registry.ITEM, new Identifier(modid, "copperleggings"), Group.CopperLeggings);
			Registry.register(Registry.ITEM, new Identifier(modid, "copperboots"), Group.CopperBoots);
			logger.info("Copper Tools Registered");

			Registry.register(Registry.ITEM, new Identifier(modid, "obsidianaxe"), Group.ObsidianAxe);
			Registry.register(Registry.ITEM, new Identifier(modid, "obsidianpickaxe"), Group.ObsidianPickaxe);
			Registry.register(Registry.ITEM, new Identifier(modid, "obsidiansword"), Group.ObsidianSword);
			Registry.register(Registry.ITEM, new Identifier(modid, "obsidianshovel"), Group.ObsidianShovel);
			Registry.register(Registry.ITEM, new Identifier(modid, "obsidianhoe"), Group.ObsidianHoe);
			Registry.register(Registry.ITEM, new Identifier(modid, "obsidianhelmet"), Group.ObsidianHelmet);
			Registry.register(Registry.ITEM, new Identifier(modid, "obsidianchestplate"), Group.ObsidianChestplate);
			Registry.register(Registry.ITEM, new Identifier(modid, "obsidianleggings"), Group.ObsidianLeggings);
			Registry.register(Registry.ITEM, new Identifier(modid, "obsidianboots"), Group.ObsidianBoots);
			logger.info("Obsidian Tools Registered");

			Registry.register(Registry.ITEM, new Identifier(modid, "grass_helmet"), Group.GrassBlockHelmet);
			Registry.register(Registry.ITEM, new Identifier(modid, "grass_chestplate"), Group.GrassBlockChestPlate);
			Registry.register(Registry.ITEM, new Identifier(modid, "grass_leggings"), Group.GrassBlockLeggings);
			Registry.register(Registry.ITEM, new Identifier(modid, "grass_boots"),Group.GrassBlockBoots);
			Registry.register(Registry.ITEM, new Identifier(modid, "grass_axe"),Group.GrassBlockAxe);
			Registry.register(Registry.ITEM, new Identifier(modid, "grass_sword"),Group.GrassBlockSword);
			Registry.register(Registry.ITEM, new Identifier(modid, "grass_pickaxe"),Group.GrassBlockPickaxe);
			Registry.register(Registry.ITEM, new Identifier(modid, "grass_hoe"),Group.GrassBlockHoe);
			Registry.register(Registry.ITEM, new Identifier(modid, "grass_shovel"),Group.GrassBlockShovel);

			logger.info("Grass Tools Registered");

			logger.info("Items Registried");

			logger.info("In debug : "+debug);
			if (debug) {
				getmods.start();
			}
		}
		catch (Exception e){
			e.printStackTrace();
			logger.error("An Exception declared , "+ e);
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
				if (Objects.equals(m.toString().split(" ")[0], "fabricloader")) {
					loader_version = m.toString().split(" ")[1];
				}
				else if (Objects.equals(m.toString().split(" ")[0], "minecraft")) {
					minecraft_version = m.toString().split(" ")[1];
				}
				else if (Objects.equals(m.toString().split(" ")[0], "morearmortools")){
					mod_version = m.toString().split(" ")[1];
				}
			}

			String[] arguments = FabricLoader.getInstance().getLaunchArguments(true);
			logger.info("Arguments :");
			for (String array : arguments) {
				logger.info(array);
			}
			java_version = System.getProperty("java.version");
			logger.info("Java Version : " + java_version +
					    " , Minecraft Version : " + minecraft_version +
					    " , Fabric Loader Version : " + loader_version +
					    " , Mod Version : " + mod_version);
		}
		catch (Exception e){
			e.printStackTrace();
			throw e;
		}
	}
}
