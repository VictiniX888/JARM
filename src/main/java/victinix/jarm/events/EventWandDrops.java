package victinix.jarm.events;

import net.minecraft.block.Block;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumHand;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import victinix.jarm.items.ModItems;
import victinix.jarm.lib.Configurations;

public class EventWandDrops {

    @SubscribeEvent
    public void eventWandDrops(BlockEvent.BreakEvent event) {

        Block[] canCrush = ModItems.canCrush.toArray(new Block[ModItems.canCrush.size()]);

        if(event.getPlayer().getHeldItem(event.getPlayer().getActiveHand()) != null && event.getPlayer().getHeldItem(event.getPlayer().getActiveHand()).getItem() == ModItems.crushing_wand) {

            if(event.getWorld().getBlockState(event.getPos()).getBlock() == Blocks.cobblestone) {
                event.getWorld().spawnEntityInWorld(new EntityItem(event.getWorld(), event.getPos().getX(), event.getPos().getY(), event.getPos().getZ(), new ItemStack(Item.getItemFromBlock(Blocks.sand))));
            }
            if(event.getWorld().getBlockState(event.getPos()).getBlock() == Blocks.redstone_ore) {
                event.getWorld().spawnEntityInWorld(new EntityItem(event.getWorld(), event.getPos().getX(), event.getPos().getY(), event.getPos().getZ(), new ItemStack(Items.redstone, 8)));
            }
            if(event.getWorld().getBlockState(event.getPos()).getBlock() == Blocks.lit_redstone_ore) {
                event.getWorld().spawnEntityInWorld(new EntityItem(event.getWorld(), event.getPos().getX(), event.getPos().getY(), event.getPos().getZ(), new ItemStack(Items.redstone, 8)));
            }
            if(Configurations.dustRegistry) {
                if (event.getWorld().getBlockState(event.getPos()).getBlock() == Blocks.iron_ore) {
                    event.getWorld().spawnEntityInWorld(new EntityItem(event.getWorld(), event.getPos().getX(), event.getPos().getY(), event.getPos().getZ(), new ItemStack(ModItems.dust, 12, 0)));
                }
                if (event.getWorld().getBlockState(event.getPos()).getBlock() == Blocks.gold_ore) {
                    event.getWorld().spawnEntityInWorld(new EntityItem(event.getWorld(), event.getPos().getX(), event.getPos().getY(), event.getPos().getZ(), new ItemStack(ModItems.dust, 12, 1)));
                }
                if (event.getWorld().getBlockState(event.getPos()).getBlock() == Blocks.coal_ore) {
                    event.getWorld().spawnEntityInWorld(new EntityItem(event.getWorld(), event.getPos().getX(), event.getPos().getY(), event.getPos().getZ(), new ItemStack(ModItems.dust, 12, 2)));
                }
                if (event.getWorld().getBlockState(event.getPos()).getBlock() == Blocks.diamond_ore) {
                    event.getWorld().spawnEntityInWorld(new EntityItem(event.getWorld(), event.getPos().getX(), event.getPos().getY(), event.getPos().getZ(), new ItemStack(ModItems.dust, 12, 3)));
                }
                if (event.getWorld().getBlockState(event.getPos()).getBlock() == Blocks.emerald_ore) {
                    event.getWorld().spawnEntityInWorld(new EntityItem(event.getWorld(), event.getPos().getX(), event.getPos().getY(), event.getPos().getZ(), new ItemStack(ModItems.dust, 12, 4)));
                }
                if (event.getWorld().getBlockState(event.getPos()).getBlock() == Blocks.lapis_ore) {
                    event.getWorld().spawnEntityInWorld(new EntityItem(event.getWorld(), event.getPos().getX(), event.getPos().getY(), event.getPos().getZ(), new ItemStack(ModItems.dust, 12, 5)));
                }
                for (int i = 0; i < Configurations.canCrush.length; i++) {
                    if ((event.getWorld().getBlockState(event.getPos()).getBlock() != Blocks.cobblestone && event.getWorld().getBlockState(event.getPos()).getBlock() != Blocks.redstone_ore && event.getWorld().getBlockState(event.getPos()).getBlock() != Blocks.lit_redstone_ore && event.getWorld().getBlockState(event.getPos()).getBlock() != Blocks.iron_ore && event.getWorld().getBlockState(event.getPos()).getBlock() != Blocks.gold_ore && event.getWorld().getBlockState(event.getPos()).getBlock() != Blocks.coal_ore && event.getWorld().getBlockState(event.getPos()).getBlock() != Blocks.diamond_ore && event.getWorld().getBlockState(event.getPos()).getBlock() != Blocks.emerald_ore && event.getWorld().getBlockState(event.getPos()).getBlock() != Blocks.lapis_ore) && event.getWorld().getBlockState(event.getPos()).getBlock() == canCrush[i]) {
                        event.getWorld().spawnEntityInWorld(new EntityItem(event.getWorld(), event.getPos().getX(), event.getPos().getY(), event.getPos().getZ(), new ItemStack(ModItems.dust, 12, 6)));
                    }
                }
            }
        }
    }
}
