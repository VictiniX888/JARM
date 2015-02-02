package victinix.jarm.items;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.Item;
import net.minecraftforge.common.util.EnumHelper;
import victinix.jarm.libs.Configurations;
import net.minecraft.item.Item.ToolMaterial;

/**
 * Created by VictiniX888 on 31-Jan-2015.
 * It's distributed as part of the JARM Mod.
 * Get the Source Code in github:
 * https://github.com/VictiniX888/JARM
 *
 * JARM is Open Source and distributed under the
 * Creative Commons Attribution-NonCommercial-ShareAlike
 * 4.0 International Public License
 */

public class modItems {

    public static Item hotdog;

    public static Item emeraldSword;
    public static Item randomGun;

    public static Item.ToolMaterial RANDOMEMERALD;

    public static void init() {

        RANDOMEMERALD = EnumHelper.addToolMaterial("RANDOMEMERALD", 4, 3000, 10F, 4.0F, 18);

        hotdog = new victinix.jarm.items.food.hotdog(Configurations.hotdogHeal, (float) Configurations.hotdogSaturation, Configurations.hotdogWolfMeat);
        if(Configurations.hotdogRegister)
            GameRegistry.registerItem(hotdog, "hotdog");

        emeraldSword = new victinix.jarm.items.randomWeapons.emeraldSword(modItems.RANDOMEMERALD);
        if(Configurations.emeraldSwordRegister)
            GameRegistry.registerItem(emeraldSword, "emeraldSword");
        randomGun = new victinix.jarm.items.randomWeapons.randomGun();
        if(Configurations.randomGunRegister)
            GameRegistry.registerItem(randomGun, "randomGun");
    }
}
