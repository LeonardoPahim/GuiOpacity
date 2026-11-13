package com.leo.guiopacity;

import net.minecraft.client.gui.GuiScreen;
import net.minecraftforge.common.config.ConfigElement;
import net.minecraftforge.common.config.Configuration;

import cpw.mods.fml.client.config.GuiConfig;

public class ConfigGui extends GuiConfig {

    public ConfigGui(GuiScreen parent) {
        super(
            parent,
            new ConfigElement(Config.configuration.getCategory(Configuration.CATEGORY_GENERAL)).getChildElements(),
            GuiOpacity.MODID,
            false,
            false,
            "GuiOpacity");
    }
}
