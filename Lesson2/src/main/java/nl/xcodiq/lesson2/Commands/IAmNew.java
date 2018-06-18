package nl.xcodiq.lesson2.Commands;

import nl.xcodiq.lesson2.Main;
import nl.xcodiq.lesson2.Utils.ChatUtils;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class IAmNew implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Player player = (Player) sender;
        if (!(player instanceof Player)) {
            sender.sendMessage(Main.getPrefix() + ChatUtils.format("&cOnly players in-game can use this command!"));
        } else {
            if (command.getName().equalsIgnoreCase("iamnew")) {
                if (args.length == 0) {
                    player.sendMessage(ChatUtils.format(" "));
                    player.sendMessage(ChatUtils.format("&7&l&m---------------"));
                    player.sendMessage(ChatUtils.format(" "));
                    player.sendMessage(ChatUtils.format(" &7» &aNeed help? Ask in chat or join our discord!"));
                    player.sendMessage(ChatUtils.format(" &7» &aDiscord: &6https://discord.gg/P7E4VyE"));
                    player.sendMessage(ChatUtils.format(" "));
                    player.sendMessage(ChatUtils.format("&7&l&m---------------"));
                    player.sendMessage(ChatUtils.format(" "));
                } else {
                    player.sendMessage(Main.getPrefix() + ChatUtils.format("&cToo many args!"));
                }
            }
        }
        return false;
    }
}
