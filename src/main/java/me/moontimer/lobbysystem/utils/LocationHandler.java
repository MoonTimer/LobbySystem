package me.moontimer.lobbysystem.utils;

import me.moontimer.lobbysystem.Main;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import java.io.File;
import java.io.IOException;

public class LocationHandler {

    public static void setLocation(String name, Player p) {

        File file = new File("plugins//Lobby//spawns.yml");
        FileConfiguration cfg = YamlConfiguration.loadConfiguration(file);

        String world = p.getLocation().getWorld().getName();
        double x = p.getLocation().getX();
        double y = p.getLocation().getY();
        double z = p.getLocation().getZ();
        double yaw = p.getLocation().getYaw();
        double pitch = p.getLocation().getPitch();

        cfg.set(name + ".world", world);
        cfg.set(name + ".x", x);
        cfg.set(name + ".y", y);
        cfg.set(name + ".z", z);
        cfg.set(name + ".yaw", yaw);
        cfg.set(name + ".pitch", pitch);

        try {
            cfg.save(file);
        } catch (IOException e) {
            e.printStackTrace();
        }



    }

    public static void getandteleport(String name, Player p) {

        try {

            File file = new File("plugins//Lobby//spawns.yml");
            FileConfiguration cfg = YamlConfiguration.loadConfiguration(file);

            String world = cfg.getString(name + ".world");
            double x = cfg.getDouble(name + ".x");
            double y = cfg.getDouble(name + ".y");
            double z = cfg.getDouble(name + ".z");
            double yaw = cfg.getDouble(name + ".yaw");
            double pitch = cfg.getDouble(name + ".pitch");

            if (name == null) {
                return;
            }

            Location loc = new Location(Bukkit.getWorld(world), x, y, z, (float) yaw, (float) pitch);

            p.teleport(loc);

        } catch (Exception e3) {
            p.sendMessage(Main.prefix + "§7Dieses Modul wurde noch §cnicht §7gesetzt.");
        }
    }

    public static void deleteLocation(String name) {

        File file = new File("plugins//Lobby//spawns.yml");
        FileConfiguration cfg = YamlConfiguration.loadConfiguration(file);

        cfg.set(name, null);
        try {
            cfg.save(file);
        } catch (IOException e2) {
            e2.printStackTrace();
        }
    }
}
