package victinix.jarm.items;

import cpw.mods.fml.common.registry.GameData;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.common.util.EnumHelper;
import victinix.jarm.items.magic.ItemCrushingWand;
import victinix.jarm.items.food.ItemCookedSquid;
import victinix.jarm.items.food.ItemCoolSquid;
import victinix.jarm.items.food.ItemHotdog;
import victinix.jarm.items.magic.ItemDitto;
import victinix.jarm.items.magic.ItemSuperBurger;
import victinix.jarm.items.magic.ItemXProducer;
import victinix.jarm.items.materials.ItemDustBase;
import victinix.jarm.items.weapons.ItemDiamondHandbag;
import victinix.jarm.items.weapons.ItemEmeraldSword;
import victinix.jarm.items.weapons.ItemRandomGun;
import victinix.jarm.lib.Configurations;

import java.util.HashSet;

public class ModItems {

    public static Item.ToolMaterial RANDOMEMERALD;
    public static Item.ToolMaterial CRUSHER;

    public static Item cookedSquid;
    public static Item coolSquid;
    public static Item hotdog;

    public static HashSet<Block> canCrush = new HashSet<Block>();
    public static Item crushingWand;
    public static Item ditto;
    public static Item superBurger;
    public static Item xProducer;

    public static Item dust;

    public static Item diamondHandbag;
    public static Item emeraldSword;
    public static Item randomGun;

    public static void init() {

        RANDOMEMERALD = EnumHelper.addToolMaterial("RANDOMEMERALD", 4, Configurations.emeraldSwordDurability, 10f, Configurations.emeraldSwordDamage, 18);
        CRUSHER = EnumHelper.addToolMaterial("CRUSHER", 4, 2000, 2000f, 0, 0);

        cookedSquid = new ItemCookedSquid(Configurations.cookedSquidHeal, Configurations.cookedSquidSaturation, true);
        coolSquid = new ItemCoolSquid(Configurations.coolSquidHeal, Configurations.coolSquidSaturation, true);
        hotdog = new ItemHotdog(Configurations.hotdogHeal, Configurations.hotdogSaturation, true);

        for (int i = 0; i < Configurations.canCrush.length; i++) {
            canCrush.add(GameData.getBlockRegistry().getObject(Configurations.canCrush[i]));
        }
        crushingWand = new ItemCrushingWand(ModItems.CRUSHER);
        ditto = new ItemDitto();
        superBurger = new ItemSuperBurger();
        xProducer = new ItemXProducer();

        dust = new ItemDustBase();

        diamondHandbag = new ItemDiamondHandbag(Item.ToolMaterial.EMERALD);
        emeraldSword = new ItemEmeraldSword(ModItems.RANDOMEMERALD);
        randomGun = new ItemRandomGun();
    }
}
