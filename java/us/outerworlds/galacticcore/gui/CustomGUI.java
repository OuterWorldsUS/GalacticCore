package us.outerworlds.galacticcore.gui;

import org.bukkit.entity.Player;

public abstract class CustomGUI {

    protected GUI gui;
    protected Player player;
    protected int size;
    protected String title;

    public CustomGUI(Player player, int size, String title) {
        this.player = player;
        this.size = size;
        this.title = title;

        gui = new GUI(player, size, title);
    }

    public GUI getGui() { return gui; }
}
