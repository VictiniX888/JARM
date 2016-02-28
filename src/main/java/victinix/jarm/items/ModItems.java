package victinix.jarm.items;

import net.minecraft.item.Item;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import victinix.jarm.items.weapons.ItemRandomGun;

public class ModItems {

    public static ItemRandomGun random_gun;

    public static void init() {

        random_gun = new ItemRandomGun();
    }

    @SideOnly(Side.CLIENT)
    public static void initModel() {

        random_gun.initModel();
    }
}
