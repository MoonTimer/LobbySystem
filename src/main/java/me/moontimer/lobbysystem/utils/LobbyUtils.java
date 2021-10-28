package me.moontimer.lobbysystem.utils;

import org.bukkit.Color;
import org.bukkit.FireworkEffect;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Firework;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.FireworkMeta;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.LeatherArmorMeta;
import org.bukkit.inventory.meta.SkullMeta;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class LobbyUtils {
    public static ItemStack createItem(Material material, int subid, String displayname){

        ItemStack item = new ItemStack(material, 1, (short) subid);
        ItemMeta mitem = item.getItemMeta();
        mitem.setDisplayName(displayname);
        item.setItemMeta(mitem);

        return item;
    }
    public static ItemStack createDurabilityItem(Material material, int subid, String displayname){

        ItemStack item = new ItemStack(material, 1, (short) subid);
        ItemMeta mitem = item.getItemMeta();
        mitem.setDisplayName(displayname);
        item.setItemMeta(mitem);
        short s = 9999;
        item.setDurability(s);

        return item;
    }

    public static ItemStack createSkull(String displayname, String owner) {

        ItemStack hitem = new ItemStack(Material.SKULL_ITEM, 1, (short)3);
        SkullMeta hmitem = (SkullMeta)hitem.getItemMeta();
        hmitem.setOwner(owner);
        hmitem.setDisplayName(displayname);
        hitem.setItemMeta(hmitem);
        return hitem;
    }
    public static ItemStack createStick(Material material, int subid, String displayname){

        ItemStack item = new ItemStack(material, 1, (short) subid);
        ItemMeta mitem = item.getItemMeta();
        mitem.setDisplayName(displayname);
        item.setItemMeta(mitem);
        item.addEnchantment(Enchantment.KNOCKBACK, 1);

        return item;
    }

    public static ItemStack createid(int id, int subid, String displayname){

        @SuppressWarnings("deprecation")
        ItemStack item = new ItemStack(id);
        ItemMeta mitem = item.getItemMeta();
        mitem.setDisplayName(displayname);
        item.setItemMeta(mitem);

        return item;
    }
    public static ItemStack createEnchItem(Material material, int subid, String displayname, Enchantment ench, int level){

        ItemStack item = new ItemStack(material, 1, (short) subid);
        ItemMeta mitem = item.getItemMeta();
        mitem.setDisplayName(displayname);
        item.setItemMeta(mitem);
        item.addUnsafeEnchantment(ench, level);

        return item;
    }
    public static ItemStack createAnzahlItem(Material material, int subid, String displayname, int Anzahl){

        ItemStack item = new ItemStack(material, Anzahl, (short) subid);
        ItemMeta mitem = item.getItemMeta();
        mitem.setDisplayName(displayname);
        item.setItemMeta(mitem);

        return item;
    }
    public static ItemStack createLore(Material material, int subid, String displayname, String Lore){

        ItemStack item = new ItemStack(material, 1, (short) subid);
        ItemMeta mitem = item.getItemMeta();
        mitem.setDisplayName(displayname);
        List<String> list = new LinkedList<>();
        list.add(Lore);
        mitem.setLore(list);
        item.setItemMeta(mitem);

        return item;
    }
    public static ItemStack createSkull(String displayname, String owner, String lore) {

        ItemStack hitem = new ItemStack(Material.SKULL_ITEM, 1, (short)3);
        SkullMeta hmitem = (SkullMeta)hitem.getItemMeta();
        hmitem.setOwner(owner);
        hmitem.setDisplayName(displayname);
        List<String> list = new LinkedList<>();
        list.add(lore);
        hmitem.setLore(list);
        hitem.setItemMeta(hmitem);
        return hitem;
    }


    public static ItemStack createColorLeather(Material mat, Color meta, String displayname, int subid) {

        ItemStack item = new ItemStack(mat, 1, (short) subid);
        LeatherArmorMeta m = (LeatherArmorMeta) item.getItemMeta();
        m.setColor(meta);
        m.setDisplayName(displayname);
        item.setItemMeta(m);
        return item;


    }


    public static void getDate() {

        Date date = new Date(System.currentTimeMillis() + 86400000L);
        SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy");
        System.out.println(format.format(date));

    }

    public static void createFirework(Player p, Color farbe, Color farbe2, boolean flicker, boolean trail, FireworkEffect.Type feffect, Integer power) {

        Firework firework =  p.getWorld().spawn(p.getLocation(), Firework.class);
        FireworkEffect effect = FireworkEffect.builder()
                .withColor(farbe)
                .flicker(flicker)
                .trail(trail)
                .withFade(farbe2)
                .with(feffect)
                .build();

        FireworkMeta meta = firework.getFireworkMeta();
        meta.addEffect(effect);
        meta.setPower(power);
        firework.setFireworkMeta(meta);

    }

    public static void spawnItems(Player player) {
        player.getInventory().clear();

        player.getInventory().setItem(2, LobbyUtils.createItem(Material.RECORD_6, 0, "§aNavigator"));

        player.getInventory().setItem(4, LobbyUtils.createItem(Material.BARRIER, 0, "§cWer weiß"));

        player.getInventory().setItem(6, LobbyUtils.createItem(Material.BREWING_STAND_ITEM, 0, "§aSpielerverstecker"));
    }




}
