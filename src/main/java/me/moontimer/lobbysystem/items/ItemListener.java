package me.moontimer.lobbysystem.items;

import me.moontimer.lobbysystem.utils.LobbyUtils;
import me.moontimer.lobbysystem.utils.LocationHandler;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;

public class ItemListener implements Listener {

    @EventHandler
    public void onClick(PlayerInteractEvent event) {
        Player player = event.getPlayer();
        if (event.getAction().equals(Action.RIGHT_CLICK_AIR) || event.getAction().equals(Action.RIGHT_CLICK_BLOCK)) {
            if (event.getItem().hasItemMeta() && event.getItem() != null) {
                if (event.getItem().getType() == Material.RECORD_6) {
                    setNavItems(player);
                }
                if (event.getItem().getType() == Material.BREWING_STAND_ITEM) {
                    playerHideInv(player);
                }
            }
        }
    }

    @EventHandler
    public void onNavClick(PlayerInteractEvent event) {
        Player player = event.getPlayer();
        if (event.getItem().hasItemMeta() && event.getItem() != null) {
            switch (event.getItem().getType()) {
                case SLIME_BALL:
                    LocationHandler.getandteleport("Spawn", player);
                    LobbyUtils.spawnItems(player);
                    break;
                case STICK:
                    LocationHandler.getandteleport("Practise", player);
                    LobbyUtils.spawnItems(player);
                    break;
                case BED:
                    LocationHandler.getandteleport("BedWars", player);
                    LobbyUtils.spawnItems(player);
                    break;
                case BARRIER:
                    LobbyUtils.spawnItems(player);
                    break;
            }
        }
    }

    @EventHandler
    public void onClick(InventoryClickEvent event){
        Player p = (Player) event.getWhoClicked();
        if(event.getClickedInventory().getTitle().equals("§aSpielerverstecker")){
            event.setCancelled(true);
            if(event.getCurrentItem().getItemMeta().getDisplayName().equals("§aAlle Spieler")){
                for(Player all : Bukkit.getOnlinePlayers()){
                    p.showPlayer(all);
                    p.closeInventory();
                }
            }else if(event.getCurrentItem().getItemMeta().getDisplayName().equals("§4Keine Spieler")){
                for(Player all : Bukkit.getOnlinePlayers()){
                    p.hidePlayer(all);
                    p.closeInventory();
                }
            }
        }
    }

    private static void setNavItems(Player player) {
        player.getInventory().clear();

        player.getInventory().setItem(0, LobbyUtils.createItem(Material.SLIME_BALL, 0, "§aSpawn"));
        player.getInventory().setItem(1, LobbyUtils.createItem(Material.STICK, 0, "§cPractise"));
        player.getInventory().setItem(2, LobbyUtils.createItem(Material.BED, 0, "§fBedWars"));

        player.getInventory().setItem(8, LobbyUtils.createItem(Material.BARRIER, 0, "§cBack"));
    }

    private static void playerHideInv(Player player) {
        Inventory inv = Bukkit.createInventory(null, 9, "§aSpielerverstecker");

        for (int i = 0; i < 9; i++) {
            inv.setItem(i, LobbyUtils.createItem(Material.STAINED_GLASS_PANE, 15, "§6"));
        }


        inv.setItem(2, LobbyUtils.createItem(Material.INK_SACK, 10, "§aAlle Spieler"));
        inv.setItem(6, LobbyUtils.createItem(Material.INK_SACK, 1, "§4Keine Spieler"));

        player.openInventory(inv);
    }
}
