package com.leo.guiopacity;

import cpw.mods.fml.client.event.ConfigChangedEvent;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;

@Mod(
    modid = GuiOpacity.MODID,
    version = Tags.VERSION,
    name = "GuiOpacity",
    acceptedMinecraftVersions = "[1.7.10]",
    acceptableRemoteVersions = "*",
    guiFactory = "com.leo.guiopacity.GuiFactory")
public class GuiOpacity {

    public static final String MODID = "guiopacity";

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        Config.synchronizeConfiguration(event.getSuggestedConfigurationFile());
        FMLCommonHandler.instance()
            .bus()
            .register(this);
    }

    @SubscribeEvent
    public void onConfigChanged(ConfigChangedEvent.OnConfigChangedEvent event) {
        if (MODID.equals(event.modID)) {
            Config.synchronizeConfiguration();
        }
    }
}
