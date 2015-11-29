package victinix.jarm.items.magic;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemTool;
import net.minecraft.world.World;
import victinix.jarm.items.ModItems;
import victinix.jarm.lib.Configurations;
import victinix.jarm.lib.Data;
import victinix.jarm.lib.Tabs;

public class ItemCrushingWand extends ItemTool {

    private String name = "crushingWand";

    public ItemCrushingWand(ToolMaterial toolMaterial) {

        super(1f, toolMaterial, ModItems.canCrush);
        setUnlocalizedName(Data.MODID + ":" + name);
        setTextureName(Data.MODID + ":" + name);
        setCreativeTab(Tabs.tabRandom);
        if(Configurations.crushingWandRegister) {
            GameRegistry.registerItem(this, name);
        }
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
