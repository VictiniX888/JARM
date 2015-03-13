package victinix.jarm.libs;

import net.minecraftforge.common.config.Configuration;

public class Configurations {

    public static Configuration config;
    public static boolean configExists;

    public static boolean coolSquidRegister;
    public static boolean hotdogRegister;
    public static boolean diamondHandbagRegister;
    public static boolean emeraldSwordRegister;
    public static boolean randomGunRegister;

    public static boolean diamondHandbagRecoil;
    public static float diamondHandbagRecoilChance;
    public static int emeraldSwordHarvestLevel;
    public static int emeraldSwordDurability;
    public static double emeraldSwordMiningSpeed;
    public static double emeraldSwordDamage;
    public static int emeraldSwordEnchantability;
    public static boolean emeraldSwordFire;
    public static String randomGunText;
    public static boolean randomGunTextureRandom;
    public static String randomGunTextureFixed;

    public static int hotdogCraftingAmount;
    public static int hotdogHeal;
    public static double hotdogSaturation;

    public static boolean refreshConfig() {

        String category;

        //registry
        category = "registry";

        coolSquidRegister = config.get(category, "coolSquidRegister", true).getBoolean(true);
        hotdogRegister = config.get(category, "hotdogRegister", true).getBoolean(true);
        diamondHandbagRegister = config.get(category, "diamondHandbagRegister", true).getBoolean(true);
        emeraldSwordRegister = config.get(category, "emeraldSwordRegister", true).getBoolean(true);
        randomGunRegister = config.get(category, "randomGunRegister", true).getBoolean(true);

        //randomweapons
        category = "randomweapons";

        diamondHandbagRecoil = config.get(category, "diamondHandbagRecoil", true, "Whether the Diamond Handbag gives recoil").getBoolean(true);
        diamondHandbagRecoilChance = config.getFloat("diamondHandbagRecoilChance", category, 0.10f, 0.01f, 1.00f, "Chance of Diamond Handbag recoil. 1.0 = 100%");
        emeraldSwordHarvestLevel = config.get(category, "emeraldSwordHarvestLevel", 4, "Harvest level of Emerald Sword").getInt();
        emeraldSwordDurability = config.get(category, "emraldSwordDurability", 3000, "Durability of Emerald Sword").getInt();
        emeraldSwordMiningSpeed = config.get(category, "emeraldSwordMiningSpeed", 10, "Mining speed of Emerald Sword.").getDouble();
        emeraldSwordDamage = config.get(category, "emeraldSwordDamage", 4, "Damage of Emerald Sword.").getDouble();
        emeraldSwordEnchantability = config.get(category, "emeraldSwordEnchantability", 18, "Enchantability of Emerald Sword").getInt();
        emeraldSwordFire = config.get(category, "emeraldSwordFire", true, "Whether Emerald Sword has Fire Aspect.").getBoolean(true);
        randomGunText = config.get(category, "randomGunText", "Malware has been installed on your PC", "Text that appears when Random Gun is used.").getString();
        randomGunTextureRandom = config.get(category, "randomGunTextureRandom", true, "Whether the Random Gun texture is randomized").getBoolean(true);
        randomGunTextureFixed = config.get(category, "randomGunTextureFixed", "pistol", "Texture for Random Gun. Options = ak, msbs, pistol, sniper & submachineGun. Only applies if randomGunTextureRandom is set to false").getString();

        //food
        category = "food";

        hotdogCraftingAmount = config.get(category, "hotdogCraftingAmount", 2, "Amount of Hotdogs crafted per recipe").getInt();
        hotdogHeal = config.get(category, "hotdogHeal", 6, "Amount of hunger Hotdog heals").getInt();
        hotdogSaturation = config.get(category, "hotdogSaturation", 0.4, "Amount of saturation Hotdog gives.").getDouble();

        if(config.hasChanged()) {
            config.save();
        }

        return true;
    }
}
