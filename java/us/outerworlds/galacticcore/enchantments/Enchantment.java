package us.outerworlds.galacticcore.enchantments;

import org.bukkit.inventory.ItemStack;
import us.outerworlds.galacticcore.management.EnchantmentManagement;
import us.outerworlds.galacticcore.utils.Utils;

import java.util.*;

public class Enchantment {

    private int multiplier;
    private Enchant enchant;

    public Enchantment(Enchant enchant, int multiplier) {
        this.enchant = enchant;
        this.multiplier = multiplier;
    }

    public Enchant getEnchant() { return enchant; }
    public int getMultiplier() { return multiplier; }
    public String getName() { return enchant.name().toUpperCase(); }
    public EnchantmentType getType() { return EnchantmentType.getEnchants().get(enchant); }

    public static Enchantment generateRandomEnchant(EnchantmentLevel level) {
        List<Enchant> enchants = new ArrayList<>();

        for (Map.Entry<Enchant, EnchantmentLevel> entry : EnchantmentLevel.getEnchants().entrySet()) {
            if (entry.getValue() == level)
                enchants.add(entry.getKey());
        }

        Enchant enchant = enchants.get(new Random().nextInt(enchants.size()));
        int multiplier = EnchantmentManagement.getApplicableLevels(enchant)[new Random().nextInt(EnchantmentManagement.getApplicableLevels(enchant).length)];

        return new Enchantment(enchant, multiplier);
    }

    public static boolean hasEnchantment(ItemStack item, Enchant enchant) {
        return item.getItemMeta().hasLore() && item.getItemMeta().getLore().contains(Utils.translate("&5" + Utils.capitalizeFirst(enchant.name().toLowerCase())));
    }
}
