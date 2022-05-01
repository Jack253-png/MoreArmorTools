package com.mccreater.morearmortools.mixin;

import com.mccreater.morearmortools.screen.ConfigScreen;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.screen.option.OptionsScreen;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(OptionsScreen.class)
public class MixinClient extends Screen {
	protected MixinClient(Text title) {
		super(title);
	}
	@Inject(at = @At("HEAD"), method = "init()V")
	private void init(CallbackInfo info) {
		this.addDrawableChild(new ButtonWidget(this.width / 2 + 5, this.height / 6 + 48 - 6 - 24,150,20,new TranslatableText("morearmortools.menu.options"),button -> {
			this.client.setScreen(new ConfigScreen(this));
		}));
	}
}