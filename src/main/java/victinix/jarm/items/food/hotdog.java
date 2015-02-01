package victinix.jarm.items.food;

import net.minecraft.item.ItemFood;
import victinix.jarm.libs.Data;
import victinix.jarm.libs.Tabs;

/**
 * Created by VictiniX888 on 01-Feb-2015.
 * It's distributed as part of the JARM Mod.
 * Get the Source Code in github:
 * https://github.com/VictiniX888/JARM
 *
 * JARM is Open Source and distributed under the
 * Creative Commons Attribution-NonCommercial-ShareAlike
 * 4.0 International Public License
 */

public class hotdog extends ItemFood {

    private String name = "hotdog";

    public hotdog(int heal, float saturation, boolean wolfMeat) {

        super(heal, saturation, wolfMeat);
        setUnlocalizedName(Data.MODID + ":" + name);
        setCreativeTab(Tabs.tabRandom);
    }
}
