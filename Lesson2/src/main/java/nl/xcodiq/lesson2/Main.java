package nl.xcodiq.lesson2;

import nl.xcodiq.lesson2.Commands.IAmNew;
import nl.xcodiq.lesson2.Commands.Lesson2;
import nl.xcodiq.lesson2.Listeners.JoinMessage;
import nl.xcodiq.lesson2.Listeners.QuitMessage;
import nl.xcodiq.lesson2.Utils.ChatUtils;
import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public  class Main extends JavaPlugin {

    private static Main plugin;
    private static String prefix = ChatUtils.format("&9&lLesson&6&l2 &7| &a");

    @Override
    public void onEnable() {
        plugin = this;
        loadConfig();
        registerCommands();
        registerListener();
        getServer().getConsoleSender().sendMessage(ChatUtils.format( "&2Lesson2 has been enabled!"));

    }

    private void registerCommands() {
        this.getCommand("iamnew").setExecutor(new IAmNew());
        this.getCommand("lesson2").setExecutor(new Lesson2());
    }

    private void registerListener() {
        PluginManager PM = Bukkit.getServer().getPluginManager();
        PM.registerEvents(new JoinMessage(), this);
        PM.registerEvents(new QuitMessage(), this);
    }

    @Override
    public void onDisable() {
        getServer().getConsoleSender().sendMessage(ChatUtils.format( "&4Lesson2 has been disabled!"));
        saveConfig();
    }

    public static Main getInstance() {
        return plugin;
    }

    public static String getPrefix() {
        return prefix;
    }

    private void loadConfig() {
        saveDefaultConfig();
    }
}
