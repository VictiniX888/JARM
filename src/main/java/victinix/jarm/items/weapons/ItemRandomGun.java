package victinix.jarm.items.weapons;

import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import victinix.jarm.lib.Data;

import java.util.Random;

public class ItemRandomGun extends Item {

    String[] textures = {"ak", "msbs", "pistol", "sniper", "submachine_gun"};
    Random random = new Random();
    int r = random.nextInt(textures.length);

    public ItemRandomGun() {

        super();
        setRegistryName(Data.MODID + ":" + "random_gun");
        setUnlocalizedName(Data.MODID + ":" + "random_gun");
        GameRegistry.registerItem(this);
        System.out.println(getRegistryName());
    }

    @SideOnly(Side.CLIENT)
    public void initModel() {

        ModelLoader.setCustomModelResourceLocation(this, 0, new ModelResourceLocation(getRegistryName() + "_" + textures[r], "inventory"));
    }
}
