package victinix.jarm.items;

import net.minecraft.item.Item;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import victinix.jarm.items.weapons.ItemDiamondHandbag;
import victinix.jarm.items.weapons.ItemEmeraldSword;
import victinix.jarm.items.weapons.ItemRandomGun;

public class ModItems {

    public static Item.ToolMaterial RANDOMEMERALD;

    public static ItemDiamondHandbag diamond_handbag;
    public static ItemEmeraldSword emerald_sword;
    public static ItemRandomGun random_gun;

    public static void initToolMaterials() {

        RANDOMEMERALD = EnumHelper.addToolMaterial("RANDOMEMERALD", 4, 3000, 10f, 4f, 18);
    }

    public static void initItems() {

        diamond_handbag = new ItemDiamondHandbag(Item.ToolMaterial.EMERALD);
        emerald_sword = new ItemEmeraldSword(RANDOMEMERALD);
        random_gun = new ItemRandomGun();
    }

    @SideOnly(Side.CLIENT)
    public static void initModels() {

        diamond_handbag.initModel();
        emerald_sword.initModel();
        random_gun.initModel();
    }
}
