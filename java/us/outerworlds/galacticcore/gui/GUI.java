package us.outerworlds.galacticcore.gui;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import us.outerworlds.galacticcore.utils.ItemBuilder;
import us.outerworlds.galacticcore.utils.Utils;
import us.outerworlds.galacticcore.utils.XMaterial;

import java.util.*;

public class GUI {

    private Player player;
    private Inventory inventory;

    private static final Map<UUID, GUI> open_guis;
    public Map<Integer, Button> buttons;

    static {
        open_guis = new HashMap<>();
    }

    public GUI(Player player, int size, String title) {
        this.player = player;
        this.inventory = Bukkit.createInventory(null, size, Utils.translate(title));
        this.buttons = new HashMap<>();
    }

    public Player getPlayer() { return player; }
    public Inventory getInventory() { return inventory; }
    public Button getButton(int slot) { return buttons.get(slot); }
    public int getSize() { return inventory.getSize(); }

    public static void openGUI(GUI gui) {
        open_guis.put(gui.getPlayer().getUniqueId(), gui);
        gui.getPlayer().openInventory(gui.getInventory());
    }

    public static void closeGUI(GUI gui) {
        open_guis.remove(gui.getPlayer().getUniqueId());
        gui.getPlayer().closeInventory();
    }

    public void setButton(int slot, Button button) {
        ItemBuilder itemBuilder = new ItemBuilder(button.getItem(), button.getAmount(), Utils.translate(button.getName()), button.getLore());

        inventory.setItem(slot, itemBuilder.getItemStack());
        if (button.getAmount() > 1) {
            for (int i = 1; i < button.getAmount(); i++)
                inventory.addItem(itemBuilder.getItemStack());
        }

        buttons.remove(slot);
        buttons.put(slot, button);
    }

    public void fillInventory(int slots) {
        ItemBuilder itemBuilder = new ItemBuilder(XMaterial.BLACK_STAINED_GLASS_PANE.parseItem(), 1, Utils.translate("&7 "), new ArrayList<>());

        for (int i = 0; i < slots; i++) inventory.setItem(i, itemBuilder.getItemStack());
    }

    public void setFiller(Object slot) {
        ItemBuilder itemBuilder = new ItemBuilder(XMaterial.BLACK_STAINED_GLASS_PANE.parseItem(), 1, Utils.translate("&7 "), new ArrayList<>());

        if (slot instanceof Integer)
            inventory.setItem((int) slot, itemBuilder.getItemStack());
        else if (slot instanceof int[]) {
            for (int i : (int[]) slot)
                inventory.setItem(i, itemBuilder.getItemStack());
        }
    }

    public static Map<UUID, GUI> getOpenGUIs() { return open_guis; }
}
