package victinix.jarm.events;

import net.minecraft.block.Block;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameData;
import victinix.jarm.items.ModItems;
import victinix.jarm.lib.Configurations;

public class EventWandDrops {

    @SubscribeEvent
    public void eventWandDrops(BlockEvent.BreakEvent event) {

        Block[] canCrush = ModItems.canCrush.toArray(new Block[ModItems.canCrush.size()]);

        if(event.getPlayer().getHeldItem() != null && event.getPlayer().getHeldItem().getItem() == ModItems.crushing_wand) {

            if(event.world.getBlockState(event.pos).getBlock() == Blocks.cobblestone) {
                event.world.spawnEntityInWorld(new EntityItem(event.world, event.pos.getX(), event.pos.getY(), event.pos.getZ(), new ItemStack(Item.getItemFromBlock(Blocks.sand))));
            }
            if(event.world.getBlockState(event.pos).getBlock() == Blocks.redstone_ore) {
                event.world.spawnEntityInWorld(new EntityItem(event.world, event.pos.getX(), event.pos.getY(), event.pos.getZ(), new ItemStack(Items.redstone, 8)));
            }
            if(event.world.getBlockState(event.pos).getBlock() == Blocks.lit_redstone_ore) {
                event.world.spawnEntityInWorld(new EntityItem(event.world, event.pos.getX(), event.pos.getY(), event.pos.getZ(), new ItemStack(Items.redstone, 8)));
            }
            if(Configurations.dustRegistry) {
                if (event.world.getBlockState(event.pos).getBlock() == Blocks.iron_ore) {
                    event.world.spawnEntityInWorld(new EntityItem(event.world, event.pos.getX(), event.pos.getY(), event.pos.getZ(), new ItemStack(ModItems.dust, 12, 0)));
                }
                if (event.world.getBlockState(event.pos).getBlock() == Blocks.gold_ore) {
                    event.world.spawnEntityInWorld(new EntityItem(event.world, event.pos.getX(), event.pos.getY(), event.pos.getZ(), new ItemStack(ModItems.dust, 12, 1)));
                }
                if (event.world.getBlockState(event.pos).getBlock() == Blocks.coal_ore) {
                    event.world.spawnEntityInWorld(new EntityItem(event.world, event.pos.getX(), event.pos.getY(), event.pos.getZ(), new ItemStack(ModItems.dust, 12, 2)));
                }
                if (event.world.getBlockState(event.pos).getBlock() == Blocks.diamond_ore) {
                    event.world.spawnEntityInWorld(new EntityItem(event.world, event.pos.getX(), event.pos.getY(), event.pos.getZ(), new ItemStack(ModItems.dust, 12, 3)));
                }
                if (event.world.getBlockState(event.pos).getBlock() == Blocks.emerald_ore) {
                    event.world.spawnEntityInWorld(new EntityItem(event.world, event.pos.getX(), event.pos.getY(), event.pos.getZ(), new ItemStack(ModItems.dust, 12, 4)));
                }
                if (event.world.getBlockState(event.pos).getBlock() == Blocks.lapis_ore) {
                    event.world.spawnEntityInWorld(new EntityItem(event.world, event.pos.getX(), event.pos.getY(), event.pos.getZ(), new ItemStack(ModItems.dust, 12, 5)));
                }
                for (int i = 0; i < Configurations.canCrush.length; i++) {
                    if ((event.world.getBlockState(event.pos).getBlock() != Blocks.cobblestone && event.world.getBlockState(event.pos).getBlock() != Blocks.redstone_ore && event.world.getBlockState(event.pos).getBlock() != Blocks.lit_redstone_ore && event.world.getBlockState(event.pos).getBlock() != Blocks.iron_ore && event.world.getBlockState(event.pos).getBlock() != Blocks.gold_ore && event.world.getBlockState(event.pos).getBlock() != Blocks.coal_ore && event.world.getBlockState(event.pos).getBlock() != Blocks.diamond_ore && event.world.getBlockState(event.pos).getBlock() != Blocks.emerald_ore && event.world.getBlockState(event.pos).getBlock() != Blocks.lapis_ore) && event.world.getBlockState(event.pos).getBlock() == canCrush[i]) {
                        event.world.spawnEntityInWorld(new EntityItem(event.world, event.pos.getX(), event.pos.getY(), event.pos.getZ(), new ItemStack(ModItems.dust, 12, 6)));
                    }
                }
            }
        }
    }
}
