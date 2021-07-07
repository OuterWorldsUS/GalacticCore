package us.outerworlds.galacticcore.utils;

import org.bukkit.ChatColor;

public class Utils {

    public static String translate(String message) {
        return ChatColor.translateAlternateColorCodes('&', message);
    }

    public static String getNumeral(int number) {
        String numeral = "I";

        if (number == 0) numeral = "0";
        if (number == 1) numeral = "I";
        if (number == 2) numeral = "II";
        if (number == 3) numeral = "III";
        if (number == 4) numeral = "IV";
        if (number == 5) numeral = "V";

        return numeral;
    }

    public static String capitalizeFirst(String str) {
        String[] words = str.split(" ");
        String capitalizedWord = "";
        for(String character : words){
            String first = character.substring(0,1);
            String afterfirst = character.substring(1);
            capitalizedWord += first.toUpperCase() + afterfirst + " ";
        }
        return capitalizedWord.trim();
    }
}
