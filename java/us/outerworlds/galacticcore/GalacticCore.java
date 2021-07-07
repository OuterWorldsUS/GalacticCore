package us.outerworlds.galacticcore;

import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import us.outerworlds.galacticcore.commands.EnchanterCommand;
import us.outerworlds.galacticcore.gui.GUIClickListener;
import us.outerworlds.galacticcore.listeners.EnchantmentListener;
import us.outerworlds.galacticcore.utils.Utils;

public final class GalacticCore extends JavaPlugin {

    private final PluginManager pluginManager = getServer().getPluginManager();

    @Override
    public void onEnable() {
        // Plugin startup logic
        Bukkit.getConsoleSender().sendMessage(Utils.translate("GalacticCore v1.0 by Yochran is loading..."));

        saveDefaultConfig();
        registerListeners();
        registerCommands();

        Bukkit.getConsoleSender().sendMessage(Utils.translate("GalacticCore v1.0 by Yochran has successfully loaded."));
    }

    private void registerListeners() {
        pluginManager.registerEvents(new GUIClickListener(), this);
        pluginManager.registerEvents(new EnchantmentListener(), this);
    }

    private void registerCommands() {
        getCommand("Enchanter").setExecutor(new EnchanterCommand());
    }
}
