package victinix.jarm.items;

import net.minecraft.item.Item;
import net.minecraftforge.common.util.EnumHelper;
import victinix.jarm.items.food.CookedSquid;
import victinix.jarm.items.food.CoolSquid;
import victinix.jarm.items.food.Hotdog;
import victinix.jarm.items.magic.Ditto;
import victinix.jarm.items.randomweapons.DiamondHandbag;
import victinix.jarm.items.randomweapons.EmeraldSword;
import victinix.jarm.items.randomweapons.RandomGun;
import victinix.jarm.libs.Configurations;

public class ModItems {

    public static Item.ToolMaterial RANDOMEMERALD;

    public static Item cookedSquid;
    public static Item coolSquid;
    public static Item hotdog;

    public static Item ditto;

    public static Item diamondHandbag;
    public static Item emeraldSword;
    public static Item randomGun;

    public static void init() {

        RANDOMEMERALD = EnumHelper.addToolMaterial("RANDOMEMERALD", Configurations.emeraldSwordHarvestLevel, Configurations.emeraldSwordDurability, Configurations.emeraldSwordMiningSpeed, Configurations.emeraldSwordDamage, Configurations.emeraldSwordEnchantability);

        cookedSquid = new CookedSquid(Configurations.cookedSquidHeal, Configurations.cookedSquidSaturation, true);
        coolSquid = new CoolSquid(Configurations.coolSquidHeal, Configurations.coolSquidSaturation, true);
        hotdog = new Hotdog(Configurations.hotdogHeal, Configurations.hotdogSaturation, true);

        ditto = new Ditto();

        diamondHandbag = new DiamondHandbag(Item.ToolMaterial.EMERALD);
        emeraldSword = new EmeraldSword(ModItems.RANDOMEMERALD);
        randomGun = new RandomGun();
    }
}
