package com.leo.guiopacity.mixins;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Pseudo;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;

import com.leo.guiopacity.Config;

/**
 * ModularUI 2 (used by GregTech machines and most GTNH GUIs) draws its own dark backdrop and
 * never goes through GuiScreen.drawWorldBackground. Pseudo: does nothing if ModularUI 2 is absent.
 */
@Pseudo
@Mixin(targets = "com.cleanroommc.modularui.screen.ClientScreenHandler", remap = false)
public abstract class MixinModularUIScreenHandler {

    private static final String DRAW_GRADIENT = "Lcom/cleanroommc/modularui/drawable/GuiDraw;drawVerticalGradientRect(FFFFII)V";

    @ModifyArg(
        method = "drawDarkBackground",
        at = @At(value = "INVOKE", target = DRAW_GRADIENT, remap = false),
        index = 4,
        remap = false)
    private static int guiopacity$scaleStartColor(int color) {
        return Config.scaleAlpha(color);
    }

    @ModifyArg(
        method = "drawDarkBackground",
        at = @At(value = "INVOKE", target = DRAW_GRADIENT, remap = false),
        index = 5,
        remap = false)
    private static int guiopacity$scaleEndColor(int color) {
        return Config.scaleAlpha(color);
    }
}
