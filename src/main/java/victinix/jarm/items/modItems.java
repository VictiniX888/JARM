package victinix.jarm.items;

import net.minecraft.item.Item;
import victinix.jarm.items.food.hotdog;
import victinix.jarm.items.magicStuff.magicCarpet;
import victinix.jarm.items.randomWeapons.emeraldSword;
import victinix.jarm.items.randomWeapons.randomGun;
import victinix.jarm.libs.Configurations;
import victinix.jarm.libs.Materials;

public class modItems {

    public static Item hotdog;

    public static Item magicCarpet;

    public static Item emeraldSword;
    public static Item randomGun;

    public static void init() {

        hotdog = new hotdog(Configurations.hotdogHeal, (float) Configurations.hotdogSaturation, Configurations.hotdogWolfMeat);

        magicCarpet = new magicCarpet();

        emeraldSword = new emeraldSword(Materials.RANDOMEMERALD);

        randomGun = new randomGun();
    }
}
