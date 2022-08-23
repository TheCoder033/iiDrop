package pw.i6l.spigot.airdrop.utils;

import org.apache.commons.lang.math.RandomUtils;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.*;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;
import pw.i6l.spigot.airdrop.IDropPlugin;

public class ChestManager {

    public static Inventory i = Bukkit.createInventory(null, 27, "Мистический сундук");

    public static int selectRandLoc(Entity e) {
        int i = RandomUtils.nextInt(50);
        if(i < e.getLocation().getY()) return selectRandLoc(e); else return i;
    }

    public static void spawnChest(Location loc) {
        ShulkerBullet s = (ShulkerBullet) loc.getWorld().spawnEntity(loc.clone().add(0, 100, 0), EntityType.SHULKER_BULLET);
        s.setGravity(true); s.setInvulnerable(true); s.setFireTicks(50000); Location l = s.getLocation().clone().add(0, selectRandLoc(s), 0);
        loc.getWorld().createExplosion(l, 30);
        FallingBlock f = l.getWorld().spawnFallingBlock(l, Material.ENDER_CHEST.createBlockData());
        f.setGravity(true); f.setInvulnerable(true); f.setCustomNameVisible(true); f.setCustomName("§eМистический сундук");
        new BukkitRunnable() {
            public void run() {
                if(!f.getLocation().add(0, -1, 0).getBlock().getType().equals(Material.AIR)) {
                    s.setGravity(false); IDropPlugin.chest_loc = s.getLocation();
                    this.cancel();
                }
            }
        }.runTaskTimer(IDropPlugin.getInstance(), 0, 20);
    }

    private ItemStack getRandLoot() {
    }

    public static void generateRandLoot() {

    }
}
