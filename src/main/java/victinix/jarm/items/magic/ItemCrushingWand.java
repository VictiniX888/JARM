package victinix.jarm.items.magic;

import com.google.common.collect.Sets;
import cpw.mods.fml.common.registry.GameData;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemTool;
import net.minecraft.world.World;
import victinix.jarm.libs.Configurations;
import victinix.jarm.libs.Data;
import victinix.jarm.libs.Tabs;

import java.util.*;

public class ItemCrushingWand extends ItemTool {

    private String name = "crushingWand";

    private static final Set canCrush = Sets.newHashSet(new Block[] {
            Blocks.cobblestone, Blocks.iron_ore, Blocks.gold_ore, Blocks.coal_ore, Blocks.diamond_ore, Blocks.emerald_ore, Blocks.lapis_ore, Blocks.redstone_ore, Blocks.lit_redstone_ore
    });

    public ItemCrushingWand(ToolMaterial toolMaterial) {

        super(1f, toolMaterial, canCrush);
        setUnlocalizedName(Data.MODID + ":" + name);
        setTextureName(Data.MODID + ":" + name);
        setCreativeTab(Tabs.tabRandom);
        GameRegistry.registerItem(this, name);
    }

    @Override
    public boolean func_150897_b(Block p_150897_1_) {
        if (super.func_150897_b(p_150897_1_)) {
            return true;
        }
        else {
            return false;
        }
    }

    @Override
    public boolean onBlockDestroyed(ItemStack p_150894_1_, World p_150894_2_, Block p_150894_3_, int p_150894_4_, int p_150894_5_, int p_150894_6_, EntityLivingBase p_150894_7_) {

        return true;
    }
}
