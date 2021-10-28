package me.moontimer.lobbysystem.commands;

import me.moontimer.lobbysystem.Main;
import me.moontimer.lobbysystem.utils.LobbyUtils;
import me.moontimer.lobbysystem.utils.LocationHandler;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SetCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (args.length == 1) {
            if (args[0].equalsIgnoreCase("BedWars")
                    || args[0].equalsIgnoreCase("Practise")
                    || args[0].equalsIgnoreCase("Spawn")) {
                String name = args[0];
                LocationHandler.setLocation(name, (Player) sender);
                sender.sendMessage(Main.prefix + "§7Das Modul §c" + args[0] + "§7 wurde gesetzt.");
            } else {
                sender.sendMessage(Main.prefix + "§7/setmodul §7(BedWars, Practise, Spawn)");
            }
        }
        return false;
    }
}
