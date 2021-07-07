package us.outerworlds.galacticcore.management;

import org.bukkit.entity.Player;

public class EconomyManagement {

    public static int getXP(Player player) { return player.getTotalExperience(); }

    public static int convertXPToLevel(int xp) {
        if (xp <= 255) return xp / 17;
        else if (xp > 272 && xp < 887) return (int) ((Math.sqrt(24 * xp - 5159) + 59) / 6);
        else if (xp > 825) return (int) ((Math.sqrt(56 * xp - 32511) + 303) / 14);

        return 0;
    }

    public static boolean hasEnoughXP(Player player, int xp) { return getXP(player) >= xp; }

    public static void addXP(Player player, int xp) {
        player.setTotalExperience(getXP(player) + xp);
        player.setLevel(convertXPToLevel(getXP(player)));
    }

    public static void removeXP(Player player, int xp) {
        player.setTotalExperience(getXP(player) - xp);
        player.setLevel(convertXPToLevel(getXP(player)));
    }

    public static void resetPlayerXP(Player player) {
        player.setTotalExperience(0);
        player.setLevel(0);
    }
}
