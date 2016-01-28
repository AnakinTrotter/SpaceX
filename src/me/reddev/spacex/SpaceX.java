package me.reddev.spacex;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
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

}
