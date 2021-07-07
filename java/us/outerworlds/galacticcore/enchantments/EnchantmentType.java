package us.outerworlds.galacticcore.enchantments;

import org.bukkit.Material;
import us.outerworlds.galacticcore.utils.XMaterial;

import java.util.*;

public enum EnchantmentType {

    ARMOR,
    SWORD,
    AXE,
    BOW,
    FISHING_ROD,
    PICKAXE,
    HOE;

    public static EnchantmentType getEnchantmentType(Enchant enchant) {
        EnchantmentType type = null;

        switch (enchant) {
            case SIMPLE_1:
                type = ARMOR;
                break;
            case SIMPLE_2:
            case ULTIMATE_1:
                type = SWORD;
                break;
            case UNIQUE_1:
                type = AXE;
                break;
            case UNIQUE_2:
            case ULTIMATE_2:
                type = BOW;
                break;
            case ELITE_1:
                type = FISHING_ROD;
                break;
            case ELITE_2:
                type = PICKAXE;
                break;
            case LEGENDARY_1:
            case LEGENDARY_2:
                type = HOE;
                break;
        }

        return type;
    }

    public static Map<Enchant, EnchantmentType> getEnchants() {
        Map<Enchant, EnchantmentType> enchants = new HashMap<>();

        for (Enchant value : Enchant.values())
            enchants.put(value, getEnchantmentType(value));

        return enchants;
    }

    public static Material[] getValidMaterials(EnchantmentType enchantmentType) {
        Material[] materials = new Material[] {};

        switch (enchantmentType) {
            case ARMOR:
                materials = new Material[] {
                        XMaterial.DIAMOND_HELMET.parseMaterial(),
                        XMaterial.DIAMOND_CHESTPLATE.parseMaterial(),
                        XMaterial.DIAMOND_CHESTPLATE.parseMaterial(),
                        XMaterial.DIAMOND_LEGGINGS.parseMaterial(),
                        XMaterial.DIAMOND_BOOTS.parseMaterial(),
                        XMaterial.GOLDEN_HELMET.parseMaterial(),
                        XMaterial.GOLDEN_CHESTPLATE.parseMaterial(),
                        XMaterial.GOLDEN_LEGGINGS.parseMaterial(),
                        XMaterial.GOLDEN_BOOTS.parseMaterial(),
                        XMaterial.IRON_HELMET.parseMaterial(),
                        XMaterial.IRON_CHESTPLATE.parseMaterial(),
                        XMaterial.IRON_LEGGINGS.parseMaterial(),
                        XMaterial.IRON_BOOTS.parseMaterial(),
                        XMaterial.CHAINMAIL_HELMET.parseMaterial(),
                        XMaterial.CHAINMAIL_CHESTPLATE.parseMaterial(),
                        XMaterial.CHAINMAIL_LEGGINGS.parseMaterial(),
                        XMaterial.CHAINMAIL_BOOTS.parseMaterial(),
                        XMaterial.LEATHER_HELMET.parseMaterial(),
                        XMaterial.LEATHER_CHESTPLATE.parseMaterial(),
                        XMaterial.LEATHER_LEGGINGS.parseMaterial(),
                        XMaterial.LEATHER_BOOTS.parseMaterial()
                };
                break;
            case SWORD:
                materials = new Material[] {
                        XMaterial.DIAMOND_SWORD.parseMaterial(),
                        XMaterial.GOLDEN_SWORD.parseMaterial(),
                        XMaterial.IRON_SWORD.parseMaterial(),
                        XMaterial.STONE_SWORD.parseMaterial(),
                        XMaterial.WOODEN_SWORD.parseMaterial()
                };
                break;
            case AXE:
                materials = new Material[] {
                        XMaterial.DIAMOND_AXE.parseMaterial(),
                        XMaterial.GOLDEN_AXE.parseMaterial(),
                        XMaterial.IRON_AXE.parseMaterial(),
                        XMaterial.STONE_AXE.parseMaterial(),
                        XMaterial.WOODEN_AXE.parseMaterial()
                };
                break;
            case BOW:
                materials = new Material[] { XMaterial.BOW.parseMaterial() };
                break;
            case FISHING_ROD:
                materials = new Material[] { XMaterial.FISHING_ROD.parseMaterial() };
                break;
            case PICKAXE:
                materials = new Material[] {
                        XMaterial.DIAMOND_PICKAXE.parseMaterial(),
                        XMaterial.GOLDEN_PICKAXE.parseMaterial(),
                        XMaterial.IRON_PICKAXE.parseMaterial(),
                        XMaterial.STONE_PICKAXE.parseMaterial(),
                        XMaterial.WOODEN_PICKAXE.parseMaterial()
                };
                break;
            case HOE:
                materials = new Material[] {
                        XMaterial.DIAMOND_HOE.parseMaterial(),
                        XMaterial.GOLDEN_HOE.parseMaterial(),
                        XMaterial.IRON_HOE.parseMaterial(),
                        XMaterial.STONE_HOE.parseMaterial(),
                        XMaterial.WOODEN_HOE.parseMaterial()
                };
                break;
        }

        return materials;
    }
}
