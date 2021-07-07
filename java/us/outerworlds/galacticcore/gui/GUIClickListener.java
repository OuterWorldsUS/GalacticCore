package us.outerworlds.galacticcore.gui;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import us.outerworlds.galacticcore.GalacticCore;
import us.outerworlds.galacticcore.utils.XMaterial;

public class GUIClickListener implements Listener {

    private final GalacticCore plugin;

    public GUIClickListener() {
        plugin = GalacticCore.getPlugin(GalacticCore.class);
    }

    @EventHandler
    public void onInvClick(InventoryClickEvent event) {
        if (event.getCurrentItem() == null || event.getCurrentItem().getType() == XMaterial.AIR.parseMaterial())
            return;

        if (GUI.open_guis.containsKey(event.getWhoClicked().getUniqueId())) {
            GUI gui = GUI.open_guis.get(event.getWhoClicked().getUniqueId());
            if (gui != null && event.getClickedInventory() != null && event.getClickedInventory().equals(gui.getInventory())) {
                event.setCancelled(true);

                if (gui.getButton(event.getSlot()) != null) {
                    Button button = gui.getButton(event.getSlot());
                    if (button.getAction() != null) button.getAction().run();
                }
            }
        }
    }
}
