package victinix.jarm.libs;

import net.minecraftforge.common.config.Configuration;

/**
 * Created by VictiniX888 on 31-Jan-2015.
 */

public class Configurations {

    public static Configuration config;
    public static boolean configExists;

    public static boolean randomGunRegister;
    public static boolean hotdogRegister;

    public static String randomGunText;
    public static String randomGunTexture;

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

        if (config.hasChanged())
            config.save();

        return true;
    }
}
