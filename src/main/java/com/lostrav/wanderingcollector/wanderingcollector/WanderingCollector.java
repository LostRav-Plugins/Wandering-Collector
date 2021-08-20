package com.lostrav.wanderingcollector.wanderingcollector;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import com.lostrav.wanderingcollector.wanderingcollector.onPlayerDeath;
import com.lostrav.wanderingcollector.wanderingcollector.onItemDestroy;

import java.util.logging.Level;


public final class WanderingCollector extends JavaPlugin {



    //START OF PLUGIN
    @Override
    public void onEnable() {
        // Plugin startup logic
        this.saveDefaultConfig();
        onPlayerDeath deathclass = new onPlayerDeath();
        Bukkit.getPluginManager().registerEvents(deathclass, this);

        onItemDestroy destroyclass = new onItemDestroy();
        Bukkit.getPluginManager().registerEvents(destroyclass, this);

        Bukkit.getLogger().log(Level.INFO, "Wandering Collector ENABLED!");

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
