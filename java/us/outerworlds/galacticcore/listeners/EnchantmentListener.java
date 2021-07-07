package us.outerworlds.galacticcore.listeners;

import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryAction;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import us.outerworlds.galacticcore.GalacticCore;
import us.outerworlds.galacticcore.enchantments.Enchant;
import us.outerworlds.galacticcore.enchantments.Enchantment;
import us.outerworlds.galacticcore.enchantments.EnchantmentLevel;
import us.outerworlds.galacticcore.enchantments.EnchantmentType;
import us.outerworlds.galacticcore.utils.ItemBuilder;
import us.outerworlds.galacticcore.utils.Utils;
import us.outerworlds.galacticcore.utils.XMaterial;

import java.util.*;

public class EnchantmentListener implements Listener {

    public InventoryAction[] validActions = new InventoryAction[] {
            InventoryAction.PLACE_ALL,
            InventoryAction.PICKUP_HALF,
            InventoryAction.PICKUP_ALL,
            InventoryAction.PICKUP_ONE,
            InventoryAction.PICKUP_SOME,
            InventoryAction.SWAP_WITH_CURSOR
    };

    private Map<UUID, Enchantment> clicked_enchantment = new HashMap<>();
    private Map<UUID, ItemStack> clicked_item = new HashMap<>();
    private Map<UUID, ItemStack> clicked_book = new HashMap<>();

    private final GalacticCore plugin;

    public EnchantmentListener() {
        plugin = GalacticCore.getPlugin(GalacticCore.class);
    }

    @EventHandler
    public void onInteract(PlayerInteractEvent event) {
        if (event.getAction() != Action.RIGHT_CLICK_AIR) return;

        if (!event.getItem().getItemMeta().hasLore() || !event.getItem().getItemMeta().getLore().get(0).equalsIgnoreCase(Utils.translate("&7Examine to receive a random")))
            return;

        String[] lore = event.getItem().getItemMeta().getLore().get(1).split(" ");

        Enchantment enchantment = Enchantment.generateRandomEnchant(EnchantmentLevel.valueOf(ChatColor.stripColor(lore[0]).toUpperCase()));

        String enchName = "&f&l" + enchantment.getName() + " " + Utils.getNumeral(enchantment.getMultiplier());
        String[] enchLore = new String[] {
                "&7The &f" + enchantment.getName().toLowerCase() + " &7enchantment book.",
                "&7Level: &f" + enchantment.getMultiplier(),
                "&7Type: &f" + enchantment.getType()
        };

        ItemBuilder itemBuilder = new ItemBuilder(
                XMaterial.BOOK.parseItem(),
                event.getItem().getAmount() - 1,
                enchName,
                ItemBuilder.formatLore(enchLore));

        itemBuilder.give(event.getPlayer(), event.getPlayer().getInventory().getHeldItemSlot());
    }

    @EventHandler
    public void onInvClick(InventoryClickEvent event) {
        if (event.getCurrentItem() == null || event.getCurrentItem().getType() == XMaterial.AIR.parseMaterial())
            return;

        if (!clicked_enchantment.containsKey(event.getWhoClicked().getUniqueId()) && !clicked_item.containsKey(event.getWhoClicked().getUniqueId())) {
            if (!Arrays.asList(validActions).contains(event.getAction())
                    || !event.getCurrentItem().getItemMeta().hasLore()
                    || event.getCurrentItem().getItemMeta().getLore().size() != 3
                    || event.getCurrentItem().getType() != XMaterial.BOOK.parseMaterial()) {
                clicked_book.remove(event.getWhoClicked().getUniqueId());
                clicked_enchantment.remove(event.getWhoClicked().getUniqueId());
                clicked_item.remove(event.getWhoClicked().getUniqueId());
                return;
            }

            List<String> lore = event.getCurrentItem().getItemMeta().getLore();

            if (ChatColor.stripColor(lore.get(2).split(" ")[0]).equalsIgnoreCase("Type:")
                    && ChatColor.stripColor(lore.get(1).split(" ")[0]).equalsIgnoreCase("Level:")) {
                Enchantment enchantment = new Enchantment(Enchant.valueOf(ChatColor.stripColor(lore.get(0).split(" ")[1]).toUpperCase()), Integer.parseInt(ChatColor.stripColor(lore.get(1).split(" ")[1])));

                if (enchantment.getName() != null) {
                    clicked_enchantment.put(event.getWhoClicked().getUniqueId(), enchantment);
                    clicked_book.put(event.getWhoClicked().getUniqueId(), event.getCurrentItem());
                    return;
                }
            }
        }

        if (clicked_enchantment.containsKey(event.getWhoClicked().getUniqueId()) && !clicked_item.containsKey(event.getWhoClicked().getUniqueId())) {
            if (!Arrays.asList(validActions).contains(event.getAction())
                    || event.getCursor().getType() == XMaterial.AIR.parseMaterial()) {
                clicked_book.remove(event.getWhoClicked().getUniqueId());
                clicked_enchantment.remove(event.getWhoClicked().getUniqueId());
                clicked_item.remove(event.getWhoClicked().getUniqueId());
                return;
            }

            clicked_item.put(event.getWhoClicked().getUniqueId(), event.getWhoClicked().getInventory().getItem(event.getSlot()));
            Enchantment enchantment = clicked_enchantment.get(event.getWhoClicked().getUniqueId());

            if (!Arrays.asList(EnchantmentType.getValidMaterials(enchantment.getType())).contains(clicked_item.get(event.getWhoClicked().getUniqueId()).getType())
                    || Enchantment.hasEnchantment(clicked_item.get(event.getWhoClicked().getUniqueId()), enchantment.getEnchant())) {
                clicked_book.remove(event.getWhoClicked().getUniqueId());
                clicked_enchantment.remove(event.getWhoClicked().getUniqueId());
                clicked_item.remove(event.getWhoClicked().getUniqueId());
                return;
            }

            event.setCancelled(true);

            if (event.getWhoClicked().getGameMode() == GameMode.CREATIVE)
                event.getWhoClicked().getInventory().setItem(event.getSlot(), XMaterial.AIR.parseItem());
            else event.getWhoClicked().setItemOnCursor(XMaterial.AIR.parseItem());

            List<String> lore = clicked_item.get(event.getWhoClicked().getUniqueId()).getItemMeta().getLore();
            if (lore == null) lore = new ArrayList<>();

            lore.add("&5" + Utils.capitalizeFirst(enchantment.getName().toLowerCase()));

            String name;
            if (clicked_item.get(event.getWhoClicked().getUniqueId()).getItemMeta().hasDisplayName())
                name = clicked_item.get(event.getWhoClicked().getUniqueId()).getItemMeta().getDisplayName();
            else name = Utils.capitalizeFirst(clicked_item.get(event.getWhoClicked().getUniqueId()).getType().toString().toLowerCase().replace("_", " "));

            ItemBuilder itemBuilder = new ItemBuilder(
                    clicked_item.get(event.getWhoClicked().getUniqueId()),
                    1,
                    "&r" + name,
                    lore);

            itemBuilder.give((Player) event.getWhoClicked(), event.getSlot());

            clicked_book.remove(event.getWhoClicked().getUniqueId());
            clicked_enchantment.remove(event.getWhoClicked().getUniqueId());
            clicked_item.remove(event.getWhoClicked().getUniqueId());
        }
    }
}
