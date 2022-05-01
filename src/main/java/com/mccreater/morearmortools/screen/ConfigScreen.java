package com.mccreater.morearmortools.screen;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.text.TranslatableText;
import com.mccreater.morearmortools.utils.rgb2int;

public class ConfigScreen extends Screen {
    private final Screen screen;
    int starty = 60;
    int stuff = 20;
    public ConfigScreen(Screen screen){
        super(new TranslatableText("morearmortools.menu.option.maintitle"));
        this.screen = screen;
    }
    public void render(MatrixStack m,int x,int y,float d){
        this.renderBackground(m);
        drawCenteredText(m, this.textRenderer, this.title, this.width / 2, 20 ,  rgb2int.toint("ffffff"));
        drawCenteredText(m, this.textRenderer, new TranslatableText("morearmortools.menu.option.warn"), this.width / 2,this.height / 6 + 148,rgb2int.toint("fe2a1f"));
        super.render(m,x,y,d);
    }
    public void init(){
        super.init();
        int center = this.width / 2;
        int width = 100;
        int height = 20;
        int leftx = this.width / 4 - width / 2;
        int rightx = this.width / 4 * 3 - width / 2;
        int buttonw = (int)(width * 1.5);
        this.addDrawableChild(new ButtonWidget(center - width, this.height / 6 + 168, width * 2, height,new TranslatableText("morearmortools.menu.configdone"),(action) -> {
            MinecraftClient.getInstance().setScreen(screen);
        }));
        this.addDrawableChild(new ButtonWidget(center - buttonw / 2 , gety(0,height / 2), buttonw, height , new TranslatableText("morearmortools.menu.option.debugtitle") , (action) -> {
            this.client.setScreen(new DebugConfigScreen(this));
        }));
    }
    public int gety(int n,int o){
        return starty + n * stuff - o;
    }
}