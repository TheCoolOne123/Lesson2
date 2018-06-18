package nl.xcodiq.lesson2.Utils;

import org.bukkit.ChatColor;

public class ChatUtils {

    public static String format(String input) {
        return ChatColor.translateAlternateColorCodes('&', input);
    }
}
