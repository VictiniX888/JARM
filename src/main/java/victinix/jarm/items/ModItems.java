package victinix.jarm.items;

import net.minecraft.item.Item;
import net.minecraftforge.common.util.EnumHelper;
import victinix.jarm.items.food.CoolSquid;
import victinix.jarm.items.food.Hotdog;
import victinix.jarm.items.randomweapons.DiamondHandbag;
import victinix.jarm.items.randomweapons.EmeraldSword;
import victinix.jarm.items.randomweapons.RandomGun;
import victinix.jarm.libs.Configurations;

public class ModItems {

    public static Item.ToolMaterial RANDOMEMERALD;

    public static Item coolSquid;
    public static Item hotdog;

    public static Item diamondHandbag;
    public static Item emeraldSword;
    public static Item randomGun;

    public static void init() {

        RANDOMEMERALD = EnumHelper.addToolMaterial("RANDOMEMERALD", Configurations.emeraldSwordHarvestLevel, Configurations.emeraldSwordDurability, (float) Configurations.emeraldSwordMiningSpeed, (float) Configurations.emeraldSwordDamage, Configurations.emeraldSwordEnchantability);

        coolSquid = new CoolSquid(3, 0.1f, true);
        hotdog = new Hotdog(Configurations.hotdogHeal, (float) Configurations.hotdogSaturation, true);

        diamondHandbag = new DiamondHandbag(Item.ToolMaterial.EMERALD);
        emeraldSword = new EmeraldSword(ModItems.RANDOMEMERALD);
        randomGun = new RandomGun();
    }
}
