package me.reddev.spacex;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.Sign;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.craftbukkit.v1_8_R3.command.ColouredConsoleSender;
import org.bukkit.entity.Fireball;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import com.onarandombox.MultiverseCore.*;

import java.util.ArrayList;


/**
 * The main delegate of the plugin.  Extends JavaPlugin.
 * @author Zachary Mayhew
 * @author Anakin Trotter
 */
public class SpaceX extends JavaPlugin implements Listener{

    /**
     * This is the item that is right clicked on the sign to start the spacecraft
     * Default value is stick
     */
    private Material keyItem = Material.STICK;

    private ArrayList<Craft> crafts = new ArrayList<>();

    public static final Material[] whitelistedBlocks = {

    };

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(this, this);
    }

    @Override
    public void onDisable() {

    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (label.equals("spacex")) {
            String version = this.getDescription().getVersion();
            sender.sendMessage("Running SpaceX Version " + version);
            return true;
        }
        return false;
    }

    @EventHandler(priority=EventPriority.HIGH)
    public void onPlayerInteract(PlayerInteractEvent event){
        Player p = event.getPlayer();
        if(p.getItemInHand().getType() == keyItem){
            if (event.getAction() == Action.RIGHT_CLICK_BLOCK) {
                Block block = event.getClickedBlock();
                if (block.getType() == Material.SIGN) {
                    Sign sign = (Sign) block;
                    if (sign.getLine(0).equalsIgnoreCase("spaceship")) {
                        Craft craft = createCraft(block, p);
                        getServer().broadcastMessage(p.getDisplayName() + " has launched a spacecraft!");
                    }
                }
            }
        }
    }

    public Craft createCraft(Block sign, Player player) {
        boolean isComplete;
        return null;
    }


    /**
     * Called on player move event.  Avoid major calculations here.  Only do things if they are through an if.
     * priority is normal because it also works if they are above 250 blocks.
     * @param m player event
     */
    @EventHandler(priority=EventPriority.NORMAL)
    public void onPlayerMove(PlayerMoveEvent m) {
        // Detects player height and will later move them to space world.
        if(m.getPlayer().getLocation().getBlockY()>=250) {
            m.getPlayer().sendMessage("You are above 250 blocks");
        }
    }

}
