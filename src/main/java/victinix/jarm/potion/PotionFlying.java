package victinix.jarm.potion;

import net.minecraft.potion.Potion;
import victinix.jarm.lib.Data;

public class PotionFlying extends Potion {

    String name = "Flying";

    public PotionFlying(int id, boolean b, int j) {

        super(id, b, j);
        setIconIndex(0, 0);
        setPotionName(name);
    }

    @Override
    public Potion setIconIndex(int i, int j) {

        super.setIconIndex(i, j);
        return this;
    }
}
