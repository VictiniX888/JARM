package victinix.jarm.lib;

import net.minecraftforge.common.config.Configuration;

public class Configurations {

    public static Configuration config;
    public static boolean configExists;

    public static boolean cookedSquidRegistry;
    public static boolean coolSquidRegistry;
    public static boolean hotdogRegistry;
    public static boolean dittoRegistry;
    public static boolean superBurgerRegistry;
    public static boolean xProducerRegistry;
    public static boolean diamondHandbagRegistry;
    public static boolean emeraldSwordRegistry;
    public static boolean randomGunRegistry;

    public static String[] dittoBlacklist;
    public static boolean xProducerDamage;

    public static boolean diamondHandbagRecoil;
    public static int diamondHandbagRecoilChance;
    public static String randomGunText;

    public static boolean refreshConfig() {

        String category;

        category = "registry";
        cookedSquidRegistry = config.get(category, "cookedSquidRegistry", true).getBoolean(true);
        coolSquidRegistry = config.get(category, "coolSquidRegistry", true).getBoolean(true);
        hotdogRegistry = config.get(category, "hotdogRegistry", true).getBoolean(true);
        dittoRegistry = config.get(category, "dittoRegistry", true).getBoolean(true);
        superBurgerRegistry = config.get(category, "superBurgerRegistry", true).getBoolean(true);
        xProducerRegistry = config.get(category, "xProducerRegistry", true).getBoolean(true);
        diamondHandbagRegistry = config.get(category, "diamondHandbagRegistry", true).getBoolean(true);
        emeraldSwordRegistry = config.get(category, "emeraldSwordRegistry", true).getBoolean(true);
        randomGunRegistry = config.get(category, "randomGunRegistry", true).getBoolean(true);

        category = "food";

        category = "magic";
        dittoBlacklist = config.get(category, "dittoBlocklist", new String[] {
                "Chest"
        }, "Things the Ditto cannot dupe").getStringList();
        xProducerDamage = config.get(category, "xProducerDamage", true, "Whether the XProducer damages the player when creating XP").getBoolean(true);

        category = "weapons";
        diamondHandbagRecoil = config.get(category, "diamondHandbagRecoil", true, "Whether the Diamond Handbag gives recoil").getBoolean(true);
        diamondHandbagRecoilChance = config.get(category, "diamondHandRecoilChance", 50, "Chance of Diamond Handbag recoil", 1, 100).getInt();
        randomGunText = config.get(category, "randomGunText", "Hello world", "Text that appears when Random Gun is used.").getString();

        if(config.hasChanged()) {
            config.save();
        }

        return true;
    }
}
