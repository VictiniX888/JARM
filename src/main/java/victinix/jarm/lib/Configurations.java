package victinix.jarm.lib;

import net.minecraftforge.common.config.Configuration;

public class Configurations {

    public static Configuration config;
    public static boolean configExists;

    public static boolean randomGunRegistry;

    public static String randomGunText;

    public static boolean refreshConfig() {

        String category;

        category = "registry";
        randomGunRegistry = config.get(category, "randomGunRegistry", true).getBoolean(true);

        category = "weapons";
        randomGunText = config.get(category, "randomGunText", "Hello world", "Text that appears when Random Gun is used.").getString();

        if(config.hasChanged()) {
            config.save();
        }

        return true;
    }
}
