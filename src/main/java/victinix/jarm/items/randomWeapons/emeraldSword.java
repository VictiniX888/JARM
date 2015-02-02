package victinix.jarm.items.randomWeapons;

import net.minecraft.item.ItemSword;
import victinix.jarm.libs.Data;
import victinix.jarm.libs.Tabs;

/**
 * Created by VictiniX888 on 02-Feb-2015.
 * It's distributed as part of the JARM Mod.
 * Get the Source Code in github:
 * https://github.com/VictiniX888/JARM
 *
 * JARM is Open Source and distributed under the
 * Creative Commons Attribution-NonCommercial-ShareAlike
 * 4.0 International Public License
 */

public class emeraldSword extends ItemSword {

    private String name = "emeraldSword";

    public emeraldSword(ToolMaterial toolMaterial) {

        super(toolMaterial);
        setUnlocalizedName(Data.MODID + ":" + name);
        setTextureName(Data.MODID + ":" + name);
        setCreativeTab(Tabs.tabRandom);
    }
}
