package com.leo.guiopacity;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

@Mod(
    modid = GuiOpacity.MODID,
    version = Tags.VERSION,
    name = "GuiOpacity",
    acceptedMinecraftVersions = "[1.7.10]",
    acceptableRemoteVersions = "*")
public class GuiOpacity {

    public static final String MODID = "guiopacity";

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        Config.synchronizeConfiguration(event.getSuggestedConfigurationFile());
    }
}
