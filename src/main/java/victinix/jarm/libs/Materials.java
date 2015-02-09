package victinix.jarm.libs;

import net.minecraft.item.Item;
import net.minecraftforge.common.util.EnumHelper;

public class Materials {

    public static Item.ToolMaterial RANDOMEMERALD;

    public static void RANDOMEMERALD() {

        EnumHelper.addToolMaterial("RANDOMEMERALD", Configurations.emeraldSwordHarvestLevel, Configurations.emeraldSwordDurability, (float) Configurations.emeraldSwordMiningSpeed, (float) Configurations.emeraldSwordDamage, Configurations.emeraldSwordEnchantability);
    }
}
