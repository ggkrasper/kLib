package net.krasper.klib.gui;

import net.krasper.klib.KLib;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.List;

public class GUI implements Listener {

    private KLib core;
    private Inventory inv;
    private Sound openSound;

    public GUI(KLib core, int size, String name) {
        this.core = core;
        Bukkit.getServer().getPluginManager().registerEvents(this, core);

        inv = Bukkit.createInventory(null, size, ChatColor.translateAlternateColorCodes('&', name));
    }

    public Inventory getInventory() {
        return inv;
    }

    public void setOpenSound(Sound sound) {
        this.openSound = sound;
    }

    public void setItem(Material material, int amount, String name, List<String> lore, int invItem, boolean hideFlags) {
        ItemStack item = new ItemStack(material, amount);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', name));
        meta.setLore(lore);
        if(hideFlags) {
            meta.addItemFlags(ItemFlag.HIDE_ITEM_SPECIFICS);
            meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
            meta.addItemFlags(ItemFlag.HIDE_ARMOR_TRIM);
            meta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
            meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        }
        item.setItemMeta(meta);
        inv.setItem(invItem, item);
    }

    public ItemStack getItem(int invItem) {

        ItemStack item = inv.getItem(invItem);
        if(item != null) {
            return item;
        }

        return null;
    }

    public void openGUI(Player player) {
        player.openInventory(inv);
        if(openSound != null) {
            player.playSound(player, openSound, 1, 1);
        }
    }

    public boolean isThisInv(Inventory inv) {
        return this.inv == inv;
    }

}
