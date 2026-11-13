package com.leo.guiopacity;

import java.io.File;

import net.minecraftforge.common.config.Configuration;

public class Config {

    /** Multiplier applied to the alpha of the dark overlay. 1.0 = vanilla, 0.0 = no overlay. */
    public static float backgroundOpacity = 0.5f;

    public static Configuration configuration;

    public static void synchronizeConfiguration(File configFile) {
        configuration = new Configuration(configFile);
        synchronizeConfiguration();
    }

    /** Reads values from the Configuration object (also called after edits in the in-game config screen). */
    public static void synchronizeConfiguration() {
        backgroundOpacity = configuration.getFloat(
            "backgroundOpacity",
            Configuration.CATEGORY_GENERAL,
            0.5f,
            0.0f,
            1.0f,
            "Opacity of the dark overlay drawn behind inventories and other GUIs, as a fraction of vanilla. 1.0 = vanilla, 0.5 = half as dark, 0.0 = no darkening at all.");

        if (configuration.hasChanged()) {
            configuration.save();
        }
    }

    /** Scales the alpha channel of an ARGB color by the configured opacity. */
    public static int scaleAlpha(int argb) {
        int alpha = Math.round((argb >>> 24) * backgroundOpacity);
        if (alpha < 0) alpha = 0;
        if (alpha > 255) alpha = 255;
        return (alpha << 24) | (argb & 0x00FFFFFF);
    }
}
