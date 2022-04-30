package com.mccreater.morearmortools.config;

import com.google.gson.Gson;
import net.fabricmc.loader.api.FabricLoader;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ConfigReader {
    String defaultconfig;
    Logger logger;
    public ConfigResult readConfig(){
        String configdir = FabricLoader.getInstance().getConfigDir().toString() + "\\morearmortools\\morearmortools.json";
        Path path = Paths.get(FabricLoader.getInstance().getConfigDir().toString() + "\\morearmortools");
        logger = LoggerFactory.getLogger("ConfigReader");
        defaultconfig = """
                {
                   "debug": true,
                   "changeUiLookAndFeel": true,
                   "FontName": "Consolas",
                   "FontSize": 14,
                   "FontType": 2
                 }""";
        try {
            try {
                Files.createDirectories(path);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            File configfile = new File(configdir);
            if (!configfile.canRead()) {
                FileOutputStream configinitlaze = new FileOutputStream(configfile);
                configinitlaze.write(defaultconfig.getBytes());
            }
            FileReader fileReader = new FileReader(configfile);
            Reader reader = new InputStreamReader(new FileInputStream(configfile), StandardCharsets.UTF_8);
            int ch = 0;
            StringBuilder sb = new StringBuilder();
            while ((ch = reader.read()) != -1) {
                sb.append((char) ch);
            }
            fileReader.close();
            reader.close();
            String jsonStr = sb.toString();
            Gson gson = new Gson();
            ConfigResult config;
            try {
                config = gson.fromJson(jsonStr, ConfigResult.class);
            }
            catch(Exception e){
                logger.error("Config Broken",e);
                logger.warn("Please delete morearmortools config and try again");
                throw e;
            }
            return config;
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
