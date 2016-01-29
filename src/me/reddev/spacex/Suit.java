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
    private ItemStack helm;

    public Suit(Player _player) {
        player = _player;
        helm.setType(Material.IRON_HELMET);
    }

    public boolean isWearing() {
        if(player.getInventory().getHelmet().getType().equals(helm)) {
            player.sendMessage("Oxygen Setup Valid!");

            return true;
        } else {
            player.sendMessage("bye");
            player.setHealth(0.0);
            return false;
        }
    }
}
