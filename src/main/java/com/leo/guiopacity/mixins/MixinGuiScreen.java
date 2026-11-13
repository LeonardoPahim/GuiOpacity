package com.leo.guiopacity.mixins;

import net.minecraft.client.gui.GuiScreen;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;

import com.leo.guiopacity.Config;

@Mixin(GuiScreen.class)
public abstract class MixinGuiScreen {

    private static final String DRAW_GRADIENT = "Lnet/minecraft/client/gui/GuiScreen;drawGradientRect(IIIIII)V";

    // drawGradientRect(left, top, right, bottom, startColor, endColor): args 4 and 5 are the colors.
    @ModifyArg(method = "drawWorldBackground", at = @At(value = "INVOKE", target = DRAW_GRADIENT), index = 4)
    private int guiopacity$scaleStartColor(int color) {
        return Config.scaleAlpha(color);
    }

    @ModifyArg(method = "drawWorldBackground", at = @At(value = "INVOKE", target = DRAW_GRADIENT), index = 5)
    private int guiopacity$scaleEndColor(int color) {
        return Config.scaleAlpha(color);
    }
}
