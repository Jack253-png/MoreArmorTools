package com.mccreater.morearmortools.screen;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.text.TranslatableText;
import com.mccreater.morearmortools.utils.rgb2int;
import com.mccreater.morearmortools.config.ConfigWriter;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import net.minecraft.util.Util;
import static com.mccreater.morearmortools.Vars.github_project_url;
import static com.mccreater.morearmortools.Vars.github_report_url;

public class ConfigScreen extends Screen {
    private final Screen screen;
    int starty = 60;
    int stuff = 20;
    Logger logger = LoggerFactory.getLogger("OptionScreen");
    ConfigWriter writer = new ConfigWriter();
    boolean debug = writer.nowConfig.debug;
    int fontsize = writer.nowConfig.FontSize;

    public ConfigScreen(Screen screen){
        super(new TranslatableText("morearmortools.menu.option.title"));
        this.screen = screen;
    }
    public void render(MatrixStack m,int x,int y,float d){
        this.renderBackground(m);
        drawCenteredText(m, this.textRenderer, this.title, this.width / 2,20,rgb2int.toint("ffffff"));
        drawCenteredText(m, this.textRenderer, new TranslatableText("morearmortools.menu.option.isdebug"),this.width / 4,starty,rgb2int.toint("ffffff"));
        drawCenteredText(m, this.textRenderer, new TranslatableText("morearmortools.menu.option.serverfontsize"),this.width / 4,starty + stuff,rgb2int.toint("ffffff"));
        drawCenteredText(m, this.textRenderer, new TranslatableText("morearmortools.menu.option.warn"), this.width / 2,this.height / 6 + 148,rgb2int.toint("fe2a1f"));
        drawCenteredText(m, this.textRenderer, new TranslatableText("morearmortools.menu.option.open.github.project"), this.width / 4,starty + 2 * stuff,rgb2int.toint("ffffff"));
        drawCenteredText(m, this.textRenderer, new TranslatableText("morearmortools.menu.option.open.github.report"), this.width / 4,starty + 3 * stuff,rgb2int.toint("ffffff"));
        super.render(m,x,y,d);
    }
    public void init(){
        super.init();
        int rightx = this.width / 4 * 3 - 50;
        int width = 100;
        int height = 20;
        this.addDrawableChild(new ButtonWidget(this.width / 2 - 100, this.height / 6 + 168, width * 2, height,new TranslatableText("morearmortools.menu.configdone"),(action) -> {
            MinecraftClient.getInstance().setScreen(screen);
            writer.nowConfig.debug = debug;
            writer.nowConfig.FontSize = fontsize;
            writer.writeConfig();
            logger.info("config written");
        }));
        this.addDrawableChild(new ButtonWidget(rightx, starty - 10,width,height, getText2(debug),button -> {
            debug = !debug;
            button.setMessage(getText2(debug));
        }));
        this.addDrawableChild(new ButtonWidget(rightx,gety(1,10),width,height,getText(fontsize),button -> {
            fontsize += 6;
            if (fontsize > 26){
                fontsize = 14;
            }
            button.setMessage(getText(fontsize));
        }));
        this.addDrawableChild(new ButtonWidget(rightx,gety(2,10),width,height,new TranslatableText("morearmortools.menu.option.open.withbrowser"),button -> {
            Util.getOperatingSystem().open(github_project_url);
        }));
        this.addDrawableChild(new ButtonWidget(rightx,gety(3,10),width,height,new TranslatableText("morearmortools.menu.option.open.withbrowser"),button -> {
            Util.getOperatingSystem().open(github_report_url);
        }));
    }
    public TranslatableText getText(int fontsize){
        if (fontsize == 14){
            return new TranslatableText("morearmortools.menu.option.fontsize.small");
        }
        else if (fontsize == 20){
            return new TranslatableText("morearmortools.menu.option.fontsize.mid");
        }
        else{
            return new TranslatableText("morearmortools.menu.option.fontsize.large");
        }
    }
    public TranslatableText getText2(boolean b){
        if (b){
            return new TranslatableText("morearmortools.menu.option.debug.on");
        }else{
            return new TranslatableText("morearmortools.menu.option.debug.off");
        }
    }
    public int gety(int n,int o){
        return starty + n * stuff - o;
    }
}