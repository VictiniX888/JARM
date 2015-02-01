package victinix.jarm.libs;

import net.minecraftforge.common.config.Configuration;

/**
 * Created by VictiniX888 on 31-Jan-2015.
 * It's distributed as part of the JARM Mod.
 * Get the Source Code in github:
 * https://github.com/VictiniX888/JARM
 *
 * JARM is Open Source and distributed under the
 * Creative Commons Attribution-NonCommercial-ShareAlike
 * 4.0 International Public License
 */

public class Configurations {

    public static Configuration config;
    public static boolean configExists;

    public static boolean randomGunRegister;
    public static boolean hotdogRegister;

    public static String randomGunText;
    public static String randomGunTexture;

    public static int hotdogHeal;
    public static double hotdogSaturation;
    public static boolean hotdogWolfMeat;

    public static boolean refreshConfig() {

        String category;

        //registry
        category = "registry";

        randomGunRegister = config.get(category, "randomGunRegister", true).getBoolean(true);
        hotdogRegister = config.get(category, "hotdogRegister", true).getBoolean(true);

        //randomWeapons
        category = "randomWeapons";

        randomGunText = config.get(category, "randomGunText", "Malware has been installed on your PC", "Text that appears when Random Gun is used.").getString();
        randomGunTexture = config.get(category, "randomGunTexture", "pistol", "Texture for Random Gun. Options = pistol & submachineGun").getString();

        //food
        category = "food";

        hotdogHeal = config.get(category, "hotdogHeal", 10, "Amount of hunger Hotdog heals").getInt();
        hotdogSaturation = config.get(category, "hotdogSaturation", 0.8F, "Amount of saturation Hotdog gives. The original config option is correct, however, setting the value as X.XF would be easier. Example = 0.8F").getDouble();
        hotdogWolfMeat = config.get(category, "hotdogWolfMeat", true, "Can Hotdog be eaten by wolves?").getBoolean(true);

        if (config.hasChanged())
            config.save();

        return true;
    }
}
