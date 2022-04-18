package com.mccreater.morearmortools.config;

import com.google.gson.Gson;
import net.fabricmc.loader.api.FabricLoader;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ConfigReader {
    public ConfigResult readConfig(){
        String configdir = FabricLoader.getInstance().getConfigDir().toString() + "\\morearmortools\\morearmortools.json";
        Path path = Paths.get(FabricLoader.getInstance().getConfigDir().toString() + "\\morearmortools");
        try {
            try {
                Files.createDirectories(path);
            }
            catch (IOException ex){
                ex.printStackTrace();
            }
            File configfile = new File(configdir);
            if (!configfile.canRead()) {
                FileOutputStream configinitlaze = new FileOutputStream(configfile);
                configinitlaze.write("{\n  \"debug\" : true\n}".getBytes());

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
            ConfigResult config = gson.fromJson(jsonStr,ConfigResult.class);
            return config;

        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
