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

    //Create the hashmap to be later used for saving the drops
    public HashMap<UUID, ItemStack[]> items = new HashMap<UUID , ItemStack[]>();

    @EventHandler
    public void onPlayerDeath(PlayerDeathEvent e) {
        //Check if player keeps the inventory
        if (!e.getKeepInventory()) {

            //Create an itemstack that contains the inventory of the player
            ItemStack[] content = e.getEntity().getInventory().getContents();
            //Put the itemstack in the hashmap
            items.put(e.getEntity().getPlayer().getUniqueId(), content);

            //TODO: Actual logic of items



            //Once checks are done, clear the hashmap to avoid performance loss
            items.clear();
        }
        return;
    }

}
