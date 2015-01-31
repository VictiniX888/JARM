package victinix.jarm.libs;

import net.minecraftforge.common.config.Configuration;

/**
 * Created by VictiniX888 on 31-Jan-2015.
 */

public class Configurations {

    public static Configuration config;
    public static boolean configExists;

    public static boolean randomGunRegister;

    public static String randomGunText;

    public static boolean refreshConfig() {

        String category;

        /* registry */
        category = "registry";

        randomGunRegister = config.get(category, "randomGunRegister", true).getBoolean(true);

        /* randomText */
        category = "randomText";

        randomGunText = config.get(category, "randomGunText", "Malware has been installed on your PC", "Text that appears when Random Gun is used.").getString();

        if (config.hasChanged())
            config.save();

        return true;
    }
}
