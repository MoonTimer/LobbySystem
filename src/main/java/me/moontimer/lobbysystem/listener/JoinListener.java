package me.moontimer.lobbysystem.listener;

import me.moontimer.lobbysystem.utils.LobbyUtils;
import me.moontimer.lobbysystem.utils.LocationHandler;
import me.moontimer.lobbysystem.utils.ScoreboardAPI;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class JoinListener implements Listener {

    @EventHandler(priority = EventPriority.MONITOR)
    public void onJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();

        LocationHandler.getandteleport("Spawn", player);

        createPimmel(player);

        player.setGameMode(GameMode.SURVIVAL);

    }

    @EventHandler
    public void onJoinItems(PlayerJoinEvent event) {
        Player player = event.getPlayer();

        LobbyUtils.spawnItems(player);

    }

    private static void createPimmel(Player player) {
        ScoreboardAPI scoreboardAPI = new ScoreboardAPI(player, "lobby", "§f§lLobby");
        scoreboardAPI.score(7, "§8§m-----------------");
        scoreboardAPI.score(6, "§8» §7Dein Rang");
        scoreboardAPI.score(5, " §8» §4Admin");
        scoreboardAPI.score(4, "§9");
        scoreboardAPI.score(3, "§8» §7Spieler Online");
        scoreboardAPI.score(2, " §8» §a" + Bukkit.getServer().getOnlinePlayers());
        scoreboardAPI.score(1, "§r§8§m-----------------");
    }
}
