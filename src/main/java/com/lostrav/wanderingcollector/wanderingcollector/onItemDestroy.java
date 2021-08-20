package com.lostrav.wanderingcollector.wanderingcollector;

import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class onItemDestroy extends JavaPlugin implements Listener {

    @EventHandler
    public void onItemDestroy(EntityDamageEvent e) {

        if (e.getEntityType().equals(EntityType.DROPPED_ITEM)) {

            //TODO: Check with hashmap for correspondence

        }
        return;

    }

}
