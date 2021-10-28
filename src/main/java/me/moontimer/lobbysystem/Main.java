package me.moontimer.lobbysystem;

import me.moontimer.lobbysystem.commands.SetCommand;
import me.moontimer.lobbysystem.items.ItemListener;
import me.moontimer.lobbysystem.listener.BlockListener;
import me.moontimer.lobbysystem.listener.JoinListener;
import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {

    public static Main instance;
    public static String prefix = "§cLobby | ";

    @Override
    public void onEnable() {

        PluginManager pluginManager = Bukkit.getPluginManager();

        // Plugin startup logic
        instance = this;

        pluginManager.registerEvents(new ItemListener(), this);
        pluginManager.registerEvents(new JoinListener(), this);
        pluginManager.registerEvents(new BlockListener(), this);

        getCommand("set").setExecutor(new SetCommand());

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public static Main getInstance() {
        return instance;
    }
}
