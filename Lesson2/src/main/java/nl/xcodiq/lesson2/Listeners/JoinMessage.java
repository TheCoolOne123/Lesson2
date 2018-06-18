package nl.xcodiq.lesson2.Listeners;

import nl.xcodiq.lesson2.Main;
import nl.xcodiq.lesson2.Utils.ChatUtils;
import nl.xcodiq.lesson2.Utils.Packets.PacketManager;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class JoinMessage implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        if (!(player.hasPlayedBefore())) {
            event.setJoinMessage(null);
            Bukkit.broadcastMessage(ChatUtils.format(Main.getInstance().getConfig().getString("first-join").replaceAll("%USERNAME%", player.getName()).replaceAll("%PLAYER%", player.getDisplayName())));
            PacketManager.sendTitle(player, ChatUtils.format("&9&lLesson&6&l2"), ChatUtils.format("&7Welcome, &b" + player.getName() + "&7. Enjoy your stay!"), 5, 7, 5);
        } else {
            event.setJoinMessage(ChatUtils.format(Main.getInstance().getConfig().getString("join").replaceAll("%USERNAME%", player.getName()).replaceAll("%PLAYER%", player.getDisplayName())));
            PacketManager.sendTitle(player, ChatUtils.format("&9&lLesson&6&l2"), ChatUtils.format("&7Welcome back, &b" + player.getName() + "&7."), 5, 7, 5);
        }
    }
}
