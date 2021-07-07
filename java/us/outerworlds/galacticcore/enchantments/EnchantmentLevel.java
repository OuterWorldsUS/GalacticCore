package us.outerworlds.galacticcore.enchantments;

import java.util.HashMap;
import java.util.Map;

public enum EnchantmentLevel {

    SIMPLE,
    UNIQUE,
    ELITE,
    ULTIMATE,
    LEGENDARY;

    public static EnchantmentLevel getEnchantmentLevel(Enchant enchant) {
        EnchantmentLevel level = SIMPLE;

        switch (enchant) {
            case SIMPLE_1:
            case SIMPLE_2:
                level = SIMPLE;
                break;
            case UNIQUE_1:
            case UNIQUE_2:
                level = UNIQUE;
                break;
            case ELITE_1:
            case ELITE_2:
                level = ELITE;
                break;
            case ULTIMATE_1:
            case ULTIMATE_2:
                level = ULTIMATE;
                break;
            case LEGENDARY_1:
            case LEGENDARY_2:
                level = LEGENDARY;
                break;
        }

        return level;
    }

    public static Map<Enchant, EnchantmentLevel> getEnchants() {
        Map<Enchant, EnchantmentLevel> enchants = new HashMap<>();

        for (Enchant value : Enchant.values())
            enchants.put(value, EnchantmentLevel.getEnchantmentLevel(value));

        return enchants;
    }
}
