package victinix.jarm.items;

import net.minecraft.item.Item;

/**
 * Created by VictiniX888 on 31-Jan-2015.
 */

public class modItems {

    public static Item randomGun;

    public static void init() {

        randomGun = new victinix.jarm.items.randomWeapons.randomGun();
    }
}
