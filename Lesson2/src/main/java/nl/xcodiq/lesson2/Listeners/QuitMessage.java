package nl.xcodiq.lesson2.Listeners;

import nl.xcodiq.lesson2.Main;
import nl.xcodiq.lesson2.Utils.ChatUtils;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class QuitMessage implements Listener {

    @EventHandler
    public void onQuit(PlayerQuitEvent event) {
        Player player = event.getPlayer();
        event.setQuitMessage(ChatUtils.format(Main.getInstance().getConfig().getString("quit").replaceAll("%USERNAME%", player.getName()).replaceAll("%PLAYER%", player.getDisplayName())));
    }
}
