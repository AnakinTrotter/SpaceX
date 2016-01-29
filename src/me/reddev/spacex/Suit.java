package me.reddev.spacex;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

/**
 * Created by Beakguy2 on 1/28/2016.
 */
public class Suit {
    private Player player;
    private Material helm = Material.IRON_HELMET;

    public Suit(Player _player) {
        player = _player;
    }

    public boolean isWearing() {
        if(player.getInventory().getHelmet().getType().equals(helm)) {
            player.sendMessage("Oxygen Setup Valid!");

            return true;
        } else {
            player.sendMessage("bye");
            player.setHealth(0.0);
            player.addPotionEffect(new PotionEffect(PotionEffectType.CONFUSION, 1000000, 10));
            player.addPotionEffect(new PotionEffect(PotionEffectType.WITHER, 1000000, 100));
            return false;
        }
    }
}
