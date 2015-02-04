package victinix.jarm.items;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.Item;
import net.minecraftforge.common.util.EnumHelper;
import victinix.jarm.items.magicStuff.magicCarpet;
import victinix.jarm.libs.Configurations;

public class modItems {

    public static Item.ToolMaterial RANDOMEMERALD;

    public static Item hotdog;

    public static Item magicCarpet;

    public static Item emeraldSword;
    public static Item randomGun;

    public static void init() {

        RANDOMEMERALD = EnumHelper.addToolMaterial("RANDOMEMERALD", Configurations.emeraldSwordHarvestLevel, Configurations.emeraldSwordDurability, (float) Configurations.emeraldSwordMiningSpeed, (float) Configurations.emeraldSwordDamage, Configurations.emeraldSwordEnchantability);

        hotdog = new victinix.jarm.items.food.hotdog(Configurations.hotdogHeal, (float) Configurations.hotdogSaturation, Configurations.hotdogWolfMeat);
        if(Configurations.hotdogRegister)
            GameRegistry.registerItem(hotdog, "hotdog");

        magicCarpet = new magicCarpet();
        GameRegistry.registerItem(magicCarpet, "magicCarpet");

        emeraldSword = new victinix.jarm.items.randomWeapons.emeraldSword(modItems.RANDOMEMERALD);
        if(Configurations.emeraldSwordRegister)
            GameRegistry.registerItem(emeraldSword, "emeraldSword");
        randomGun = new victinix.jarm.items.randomWeapons.randomGun();
        if(Configurations.randomGunRegister)
            GameRegistry.registerItem(randomGun, "randomGun");
    }
}
