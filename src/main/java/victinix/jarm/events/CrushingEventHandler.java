package victinix.jarm.events;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.oredict.OreDictionary;
import sun.reflect.generics.tree.Wildcard;
import victinix.jarm.items.ModItems;

public class CrushingEventHandler {

    @SubscribeEvent
    public void crushingEvent(BlockEvent.BreakEvent event) {

        if(event.getPlayer().getHeldItem() != null && event.getPlayer().getHeldItem().getItem() == ModItems.crushingWand) {

            if(event.block == Blocks.cobblestone) {

                event.world.spawnEntityInWorld(new EntityItem(event.world, event.x, event.y, event.z, new ItemStack(Item.getItemFromBlock(Blocks.sand))));
            }
        }
    }
}
