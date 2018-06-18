package nl.xcodiq.lesson2.Commands;

import nl.xcodiq.lesson2.Main;
import nl.xcodiq.lesson2.Utils.ChatUtils;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Lesson2 implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Player player = (Player) sender;
        if (command.getName().equalsIgnoreCase("lesson2")) {
            if (args.length == 0) {
                player.sendMessage(ChatUtils.format(" "));
                player.sendMessage(Main.getPrefix() + "Commands list:");
                player.sendMessage(ChatUtils.format("&7&l&m---------------"));
                player.sendMessage(ChatUtils.format(" "));
                player.sendMessage(ChatUtils.format("&7» &aCommand for reloading the configuration file!"));
                player.sendMessage(ChatUtils.format("&7» &aUsage: &6/lesson2 reload&7!"));
                player.sendMessage(ChatUtils.format(" "));
                player.sendMessage(ChatUtils.format("&7» &aNeed help?"));
                player.sendMessage(ChatUtils.format("&7» &aTry the &6/iamnew &acommand!"));
                player.sendMessage(ChatUtils.format("&7&l&m---------------"));
                player.sendMessage(ChatUtils.format(" "));
            } else if (args.length == 1) {
                if (args[0].equalsIgnoreCase("reload")) {
                    Main.getInstance().reloadConfig();
                    player.sendMessage(Main.getPrefix() + ChatUtils.format(ChatUtils.format("&aThe configuration file has been reloaded!")));
                } else {
                    player.sendMessage(ChatUtils.format(Main.getPrefix() + "&cInvalid args!"));
                }
            } else {
                player.sendMessage(ChatUtils.format(Main.getPrefix() + "&cToo many args!"));
            }
        }
        return false;
    }
}
