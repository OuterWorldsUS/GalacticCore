package us.outerworlds.galacticcore.management;

import us.outerworlds.galacticcore.enchantments.Enchant;

public class EnchantmentManagement {

    public static int[] getApplicableLevels(Enchant enchant) {
        int[] levels = new int[] { 0 };

        switch (enchant) {
            case SIMPLE_1:
            case UNIQUE_2:
            case ELITE_1:
            case ULTIMATE_1:
            case LEGENDARY_1:
                levels = new int[]{ 1, 2 };
                break;
            case SIMPLE_2:
            case ULTIMATE_2:
                levels = new int[] { 1 };
                break;
            case UNIQUE_1:
            case ELITE_2:
            case LEGENDARY_2:
                levels = new int[]{ 1, 2, 3 };
                break;
        }

        return levels;
    }
}
