package pw.i6l.spigot.airdrop;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public final class IDropPlugin extends JavaPlugin {

    private static IDropPlugin instance;

    public static Location chest_loc;

    @Override
    public void onEnable() {
        register();
        instance = this;
    }

    @Override
    public void onDisable() {
    }

    private void register() {
        PluginManager pm = Bukkit.getPluginManager();
    }

    public static IDropPlugin getInstance() {return instance;}
}
