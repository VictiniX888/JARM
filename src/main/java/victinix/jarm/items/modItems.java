package victinix.jarm.items;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.Item;

/**
 * Created by VictiniX888 on 31-Jan-2015.
 */

public class modItems {

    public static Item randomGun;

    public static void init() {

        randomGun = new victinix.jarm.items.randomWeapons.randomGun();
        GameRegistry.registerItem(randomGun, "randomGun");
    }
}
