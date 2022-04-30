package com.mccreater.morearmortools.config;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import net.fabricmc.loader.api.FabricLoader;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ConfigWriter {
    String defaultconfig;
    ConfigReader reader = new ConfigReader();
    public ConfigResult nowConfig;
    FileWriter writer;
    String configdir;
    String configdir2;
    public ConfigWriter(){
        configdir = FabricLoader.getInstance().getConfigDir().toString() + "\\morearmortools\\morearmortools.json";
        configdir2 = FabricLoader.getInstance().getConfigDir().toString() + "\\morearmortools";
        defaultconfig = """
                {
                   "debug": true,
                   "changeUiLookAndFeel": true,
                   "FontName": "Consolas",
                   "FontSize": 14,
                   "FontType": 2
                 }""";
        nowConfig = reader.readConfig();

    }
    public void writeConfig(){
        try {
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            writer = new FileWriter(configdir);
            writer.write(gson.toJson(nowConfig));
            writer.close();
        }
        catch (IOException e){
            e.printStackTrace();
        }

    }

}
