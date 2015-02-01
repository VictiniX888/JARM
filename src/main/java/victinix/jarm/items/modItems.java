package victinix.jarm.items;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.Item;
import victinix.jarm.libs.Configurations;

/**
 * Created by VictiniX888 on 31-Jan-2015.
 */

public class modItems {

    public static Item randomGun;
    public static Item hotdog;

    public static void init() {

        randomGun = new victinix.jarm.items.randomWeapons.randomGun();
        if(Configurations.randomGunRegister)
            GameRegistry.registerItem(randomGun, "randomGun");
        hotdog = new victinix.jarm.items.food.hotdog(10, 0.8f, true);
        if(Configurations.hotdogRegister)
            GameRegistry.registerItem(hotdog, "hotdog");
    }
}
