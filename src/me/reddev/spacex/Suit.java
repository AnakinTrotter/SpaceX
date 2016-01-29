package me.reddev.spacex;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

/**
 * Created by Beakguy2 on 1/28/2016.
 */
public class Suit {
    private Player player;

    public Suit(Player _player) {
        player = _player;
    }

    public boolean isWearing() {
        if(player.getInventory().getHelmet().getType().equals(Material.IRON_HELMET)) {
            player.sendMessage("hi");
            return true;
        } else {
            player.sendMessage("bye");
            return false;
        }
    }
}
