package victinix.jarm.events;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.registry.GameData;
import net.minecraft.block.Block;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.world.BlockEvent;
import victinix.jarm.items.ModItems;
import victinix.jarm.libs.Configurations;

public class EventCrushingDrops {

    @SubscribeEvent
    public void crushingEvent(BlockEvent.BreakEvent event) {

        if(event.getPlayer().getHeldItem() != null && event.getPlayer().getHeldItem().getItem() == ModItems.crushingWand) {

            if(event.block == Blocks.cobblestone) {
                event.world.spawnEntityInWorld(new EntityItem(event.world, event.x, event.y, event.z, new ItemStack(Item.getItemFromBlock(Blocks.sand))));
            }
            if(event.block == Blocks.redstone_ore) {
                event.world.spawnEntityInWorld(new EntityItem(event.world, event.x, event.y, event.z, new ItemStack(Items.redstone, 8)));
            }
            if(event.block == Blocks.lit_redstone_ore) {
                event.world.spawnEntityInWorld(new EntityItem(event.world, event.x, event.y, event.z, new ItemStack(Items.redstone, 8)));
            }
            if(Configurations.dustRegister) {
                if (event.block == Blocks.iron_ore) {
                    event.world.spawnEntityInWorld(new EntityItem(event.world, event.x, event.y, event.z, new ItemStack(ModItems.dust, Configurations.crushDustAmount, 0)));
                }
                if (event.block == Blocks.gold_ore) {
                    event.world.spawnEntityInWorld(new EntityItem(event.world, event.x, event.y, event.z, new ItemStack(ModItems.dust, Configurations.crushDustAmount, 1)));
                }
                if (event.block == Blocks.coal_ore) {
                    event.world.spawnEntityInWorld(new EntityItem(event.world, event.x, event.y, event.z, new ItemStack(ModItems.dust, Configurations.crushDustAmount, 2)));
                }
                if (event.block == Blocks.diamond_ore) {
                    event.world.spawnEntityInWorld(new EntityItem(event.world, event.x, event.y, event.z, new ItemStack(ModItems.dust, Configurations.crushDustAmount, 3)));
                }
                if (event.block == Blocks.emerald_ore) {
                    event.world.spawnEntityInWorld(new EntityItem(event.world, event.x, event.y, event.z, new ItemStack(ModItems.dust, Configurations.crushDustAmount, 4)));
                }
                if (event.block == Blocks.lapis_ore) {
                    event.world.spawnEntityInWorld(new EntityItem(event.world, event.x, event.y, event.z, new ItemStack(ModItems.dust, Configurations.crushDustAmount, 5)));
                }
                for (int i = 0; i < Configurations.canCrush.length; i++) {
                    if ((event.block != Blocks.cobblestone && event.block != Blocks.redstone_ore && event.block != Blocks.lit_redstone_ore && event.block != Blocks.iron_ore && event.block != Blocks.gold_ore && event.block != Blocks.coal_ore && event.block != Blocks.diamond_ore && event.block != Blocks.emerald_ore && event.block != Blocks.lapis_ore) && event.block == GameData.getBlockRegistry().getObject(Configurations.canCrush[i])) {
                        event.world.spawnEntityInWorld(new EntityItem(event.world, event.x, event.y, event.z, new ItemStack(ModItems.dust, Configurations.crushDustAmount, 6)));
                    }
                }
            }
        }
    }
}
