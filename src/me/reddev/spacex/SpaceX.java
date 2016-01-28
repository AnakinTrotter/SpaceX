package me.reddev.spacex;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.plugin.java.JavaPlugin;
import com.onarandombox.MultiverseCore.*;


/**
 * The main delegate of the plugin.  Extends JavaPlugin.
 * @author Zachary Mayhew
 * @author Anakin Trotter
 */
public class SpaceX extends JavaPlugin {

    @Override
    public void onEnable() {

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

    /**
     * Called on player move event.  Avoid major calculations here.  Only do things if they are through an if.
     * @param m player event
     */
    public void onMove(PlayerMoveEvent m){
        // Detects player height and will later move them to space world.
        if(m.getPlayer().getLocation().getBlockY()>=250){
            m.getPlayer().sendMessage("You are above or at 250 blocks!");
        }
    }

}
