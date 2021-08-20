package com.lostrav.wanderingcollector.wanderingcollector;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.inventory.ItemStack;
import java.util.logging.Level;

import java.util.HashMap;
import java.util.UUID;

public class onPlayerDeath implements Listener {

    public HashMap<UUID, ItemStack[]> items = new HashMap<UUID , ItemStack[]>();
    @EventHandler
    public void onPlayerDeath(PlayerDeathEvent e) {

        if (!e.getKeepInventory()) {
            Bukkit.broadcastMessage("It's working!");


            ItemStack[] content = e.getEntity().getInventory().getContents();
            items.put(e.getEntity().getPlayer().getUniqueId(), content);



            items.entrySet().forEach(entry -> Bukkit.getLogger().log(Level.INFO, entry.getKey().toString() + ":" + entry.getValue().toString()));
            items.clear();
        }
        return;
    }

}
