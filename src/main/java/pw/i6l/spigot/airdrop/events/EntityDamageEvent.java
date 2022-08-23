package pw.i6l.spigot.airdrop.events;

import org.bukkit.entity.FallingBlock;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import pw.i6l.spigot.airdrop.IDropPlugin;

public class EntityDamageEvent implements Listener {

    @EventHandler
    public void onDamage(EntityDamageByEntityEvent e) {
        if(!(e.getDamager() instanceof Player)) return;
        if(!(e.getDamager() instanceof FallingBlock)) return;
        Player p = (Player) e.getDamager(); FallingBlock f = (FallingBlock) e.getEntity();
        if(f.getLocation().equals(IDropPlugin.chest_loc)) {
            e.setCancelled(true);

        }
    }
}
