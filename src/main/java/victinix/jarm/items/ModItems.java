package victinix.jarm.items;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import victinix.jarm.items.food.ItemCookedSquid;
import victinix.jarm.items.food.ItemCoolSquid;
import victinix.jarm.items.food.ItemHotdog;
import victinix.jarm.items.magic.ItemCrushingWand;
import victinix.jarm.items.magic.ItemDitto;
import victinix.jarm.items.magic.ItemSuperBurger;
import victinix.jarm.items.magic.ItemXProducer;
import victinix.jarm.items.weapons.ItemDiamondHandbag;
import victinix.jarm.items.weapons.ItemEmeraldSword;
import victinix.jarm.items.weapons.ItemRandomGun;
import victinix.jarm.lib.Configurations;

import java.util.HashSet;
import java.util.Set;

public class ModItems {

    public static Set<Block> canCrush = new HashSet<Block>();

    public static Item.ToolMaterial RANDOMEMERALD;
    public static Item.ToolMaterial CRUSHER;

    public static ItemCookedSquid cooked_squid;
    public static ItemCoolSquid cool_squid;
    public static ItemHotdog hotdog;

    public static ItemCrushingWand crushing_wand;
    public static ItemDitto ditto;
    public static ItemSuperBurger super_burger;
    public static ItemXProducer xproducer;

    public static ItemDiamondHandbag diamond_handbag;
    public static ItemEmeraldSword emerald_sword;
    public static ItemRandomGun random_gun;

    public static void initToolMaterials() {

        RANDOMEMERALD = EnumHelper.addToolMaterial("RANDOMEMERALD", 4, 3000, 10f, 4f, 18);
        CRUSHER = EnumHelper.addToolMaterial("CRUSHER", 4, 2000, 2000f, 0, 0);
    }

    public static void initItems() {

        for (int i = 0; i < Configurations.canCrush.length; i++) {
            canCrush.add(GameRegistry.findBlock(Configurations.canCrush[i].split(":")[0], Configurations.canCrush[i].split(":")[1]));
        }

        cooked_squid = new ItemCookedSquid(1, 0.04f, true);
        cool_squid = new ItemCoolSquid(6, 0.2f, true);
        hotdog = new ItemHotdog(6, 0.4f, true);

        crushing_wand = new ItemCrushingWand(1f, CRUSHER, canCrush);
        ditto = new ItemDitto();
        super_burger = new ItemSuperBurger();
        xproducer = new ItemXProducer();

        diamond_handbag = new ItemDiamondHandbag(Item.ToolMaterial.EMERALD);
        emerald_sword = new ItemEmeraldSword(RANDOMEMERALD);
        random_gun = new ItemRandomGun();
    }

    @SideOnly(Side.CLIENT)
    public static void initModels() {

        cooked_squid.initModel();
        cool_squid.initModel();
        hotdog.initModel();

        crushing_wand.initModel();
        ditto.initModel();
        super_burger.initModel();
        xproducer.initModel();

        diamond_handbag.initModel();
        emerald_sword.initModel();
        random_gun.initModel();
    }
}
