package us.outerworlds.galacticcore.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import us.outerworlds.galacticcore.GalacticCore;
import us.outerworlds.galacticcore.gui.GUI;
import us.outerworlds.galacticcore.gui.guis.EnchanterGUI;
import us.outerworlds.galacticcore.utils.Utils;

public class EnchanterCommand implements CommandExecutor {

    private final GalacticCore plugin;

    public EnchanterCommand() {
        plugin = GalacticCore.getPlugin(GalacticCore.class);
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage(Utils.translate("&cYou must be a player to use that command."));
            return true;
        }

        EnchanterGUI gui = new EnchanterGUI((Player) sender, 9, "&8Enchanter");
        gui.setupGUI();
        GUI.openGUI(gui.getGui());

        return true;
    }
}
