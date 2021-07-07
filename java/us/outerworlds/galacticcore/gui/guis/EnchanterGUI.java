package us.outerworlds.galacticcore.gui.guis;

import org.bukkit.entity.Player;
import us.outerworlds.galacticcore.gui.Button;
import us.outerworlds.galacticcore.gui.CustomGUI;
import us.outerworlds.galacticcore.gui.GUI;
import us.outerworlds.galacticcore.management.EconomyManagement;
import us.outerworlds.galacticcore.utils.ItemBuilder;
import us.outerworlds.galacticcore.utils.Utils;
import us.outerworlds.galacticcore.utils.XMaterial;

public class EnchanterGUI extends CustomGUI {

    public EnchanterGUI(Player player, int size, String title) {
        super(player, size, title);
    }

    public void setupGUI() {
        gui.fillInventory(gui.getSize());

        gui.setButton(2, new Button(
                XMaterial.WHITE_STAINED_GLASS_PANE.parseItem(),
                () -> {
                    if (EconomyManagement.hasEnoughXP(gui.getPlayer(), 500)) {
                        ItemBuilder itemBuilder = new ItemBuilder(
                                XMaterial.BOOK.parseItem(),
                                1,
                                "&f&lSimple Enchantment Book &7(Right Click)",
                                ItemBuilder.formatLore(new String[] {
                                        "&7Examine to receive a random",
                                        "&fsimple &7enchantment book.",
                                })
                        );

                        itemBuilder.give(gui.getPlayer());
                        EconomyManagement.removeXP(gui.getPlayer(), 500);
                    } else {
                        GUI.closeGUI(getGui());
                        gui.getPlayer().sendMessage(Utils.translate("&cYou do not have enough EXP to buy this book!"));
                    }
                },
                "&fSimple Enchantment",
                ItemBuilder.formatLore(new String[] {
                        "&7Examine to receive a random",
                        "&fsimple &7enchantment book.",
                        "&7 ",
                        "&b&lCOST &f400 EXP"
                })
        ));
        gui.setButton(3, new Button(
                XMaterial.LIME_STAINED_GLASS_PANE.parseItem(),
                () -> {
                    if (EconomyManagement.hasEnoughXP(gui.getPlayer(), 800)) {
                        ItemBuilder itemBuilder = new ItemBuilder(
                                XMaterial.BOOK.parseItem(),
                                1,
                                "&a&lUnique Enchantment Book &7(Right Click)",
                                ItemBuilder.formatLore(new String[] {
                                        "&7Examine to receive a random",
                                        "&aunique &7enchantment book.",
                                })
                        );

                        itemBuilder.give(gui.getPlayer());
                        EconomyManagement.removeXP(gui.getPlayer(), 800);
                    } else {
                        GUI.closeGUI(getGui());
                        gui.getPlayer().sendMessage(Utils.translate("&cYou do not have enough EXP to buy this book!"));
                    }
                },
                "&aUnique Enchantment",
                ItemBuilder.formatLore(new String[] {
                        "&7Examine to receive a random",
                        "&asimple &7enchantment book.",
                        "&7 ",
                        "&b&lCOST &f800 EXP"
                })
        ));
        gui.setButton(4, new Button(
                XMaterial.LIGHT_BLUE_STAINED_GLASS_PANE.parseItem(),
                () -> {
                    if (EconomyManagement.hasEnoughXP(gui.getPlayer(), 2500)) {
                        ItemBuilder itemBuilder = new ItemBuilder(
                                XMaterial.BOOK.parseItem(),
                                1,
                                "&b&lElite Enchantment Book &7(Right Click)",
                                ItemBuilder.formatLore(new String[] {
                                        "&7Examine to receive a random",
                                        "&belite &7enchantment book.",
                                })
                        );

                        itemBuilder.give(gui.getPlayer());
                        EconomyManagement.removeXP(gui.getPlayer(), 2500);
                    } else {
                        GUI.closeGUI(getGui());
                        gui.getPlayer().sendMessage(Utils.translate("&cYou do not have enough EXP to buy this book!"));
                    }
                },
                "&bElite Enchantment",
                ItemBuilder.formatLore(new String[] {
                        "&7Examine to receive a random",
                        "&belite &7enchantment book.",
                        "&7 ",
                        "&b&lCOST &f2,500 EXP"
                })
        ));
        gui.setButton(5, new Button(
                XMaterial.YELLOW_STAINED_GLASS_PANE.parseItem(),
                () -> {
                    if (EconomyManagement.hasEnoughXP(gui.getPlayer(), 5000)) {
                        ItemBuilder itemBuilder = new ItemBuilder(
                                XMaterial.BOOK.parseItem(),
                                1,
                                "&e&lUltimate Enchantment Book &7(Right Click)",
                                ItemBuilder.formatLore(new String[] {
                                        "&7Examine to receive a random",
                                        "&eultimate &7enchantment book.",
                                })
                        );

                        itemBuilder.give(gui.getPlayer());
                        EconomyManagement.removeXP(gui.getPlayer(), 5000);
                    } else {
                        GUI.closeGUI(getGui());
                        gui.getPlayer().sendMessage(Utils.translate("&cYou do not have enough EXP to buy this book!"));
                    }
                },
                "&eUltimate Enchantment",
                ItemBuilder.formatLore(new String[] {
                        "&7Examine to receive a random",
                        "&aultimate &7enchantment book.",
                        "&7 ",
                        "&b&lCOST &f5,000 EXP"
                })
        ));
        gui.setButton(6, new Button(
                XMaterial.ORANGE_STAINED_GLASS_PANE.parseItem(),
                () -> {
                    if (EconomyManagement.hasEnoughXP(gui.getPlayer(), 25000)) {
                        ItemBuilder itemBuilder = new ItemBuilder(
                                XMaterial.BOOK.parseItem(),
                                1,
                                "&6&lLegendary Enchantment Book &7(Right Click)",
                                ItemBuilder.formatLore(new String[] {
                                        "&7Examine to receive a random",
                                        "&6legendary &7enchantment book.",
                                })
                        );

                        itemBuilder.give(gui.getPlayer());
                        EconomyManagement.removeXP(gui.getPlayer(), 25000);
                    } else {
                        GUI.closeGUI(getGui());
                        gui.getPlayer().sendMessage(Utils.translate("&cYou do not have enough EXP to buy this book!"));
                    }
                },
                "&6Legendary Enchantment",
                ItemBuilder.formatLore(new String[] {
                        "&7Examine to receive a random",
                        "&6legendary &7enchantment book.",
                        "&7 ",
                        "&b&lCOST &f25,000 EXP"
                })
        ));
    }
}
