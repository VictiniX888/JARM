package victinix.jarm.items;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.Item;
import net.minecraftforge.common.config.Configuration;
import victinix.jarm.jarm;
import victinix.jarm.libs.Configurations;

/**
 * Created by VictiniX888 on 31-Jan-2015.
 */

public class modItems {

    public static Item randomGun;

    public static void init() {

        randomGun = new victinix.jarm.items.randomWeapons.randomGun();
        if(Configurations.randomGunRegister)
            GameRegistry.registerItem(randomGun, "randomGun");
    }
}
