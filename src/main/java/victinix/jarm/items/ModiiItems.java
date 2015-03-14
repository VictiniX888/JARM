package victinix.jarm.items;

import net.minecraft.item.Item;
import net.minecraftforge.common.util.EnumHelper;
import victinix.jarm.items.food.Hotdogg;
import victinix.jarm.items.randomweaponss.DiamondHandbagg;
import victinix.jarm.items.randomweaponss.EmeraldSwordd;
import victinix.jarm.items.randomweaponss.RandomGunn;
import victinix.jarm.libs.Configurationss;

public class ModiiItems {

    public static Item.ToolMaterial RANDOMEMERALD;

    public static Item hotdog;

    public static Item diamondHandbag;
    public static Item emeraldSword;
    public static Item randomGun;

    public static void init() {

        RANDOMEMERALD = EnumHelper.addToolMaterial("RANDOMEMERALD", Configurationss.emeraldSwordHarvestLevel, Configurationss.emeraldSwordDurability, (float) Configurationss.emeraldSwordMiningSpeed, (float) Configurationss.emeraldSwordDamage, Configurationss.emeraldSwordEnchantability);

        hotdog = new Hotdogg(Configurationss.hotdogHeal, (float) Configurationss.hotdogSaturation, true);

        diamondHandbag = new DiamondHandbagg(Item.ToolMaterial.EMERALD);
        emeraldSword = new EmeraldSwordd(ModiiItems.RANDOMEMERALD);
        randomGun = new RandomGunn();
    }
}
