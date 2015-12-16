package victinix.jarm.potion;

import net.minecraft.potion.Potion;
import victinix.jarm.lib.Data;

public class PotionFlying extends Potion {

    String name = "potionFlying";

    public PotionFlying(int id, boolean b, int j) {

        super(id, b, j);
        setIconIndex(0, 0);
        setPotionName(Data.MODID + ":" + name);
    }

    @Override
    public Potion setIconIndex(int i, int j) {

        super.setIconIndex(i, j);
        return this;
    }
}
