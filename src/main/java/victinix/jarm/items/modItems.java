package victinix.jarm.items;

import net.minecraft.item.Item;
import net.minecraftforge.common.util.EnumHelper;
import victinix.jarm.items.food.hotdog;
import victinix.jarm.items.magicStuff.magicCarpet;
import victinix.jarm.items.randomWeapons.emeraldSword;
import victinix.jarm.items.randomWeapons.randomGun;
import victinix.jarm.libs.Configurations;

public class modItems {

    public static Item.ToolMaterial RANDOMEMERALD;

    public static Item hotdog;

    public static Item magicCarpet;

    public static Item emeraldSword;
    public static Item randomGun;

    public static void init() {

        RANDOMEMERALD = EnumHelper.addToolMaterial("RANDOMEMERALD", Configurations.emeraldSwordHarvestLevel, Configurations.emeraldSwordDurability, (float) Configurations.emeraldSwordMiningSpeed, (float) Configurations.emeraldSwordDamage, Configurations.emeraldSwordEnchantability);

        hotdog = new hotdog(Configurations.hotdogHeal, (float) Configurations.hotdogSaturation, Configurations.hotdogWolfMeat);

        magicCarpet = new magicCarpet();

        emeraldSword = new emeraldSword(modItems.RANDOMEMERALD);
        randomGun = new randomGun();
    }
}
