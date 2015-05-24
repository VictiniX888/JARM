package victinix.jarm.items.magic;

import com.google.common.collect.Sets;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemTool;
import victinix.jarm.libs.Data;
import victinix.jarm.libs.Tabs;

import java.util.Set;

public class CrushingWand extends ItemTool {

    private String name = "crushingWand";

    private static final Set canCrush = Sets.newHashSet(new Block[] {
            Blocks.cobblestone
    });

    public CrushingWand(ToolMaterial toolMaterial) {

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
}
