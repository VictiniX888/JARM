package victinix.jarm.libs;

import net.minecraftforge.common.config.Configuration;
import victinix.jarm.items.modItems;

/**
 * Created by VictiniX888 on 31-Jan-2015.
 */

public class Configurations {

    public static Configuration config;
    public static boolean configExists;
    public static boolean randomGunRegister;

    public static boolean refreshConfig() {

        String category;

        /* registry */
        category = "registry";

        randomGunRegister = config.get(category, "randomGunRegister", true).getBoolean();

        if (config.hasChanged())
            config.save();

        return true;
    }
}
